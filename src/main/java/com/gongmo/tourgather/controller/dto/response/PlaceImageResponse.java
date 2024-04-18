package com.gongmo.tourgather.controller.dto.response;

import java.util.List;

import com.gongmo.tourgather.domain.ImagePlaceType;
import com.gongmo.tourgather.repository.entity.Place;

public record PlaceImageResponse(List<String> place, List<String> idol) {

    public static PlaceImageResponse from(Place place) {
        return new PlaceImageResponse(
            place.extractImageTo(ImagePlaceType.BASIC),
            place.extractImageTo(ImagePlaceType.IDOL)
        );
    }
}
