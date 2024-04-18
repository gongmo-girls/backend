package com.gongmo.tourgather.controller.dto.response;

import com.gongmo.tourgather.repository.entity.Place;

public record PlaceLinkResponse(String place, String idol) {

    public static PlaceLinkResponse from(Place place) {
        return new PlaceLinkResponse(place.getLink(), place.getIdolLink());
    }
}
