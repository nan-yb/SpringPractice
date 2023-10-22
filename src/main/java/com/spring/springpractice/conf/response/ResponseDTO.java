package com.spring.springpractice.conf.response;

import lombok.Data;

@Data
public class Message {
    private Enum<Status> status;
    private String message;
    private Object data;

    public Message() {
        this.status = Status.BAD_REQUEST;
        this.data = null;
        this.data = null;
    }

}
