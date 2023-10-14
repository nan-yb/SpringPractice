package com.spring.springpractice.user.repository.board;

import com.spring.springpractice.user.domain.Board;
import com.spring.springpractice.user.domain.User;

import java.util.List;

public interface BoardRepositoryCustom {
    List<Board> getBoardList(User user);
    List<Board> getDetailBoard(Long boardId);
}
