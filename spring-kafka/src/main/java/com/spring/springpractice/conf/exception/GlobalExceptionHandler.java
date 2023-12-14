package com.spring.springpractice.conf.exception;

import com.spring.springpractice.conf.response.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    protected ResponseEntity<?> handleMethodArgumentNotValidException(BizException ex) {
        ResponseDTO dto = null;
        dto = new ResponseDTO(ex);
        return new ResponseEntity<ResponseDTO>(dto , null , HttpStatus.BAD_REQUEST);
    }
}