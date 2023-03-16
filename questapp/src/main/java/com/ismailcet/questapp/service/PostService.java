package com.ismailcet.questapp.service;

import com.ismailcet.questapp.entities.Post;
import com.ismailcet.questapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPost(Optional<Long> userId){
        if(userId.isPresent()){
            return postRepository.findByUserId(userId.get());
        }
        return postRepository.findAll();
    }

    public Post getPostById(Long postId){
        return postRepository.findById(postId).orElse(null);
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}
