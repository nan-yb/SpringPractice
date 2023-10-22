package com.spring.springpractice.conf.response;

public enum Status {
    OK(200 , "OK"),
    BAD_REQUEST(400 , "BAD_REQUEST"),
    NOT_FOUND(404 , "NOT_FOUND"),
    INTERNAL_SERVER_ERROR(500 , "INTERNAL_SERVER_ERROR");

    final int statusCode;
    final String code;

    Status(int statusCode , String code){
        this.statusCode = statusCode;
        this.code = code;
    }
}
