package com.spring.springpractice.api.controller;

import com.spring.springpractice.api.domain.Board;
import com.spring.springpractice.api.service.ApiService;
import com.spring.springpractice.conf.response.ResponseDTO;
import com.spring.springpractice.api.repository.BoardRepository;
import com.spring.springpractice.api.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final BoardService boardService;
    private final ApiService apiService;

    public ApiController(BoardService boardService , ApiService apiService ) {
        this.boardService = boardService;
        this.apiService = apiService;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getListBoard(){

        ResponseDTO dto = null;
        dto = new ResponseDTO(apiService.callTourListAPI());

        return new ResponseEntity<ResponseDTO>(dto , null , HttpStatus.OK);
    }



}
