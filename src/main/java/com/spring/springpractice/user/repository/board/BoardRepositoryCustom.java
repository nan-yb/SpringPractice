package com.spring.springpractice.user.repository.board;

import com.spring.springpractice.user.domain.board.Board;
import com.spring.springpractice.user.domain.user.User;

import java.util.List;

public interface BoardRepositoryCustom {
    List<Board> getUserList(User user);

}
