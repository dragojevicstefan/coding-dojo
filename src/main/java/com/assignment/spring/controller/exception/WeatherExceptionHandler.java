package com.assignment.spring.controller.exception;

import com.assignment.spring.dtos.ErrorOutput;
import com.assignment.spring.exception.InternalServerErrorException;
import com.assignment.spring.exception.NotFoundErrorException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WeatherExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(NotFoundErrorException.class)
    protected ResponseEntity<Object> handleNotFoundException(NotFoundErrorException exception,WebRequest webRequest){
        return handleExceptionInternal(exception, new ErrorOutput(1, exception.getMessage(), exception.getBody()), new HttpHeaders(), exception.getHttpStatus(), webRequest);
    }

    @ExceptionHandler(InternalServerErrorException.class)
    protected ResponseEntity<Object> handleInternalServerError(InternalServerErrorException exception,WebRequest webRequest){
        return handleExceptionInternal(exception, new ErrorOutput(2, exception.getMessage(), exception.getBody()), new HttpHeaders(), exception.getHttpStatus(), webRequest);
    }


}
