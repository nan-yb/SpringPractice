package com.spring.springpractice.user.controller;

import com.spring.springpractice.conf.response.Message;
import com.spring.springpractice.conf.response.Status;
import com.spring.springpractice.user.domain.board.Board;
import com.spring.springpractice.user.service.board.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;


    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListBoard(){

        Message msg = new Message();
//        msg.setData();
        msg.setStatus(Status.OK);

        return new ResponseEntity<Message>(msg , null , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?>  createBoard(@RequestBody Board board){
        return null;
    }

}
