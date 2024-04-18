package com.gongmo.tourgather.controller.dto.response;

import com.gongmo.tourgather.repository.entity.Foo;

public record FooResponse(Long id, String name) {

    public static FooResponse from(Foo foo) {
        return new FooResponse(foo.getId(), foo.getName());
    }
}
