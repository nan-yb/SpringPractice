package com.spring.springpractice.user.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter @Setter
@NoArgsConstructor
@ToString
@Table(name = "user")
@Entity
public class User extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" , nullable = false)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="name")
    private String name;

    private User(Long id , String email , String name , LocalDateTime rogDate , LocalDateTime modDate){
        this.id = id;
        this.email = email;
        this.name = name;
        this.rogDate = rogDate;
        this.modDate = modDate;
    }

    public static User of ( String email , String name){
        return new User(null , email , name , null , null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User that)) return false;
        return this.getId() != null && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }


}
