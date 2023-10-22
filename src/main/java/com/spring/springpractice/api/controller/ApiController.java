package com.spring.springpractice.api.controller;

import com.spring.springpractice.api.domain.Board;
import com.spring.springpractice.conf.response.ResponseDTO;
import com.spring.springpractice.api.repository.BoardRepository;
import com.spring.springpractice.api.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class ApiController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    public ApiController(BoardService boardService , BoardRepository boardRepository ) {
        this.boardService = boardService;
        this.boardRepository = boardRepository;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListBoard(){

        ResponseDTO dto = null;
        dto = new ResponseDTO(null);

        return new ResponseEntity<ResponseDTO>(dto , null , HttpStatus.OK);
    }



}
