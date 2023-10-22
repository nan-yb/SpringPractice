package com.spring.springpractice.user.service;

import com.spring.springpractice.user.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {

    private final BoardRepository boardRepository;

//    private List<Board> getBoardList(User user) {
//        return boardRepository.getBoardList(user);
//    }



}
