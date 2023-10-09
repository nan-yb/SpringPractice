package com.spring.springpractice.user.repository.board;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.spring.springpractice.user.domain.board.Board;
import com.spring.springpractice.user.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BoardRepositoryCustomImpl implements BoardRepositoryCustom{


    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<Board> getUserList(User user) {
        return null;
//        return queryFactory.selectFrom().where().fetch();
    }
}
