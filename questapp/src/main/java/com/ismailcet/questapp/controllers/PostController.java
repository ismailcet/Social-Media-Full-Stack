package com.ismailcet.questapp.controllers;

import com.ismailcet.questapp.entities.Post;
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
    public List<Post> getAllPost(@RequestParam Optional<Long> userId){
        return postService.getAllPost(userId);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody Post post){
        return postService.createPost(post);
    }
}
