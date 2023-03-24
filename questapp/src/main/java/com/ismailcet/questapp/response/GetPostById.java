package com.ismailcet.questapp.response;

import com.ismailcet.questapp.entities.Post;
import lombok.Data;

@Data
public class GetPostById {
    private Long id;
    private Long userId;
    private String username;
    private String title;
    private String text;


}
