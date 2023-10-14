package com.spring.springpractice.user.controller;

import com.spring.springpractice.conf.response.Message;
import com.spring.springpractice.conf.response.Status;
import com.spring.springpractice.user.domain.User;
import com.spring.springpractice.user.dto.BoardDto;
import com.spring.springpractice.user.dto.CommentDto;
import com.spring.springpractice.user.repository.board.BoardRepository;
import com.spring.springpractice.user.service.board.BoardService;
import com.spring.springpractice.user.service.comment.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;


    public BoardController(BoardService boardService , BoardRepository boardRepository ) {
        this.boardService = boardService;
        this.boardRepository = boardRepository;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListBoard(@RequestBody User user){
        Message msg = new Message();
        msg.setStatus(Status.OK);
        msg.setData(boardRepository.getBoardList(user));
        return new ResponseEntity<Message>(msg , null , HttpStatus.OK);
    }


    @GetMapping("/detail")
    public ResponseEntity<?> getDetailBoard(@RequestParam Long boardId){
        Message msg = new Message();
        msg.setStatus(Status.OK);
        msg.setData(boardService.getBoardWithComment(boardId));
        return new ResponseEntity<Message>(msg , null , HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?>  createBoard(@RequestBody BoardDto board){
        Message msg = new Message();
        msg.setStatus(Status.OK);
        boardService.saveBoard(board);
        return new ResponseEntity<Message>(msg , null , HttpStatus.OK);
    }

    @PostMapping("/comment/create")
    public ResponseEntity<?>  createComment(@RequestBody CommentDto comment){
        Message msg = new Message();
        msg.setStatus(Status.OK);
        boardService.saveComment(comment);
        return new ResponseEntity<Message>(msg , null , HttpStatus.OK);
    }

    @DeleteMapping("/comment/deleteAll")
    public ResponseEntity<?>  deleteAll(@RequestBody CommentDto comment){
        Message msg = new Message();
        msg.setStatus(Status.OK);
        boardService.deleteAllComment(comment.boardId());
        return new ResponseEntity<Message>(msg , null , HttpStatus.OK);
    }

    @DeleteMapping("/comment/delete")
    public ResponseEntity<?>  deleteById(@RequestBody CommentDto comment){
        Message msg = new Message();
        msg.setStatus(Status.OK);
        boardService.deleteCommentByCommentId(comment.commentId());
        return new ResponseEntity<Message>(msg , null , HttpStatus.OK);
    }


}
