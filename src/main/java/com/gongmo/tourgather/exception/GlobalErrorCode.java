package com.gongmo.tourgather.exception;

import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum GlobalErrorCode implements ErrorCode {

    GLOBAL_ERROR("G0001", HttpStatus.INTERNAL_SERVER_ERROR, "서버에서 문제가 발생했습니다."),
    SPRING_VALIDATION_ERROR("G0002", HttpStatus.BAD_REQUEST, "잘못된 입력값입니다."),

    // rest template
    HTTP_CLIENT_ERROR("G0003", HttpStatus.BAD_REQUEST, "외부 API 와의 연동에 실패하였습니다. 입력값을 확인해주세요."),
    HTTP_SERVER_ERROR("G0004", HttpStatus.BAD_REQUEST, "외부 API 서버가 불안정하여 연동에 실패하였습니다. 다시 시도해주세요."),
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
