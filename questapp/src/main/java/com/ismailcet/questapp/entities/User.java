package com.ismailcet.questapp.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="user")
public class User {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="username")
    private String userName;

    @Column(name="password")
    private String password;
}
