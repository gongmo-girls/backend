package com.gongmo.tourgather.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.gongmo.tourgather.controller.dto.request.FooRequest;
import com.gongmo.tourgather.controller.dto.response.FooResponse;
import com.gongmo.tourgather.service.FooService;

@RequestMapping("/api/foo")
@RestController
@RequiredArgsConstructor
public class FooController {

    private final FooService fooService;

    @GetMapping("/{id}")
    public FooResponse find(@PathVariable Long id) {
        return fooService.find(id);
    }

    @PostMapping
    public FooResponse insert(@RequestBody FooRequest request) {
        return fooService.insert(request);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        return fooService.delete(id);
    }
}
