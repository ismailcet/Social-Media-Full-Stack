package com.ismailcet.questapp.response;

import com.ismailcet.questapp.entities.Post;
import lombok.Data;

@Data
public class GetAllPostsResponse {

    private Long id;
    private Long userId;
    private String username;
    private String title;
    private String text;

    public GetAllPostsResponse(Post post){
        this.id = post.getId();
        this.userId=post.getUser().getId();
        this.username=post.getUser().getUserName();
        this.title= post.getTitle();
        this.text= post.getText();
    }
}
