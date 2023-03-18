package com.ismailcet.questapp.controllers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.ismailcet.questapp.entities.Comment;
import com.ismailcet.questapp.request.CreateCommentRequest;
import com.ismailcet.questapp.request.UpdateCommentRequest;
import com.ismailcet.questapp.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
                                       @RequestParam Optional<Long> postId){

        return commentService.getAllComments(userId , postId);
    }
    @GetMapping("/{commentId}")
    public Comment getCommentByCommentId(@PathVariable Long commentId){
        return commentService.getCommentByCommentId(commentId);
    }

    @PostMapping
    public Comment createComment(@RequestBody CreateCommentRequest createCommentRequest){
        return commentService.createComment(createCommentRequest);
    }
    @PutMapping("/{commentId}")
    public Comment updateCommentByCommentId(@PathVariable Long commentId , @RequestBody UpdateCommentRequest updateCommentRequest){
        return commentService.updateCommentByCommentId(commentId , updateCommentRequest);
    }

    @DeleteMapping("/{commentId}")
    public void deleteCommentByCommentId(@PathVariable Long commentId){
        commentService.deleteCommentByCommentId(commentId);
    }
}
