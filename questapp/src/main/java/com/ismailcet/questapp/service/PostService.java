package com.ismailcet.questapp.service;

import com.ismailcet.questapp.entities.Post;
import com.ismailcet.questapp.entities.User;
import com.ismailcet.questapp.repository.PostRepository;
import com.ismailcet.questapp.request.PostCreateRequest;
import com.ismailcet.questapp.request.UpdatePostRequest;
import com.ismailcet.questapp.response.GetAllPostsResponse;
import com.ismailcet.questapp.response.GetPostById;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public List<GetAllPostsResponse> getAllPost(Optional<Long> userId){

        if(userId.isPresent()){
            return postRepository.findByUserId(userId.get())
                    .stream()
                    .map(p->new GetAllPostsResponse(p))
                    .collect(Collectors.toList());
        }else{
            return postRepository.findAll()
                    .stream()
                    .map(p->new GetAllPostsResponse(p))
                    .collect(Collectors.toList());
        }
    }

    public Post getPostById(Long postId){
        return postRepository.findById(postId).orElse(null);
    }

    public Post createPost(PostCreateRequest postCreateRequest) {
        User user = userService.getUserById(postCreateRequest.getUserId());
        if(user == null){
            return null;
        }
        Post toSave = new Post();
        toSave.setId(postCreateRequest.getId());
        toSave.setText(postCreateRequest.getText());
        toSave.setTitle(postCreateRequest.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    public Post updatePostById(Long postId , UpdatePostRequest updatePostRequest) {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent()){
            Post toUpdate = post.get();
            toUpdate.setText(updatePostRequest.getText());
            toUpdate.setTitle(updatePostRequest.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }

        return null;
    }

    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
