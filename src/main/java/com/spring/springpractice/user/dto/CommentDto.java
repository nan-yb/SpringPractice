package com.spring.springpractice.user.dto;

import com.spring.springpractice.user.domain.Board;
import com.spring.springpractice.user.domain.Comment;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public record CommentDto(
    Long commentId ,

    Long boardId ,
    Long usrId ,
    String commentContent,
    LocalDateTime rog_date,
    LocalDateTime mod_date
) {


    public static CommentDto of (Long usrId  , Long  boardId , String commentContent  ){
        return new CommentDto(null , usrId ,  boardId , commentContent , null , null);
    }

    public static CommentDto of (Long commentId , Long boardId , Long usrId, String commentContent, LocalDateTime rog_date , LocalDateTime mod_date){
        return new CommentDto(commentId , boardId , usrId , commentContent , rog_date , mod_date);
    }

    public static CommentDto from(Comment entity){
        return new CommentDto(
                entity.getCommentId(),
                entity.getBoardId(),
                entity.getUsrId(),
                entity.getCommentContent(),
                entity.getRogDate(),
                entity.getModDate()
        );
    }

    public CommentDto toEntity(){
        return CommentDto.of(
                commentId ,
                boardId ,
                usrId ,
                commentContent,
                rog_date,
                mod_date
        );
    }
}
