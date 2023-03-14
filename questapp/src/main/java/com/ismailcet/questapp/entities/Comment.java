package com.ismailcet.questapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="comment")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    private Long postId;

    private Long userId;

    @Lob
    @Column(columnDefinition = "text")
    private String text;

}
