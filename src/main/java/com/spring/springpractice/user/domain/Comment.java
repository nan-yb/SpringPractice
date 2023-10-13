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
