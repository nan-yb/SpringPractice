package com.spring.springpractice.user.domain.board;

import com.spring.springpractice.user.domain.AuditingFields;
import com.spring.springpractice.user.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "board")
@Entity
public class Board extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="board_id" , nullable = false)
    private Long boardId;

    @Column(name="usr_id" , nullable = false)
    private Long usrId;

    @Column(name="board_title")
    private String boardTitle;

    @Column(name="board_content")
    private String boardContent;

}
