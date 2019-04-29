package com.newlight77.kata.bank.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Data
public class ExceptionDetail {
    private String classname;
    private String date;
    private String message;
    private String path;
    private String params;
}

