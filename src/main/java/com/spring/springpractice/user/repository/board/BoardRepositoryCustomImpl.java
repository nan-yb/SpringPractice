package com.spring.springpractice.user.repository.board;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.springpractice.user.domain.Board;
import com.spring.springpractice.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.spring.springpractice.user.domain.QBoard.board;
import static com.spring.springpractice.user.domain.QComment.comment;
public class BoardRepositoryCustomImpl extends QuerydslRepositorySupport implements BoardRepositoryCustom{
    public BoardRepositoryCustomImpl() {
        super(Board.class);
    }

    @Override
    public List<Board> getBoardList(User user) {
        return from(board).where( board.usrId.eq(user.getId())).fetch();
    }

    @Override
    public List<Board> getDetailBoard(Long boardId) {
        return from(board)
                .leftJoin(  board.commentList ,  comment)
                .where(board.boardId.eq(boardId))
                .fetch();
    }


}
