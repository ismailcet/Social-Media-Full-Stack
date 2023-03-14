package com.ismailcet.questapp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="p_like")
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    private Long postId;

    private Long userId;
}
