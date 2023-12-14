package com.spring.springpractice.api.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Board  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private Long usrId;

    private String boardTitle;

    private String boardContent;

    private Board(Long boardId , Long usrId , String boardTitle  , String boardContent){
        this.boardId = boardId;
        this.usrId = usrId;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board that)) return false;
        return this.getBoardId() != null && this.getBoardId().equals(that.getBoardId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getBoardId());
    }

}
