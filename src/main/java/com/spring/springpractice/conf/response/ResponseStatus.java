package com.spring.springpractice.conf.response;

public enum ResponseStatus {
    SUCCESS("success"),
    FAIL("fail"),
    ERROR("error");

    public final String str;
    private ResponseStatus(String str){
        this.str = str;
    }
}
