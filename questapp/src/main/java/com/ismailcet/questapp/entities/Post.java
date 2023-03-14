package com.ismailcet.questapp.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="post")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long userId;

    private String title;

    @Lob
    @Column(columnDefinition = "text")
    private String text;


}
