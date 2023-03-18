package com.ismailcet.questapp.service;

import com.ismailcet.questapp.entities.Comment;
import com.ismailcet.questapp.entities.Post;
import com.ismailcet.questapp.entities.User;
import com.ismailcet.questapp.repository.CommentRepository;
import com.ismailcet.questapp.request.CreateCommentRequest;
import com.ismailcet.questapp.request.UpdateCommentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserService userService;
    private final PostService postService;
    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId) {
        if(userId.isPresent() && postId.isPresent()){
            return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }else if (userId.isPresent()){
            return commentRepository.findByUserId(userId.get());
        }else if (postId.isPresent()){
            return commentRepository.findByPostId(postId.get());
        }else{
            return commentRepository.findAll();
        }
    }

    public Comment getCommentByCommentId(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(CreateCommentRequest createCommentRequest) {
        User user = userService.getUserById(createCommentRequest.getUserId());
        Post post = postService.getPostById(createCommentRequest.getPostId());
        if(user !=null && post !=null){
            Comment comment = new Comment();
            comment.setId(createCommentRequest.getId());
            comment.setPost(post);
            comment.setUser(user);
            comment.setText(createCommentRequest.getText());
            return commentRepository.save(comment);
        }
        return null;
    }

    public Comment updateCommentByCommentId(Long commentId , UpdateCommentRequest updateCommentRequest) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isPresent()){
            Comment commentToUpdate = comment.get();
            commentToUpdate.setText(updateCommentRequest.getText());
            return commentRepository.save(commentToUpdate);
        }else{
            return null;
        }
    }

    public void deleteCommentByCommentId(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
