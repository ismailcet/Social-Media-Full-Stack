package com.ismailcet.questapp.service;

import com.ismailcet.questapp.entities.Like;
import com.ismailcet.questapp.entities.Post;
import com.ismailcet.questapp.entities.User;
import com.ismailcet.questapp.repository.LikeRepository;
import com.ismailcet.questapp.request.CreateLikeRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserService userService;
    private final PostService postService;

    public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<Like> getAllLikes(Optional<Long> userId, Optional<Long> postId) {
        List<Like> list;
        if(userId.isPresent() && postId.isPresent()){
            list = likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }else if(userId.isPresent()){
            list = likeRepository.findByUserId(userId.get());
        }else if(postId.isPresent()){
            list = likeRepository.findByPostId(postId.get());
        }else{
            list = likeRepository.findAll();
        }
        return list;
    }

    public Like createLike(CreateLikeRequest createLikeRequest) {
        User user = userService.getUserById(createLikeRequest.getUserId());
        Post post = postService.getPostById(createLikeRequest.getPostId());

        if(user != null && post !=null){
            Like like = new Like();
            like.setId(createLikeRequest.getId());
            like.setUser(user);
            like.setPost(post);

            return likeRepository.save(like);
        }else{
            return null;
        }
    }

    public Like getLikeById(Long likeId) {
        return likeRepository.findById(likeId).orElse(null);
    }

    public void deleteLikeById(Long likeId) {
        likeRepository.deleteById(likeId);
    }
}
