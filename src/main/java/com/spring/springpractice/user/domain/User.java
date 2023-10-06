package com.spring.springpractice.user.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@ToString
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" , nullable = false)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    @Column(name="rog_date")
    private LocalDateTime rogDate;

    @Column(name="mod_date")
    private LocalDateTime modDate;

}
