package com.gongmo.tourgather.controller.dto.response;

import com.gongmo.tourgather.repository.entity.Foo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FooResponse {

    private final Long id;
    private final String name;

    public static FooResponse from(Foo foo) {
        return new FooResponse(foo.getId(), foo.getName());
    }
}
