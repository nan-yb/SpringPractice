package com.spring.springpractice.user.domain;

import com.spring.springpractice.user.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Board extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private Long usrId;

    private String boardTitle;

    private String boardContent;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    private Board(Long boardId , Long usrId , String boardTitle  , String boardContent,  LocalDateTime rogDate , LocalDateTime modDate){
        this.boardId = boardId;
        this.usrId = usrId;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.rogDate = rogDate;
        this.modDate = modDate;
    }

    public static Board of (Long usrId ,  String boardTitle , String boardContent ){
        return new Board(null , usrId , boardTitle ,boardContent ,null , null);
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
