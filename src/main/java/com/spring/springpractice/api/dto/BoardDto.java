package com.spring.springpractice.api.dto;

import com.spring.springpractice.api.domain.Board;

public record BoardDto(
    Long boardId ,
    Long usrId ,
    String boardTitle,
    String boardContent
) {

    public static BoardDto of (Long usrId  , String boardTitle , String boardContent){
        return new BoardDto(null , usrId ,  boardTitle , boardContent  );
    }

    public static BoardDto of (Long boardId ,Long usrId, String boardTitle , String boardContent ){
        return new BoardDto(boardId , usrId , boardTitle , boardContent );
    }

    public static BoardDto from(Board entity){
        return new BoardDto(
                entity.getBoardId(),
                entity.getUsrId(),
                entity.getBoardTitle(),
                entity.getBoardContent()
        );
    }

    public BoardDto toEntity(){
        return BoardDto.of(
                boardId ,
                usrId ,
                boardTitle ,
                boardContent
        );
    }


}
