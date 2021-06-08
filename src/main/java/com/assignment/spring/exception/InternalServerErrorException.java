package com.assignment.spring.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends RuntimeException{
    private HttpStatus httpStatus;
    private String body;

    public InternalServerErrorException(String message,HttpStatus httpStatus,String body){
        super(message);
        this.httpStatus=httpStatus;
        this.body=body;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
}
