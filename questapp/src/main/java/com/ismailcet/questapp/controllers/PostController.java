package com.ismailcet.questapp.controllers;

import com.ismailcet.questapp.entities.Post;
import com.ismailcet.questapp.request.PostCreateRequest;
import com.ismailcet.questapp.request.UpdatePostRequest;
import com.ismailcet.questapp.response.GetAllPostsResponse;
import com.ismailcet.questapp.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public List<GetAllPostsResponse> getAllPost(@RequestParam Optional<Long> userId){
        return postService.getAllPost(userId);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest postCreateRequest){
        return postService.createPost(postCreateRequest);
    }

    @PutMapping("/{postId}")
    public Post UpdatePostById(@PathVariable Long postId , @RequestBody UpdatePostRequest updatePostRequest){
        return postService.updatePostById(postId , updatePostRequest);
    }

    @DeleteMapping("/{postId}")
    public void DeletePostById(@PathVariable Long postId){
         postService.deletePostById(postId);
    }
}
