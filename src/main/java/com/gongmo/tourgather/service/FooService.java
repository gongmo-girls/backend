package com.gongmo.tourgather.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongmo.tourgather.controller.dto.request.FooRequest;
import com.gongmo.tourgather.controller.dto.response.FooResponse;
import com.gongmo.tourgather.repository.FooRepository;
import com.gongmo.tourgather.repository.entity.Foo;

@Service
@Transactional
@RequiredArgsConstructor
public class FooService {

    private final FooRepository fooRepository;

    public FooResponse find(Long id) {
        return fooRepository.findById(id)
            .map(FooResponse::from)
            .orElseThrow(NullPointerException::new);
    }

    public FooResponse insert(FooRequest request) {
        Foo foo = new Foo(request.getName());
        Foo savedFoo = fooRepository.save(foo);
        return FooResponse.from(savedFoo);
    }

    public Long delete(Long id) {
        fooRepository.deleteById(id);
        return id;
    }
}
