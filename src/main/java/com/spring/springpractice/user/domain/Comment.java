package com.spring.springpractice.user.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@NoArgsConstructor
@ToString
@Entity
public class Comment extends AuditingFields{

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long commentId;

    private Long boardId ;

    @ManyToOne(optional = false)
    private Board board; // 게시글 (ID)

    private Long usrId ;

    private String commentContent;


    private Comment(Long commentId , Long boardId ,  Long usrId , String commentContent , LocalDateTime rogDate , LocalDateTime modDate){
        this.commentId = commentId;
        this.boardId = boardId;
        this.usrId = usrId;
        this.commentContent = commentContent;
        this.rogDate = rogDate;
        this.modDate = modDate;
    }

    public static Comment of ( Long boardId , Long usrId ,  String commentContent){
        return new Comment(null , boardId , usrId  , commentContent , null , null );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment that)) return false;
        return this.getCommentId() != null && this.getCommentId().equals(that.getCommentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getCommentId());
    }


}
