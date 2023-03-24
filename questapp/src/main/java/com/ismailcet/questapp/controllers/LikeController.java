package com.ismailcet.questapp.controllers;

import com.ismailcet.questapp.entities.Like;
import com.ismailcet.questapp.request.CreateLikeRequest;
import com.ismailcet.questapp.service.LikeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/likes")
public class LikeController {

    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> userId ,
                                  @RequestParam Optional<Long> postId){
        return likeService.getAllLikes(userId,postId);
    }

    @PostMapping
    public Like createLike(@RequestBody CreateLikeRequest createLikeRequest){
        return likeService.createLike(createLikeRequest);
    }

    @GetMapping("/{likeId}")
    public Like getLikeById(@PathVariable Long likeId){
        return likeService.getLikeById(likeId);
    }

    @DeleteMapping("/{likeId}")
    public void deleteLikeById(@PathVariable Long likeId){
        likeService.deleteLikeById(likeId);
    }

}
