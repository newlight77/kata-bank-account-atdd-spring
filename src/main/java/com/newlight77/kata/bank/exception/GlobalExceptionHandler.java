package com.newlight77.kata.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
        NotAllowedException.class
    })
    public Object handle400(HttpServletRequest request, Exception ex) {
        return ExceptionDetail.builder()
                .classname(ex.getClass().getName())
                .date(LocalDateTime.now().toString())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .params(request.getQueryString())
                .build();
    }

}
