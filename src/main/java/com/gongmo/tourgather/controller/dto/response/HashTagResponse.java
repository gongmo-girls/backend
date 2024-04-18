package com.gongmo.tourgather.controller.dto.response;

import com.gongmo.tourgather.repository.entity.HashTag;

public record HashTagResponse(long id, String name, String description) {

    public static HashTagResponse from(HashTag hashTag) {
        return new HashTagResponse(hashTag.getId(), hashTag.getName(), hashTag.getDescription());
    }
}
