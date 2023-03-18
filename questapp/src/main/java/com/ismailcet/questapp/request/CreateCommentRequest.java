package com.ismailcet.questapp.request;

import lombok.Data;

@Data
public class CreateCommentRequest {
    private Long id;
    private Long userId;
    private Long postId;
    private String text;
}
