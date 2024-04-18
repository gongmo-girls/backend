package com.gongmo.tourgather.controller.dto.response;

import java.util.List;

import com.gongmo.tourgather.repository.entity.Place;
import com.gongmo.tourgather.repository.entity.PlaceHashTag;
import com.gongmo.tourgather.repository.entity.PlaceTranslation;
import com.gongmo.tourgather.repository.entity.SingerPlace;

public record PlaceResponse(
    long id, String name, String address, String openTime,
    PlaceLinkResponse link, List<HashTagResponse> hashtag, List<SingerResponse> singer,
    PlaceDescriptionResponse description, PlaceImageResponse image) {

    public static PlaceResponse from(Place place, PlaceTranslation translation) {
        return new PlaceResponse(
            place.getId(), translation.getName(), place.getAddress().getFullAddress(), translation.getOpenTime(),
            PlaceLinkResponse.from(place),
            place.getHashTags().stream()
                .map(PlaceHashTag::getHashTag)
                .map(HashTagResponse::from)
                .toList(),
            place.getSingers().stream()
                .map(SingerPlace::getSinger)
                .map(SingerResponse::from)
                .toList(),
            PlaceDescriptionResponse.from(translation),
            PlaceImageResponse.from(place)
        );
    }
}
