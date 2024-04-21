package com.gongmo.tourgather.domain;

import org.springframework.http.HttpStatus;

import com.gongmo.tourgather.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LanguageErrorCode implements ErrorCode {

    INVALID_LANGUAGE("L0001", HttpStatus.BAD_REQUEST, "존재하지 않는 언어 코드입니다."),
    ;

    private final String code;
    private final HttpStatus httpStatus;
    private final String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public HttpStatus getStatusCode() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
