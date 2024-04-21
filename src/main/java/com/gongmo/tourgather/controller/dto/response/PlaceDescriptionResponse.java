package com.gongmo.tourgather.controller.dto.response;

import com.gongmo.tourgather.repository.entity.PlaceTranslation;

public record PlaceDescriptionResponse(String place, String idol) {

    public static PlaceDescriptionResponse from(PlaceTranslation translation) {
        return new PlaceDescriptionResponse(translation.getDescription(), translation.getIdolDescription());
    }
}
