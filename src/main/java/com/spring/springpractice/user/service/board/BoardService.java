package com.spring.springpractice.user.service.board;

import com.spring.springpractice.user.domain.board.Board;
import com.spring.springpractice.user.domain.user.User;
import com.spring.springpractice.user.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {

    private BoardRepository boardRepository;

    private List<Board> getBoardList(User user) {

        return null;
    }
}
