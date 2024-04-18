package com.gongmo.tourgather.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gongmo.tourgather.controller.dto.response.ApplicationResponse;
import com.gongmo.tourgather.controller.dto.response.PlaceResponse;
import com.gongmo.tourgather.service.PlaceService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1/places")
@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/{placeId}")
    public ResponseEntity<ApplicationResponse<PlaceResponse>> findById(@PathVariable Long placeId, @RequestParam String lang) {
        PlaceResponse response = placeService.findById(placeId, lang);
        return ResponseEntity.ok(ApplicationResponse.success(response));
    }
}
