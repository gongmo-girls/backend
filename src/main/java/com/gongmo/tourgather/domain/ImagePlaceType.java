package com.gongmo.tourgather.domain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ImagePlaceType {

    BASIC("basic", "장소 관련 이미지"),
    IDOL("idol", "아이돌 관련 이미지"),
    ;

    private final String code;
    private final String description;
}
