package com.assignment.spring.dtos;


public class ErrorOutput {
    private final int code;
    private final String serviceName;
    private final String message;
    public ErrorOutput(int code, String serviceName, String message) {
        this.code = code;
        this.serviceName = serviceName;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getServiceName() {
        return serviceName;
    }
    public String getMessage() {
        return message;
    }
    
}
