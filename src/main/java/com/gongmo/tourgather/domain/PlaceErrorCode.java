package com.gongmo.tourgather.domain;

import org.springframework.http.HttpStatus;

import com.gongmo.tourgather.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PlaceErrorCode implements ErrorCode {

    NOT_EXIST_PLACE("P0001", HttpStatus.BAD_REQUEST, "존재하지 않는 장소입니다."),
    NOT_EXIST_PLACE_TRANSLATION("P0002", HttpStatus.BAD_REQUEST, "장소의 다국어 정보가 존재하지 않습니다."),
    NOT_EXIST_PLACE_ADDRESS("P0003", HttpStatus.BAD_REQUEST, "장소의 주소 정보가 존재하지 않습니다."),
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
