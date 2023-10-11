package com.spring.springpractice.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@ToString
@Table(name = "comment")
@Entity
public class Comment extends AuditingFields{

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name="comment_id" , nullable = false)
    private Long commentId;

    @Column(name="board_id" , nullable = false)
    private Long boardId ;

    @Column(name="usr_id" , nullable = false)
    private Long usrId ;

    @Column(name="comment_content" , nullable = false)
    private String commentContent;

}
