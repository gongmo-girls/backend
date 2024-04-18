package com.gongmo.tourgather.controller.dto.response;

import com.gongmo.tourgather.repository.entity.Singer;

public record SingerResponse(long id, String name, String group) {

    public static SingerResponse from(Singer singer) {
        return new SingerResponse(singer.getId(), singer.getName(), singer.getGroup());
    }
}
