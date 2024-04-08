package com.gongmo.tourgather.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gongmo.tourgather.controller.dto.request.FooRequest;
import com.gongmo.tourgather.controller.dto.response.FooResponse;
import com.gongmo.tourgather.controller.dto.response.ApplicationResponse;
import com.gongmo.tourgather.service.FooService;

@RequestMapping("/api/foo")
@RestController
@RequiredArgsConstructor
public class FooController {

    private final FooService fooService;

    @GetMapping
    public ResponseEntity<ApplicationResponse<String>> welcome() {
        return ResponseEntity.ok(ApplicationResponse.success("success"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationResponse<FooResponse>> find(@PathVariable Long id) {
        return ResponseEntity.ok(ApplicationResponse.success(fooService.find(id)));
    }

    @PostMapping
    public ResponseEntity<ApplicationResponse<FooResponse>> insert(@RequestBody FooRequest request) {
        return ResponseEntity.ok(ApplicationResponse.success(fooService.insert(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApplicationResponse<Long>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(ApplicationResponse.success(fooService.delete(id)));
    }
}
