package com.spring.springpractice.conf.response;

import com.spring.springpractice.conf.exception.BizException;
import lombok.Data;

@Data
public class ResponseDTO {

    public final String status;
    public final String message;
    public final Object data;

    public ResponseDTO(Object data){
        this(data, "");
    }

    public ResponseDTO(Object data, String message){
        this.status = ResponseStatus.SUCCESS.str;
        this.message = message;
        this.data = data;
    }

    public ResponseDTO(BizException ex){
        this.status = ResponseStatus.FAIL.str;
        this.message = ex.getMessage();
        this.data = null;
    }

    public ResponseDTO(Throwable ex){
        this.status = ResponseStatus.ERROR.str;
        this.message = ex.getMessage();
        this.data = null;
    }

}
