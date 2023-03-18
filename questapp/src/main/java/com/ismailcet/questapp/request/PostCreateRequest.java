package com.ismailcet.questapp.request;

import lombok.Data;

@Data
public class PostCreateRequest {

    private Long id;
    private String text;
    private String title;
    private Long userId;

}
