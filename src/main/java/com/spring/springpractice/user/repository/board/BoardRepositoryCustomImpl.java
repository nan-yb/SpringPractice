package com.spring.springpractice.user.repository.board;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.springpractice.user.domain.Board;
import com.spring.springpractice.user.domain.QBoard;
import com.spring.springpractice.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Stream;

public class BoardRepositoryCustomImpl implements BoardRepositoryCustom{


    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<Board> getBoardList(User user) {
        QBoard qBoard = QBoard.board;
        return queryFactory.selectFrom(qBoard).where( qBoard.usrId.eq(user.getId())).fetch();
    }
}
