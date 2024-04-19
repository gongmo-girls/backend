package com.gongmo.tourgather.fixture;

import static com.gongmo.tourgather.fixture.AddressFixture.MAHOGANY_CAFE_ADDRESS_KOR;
import static com.gongmo.tourgather.fixture.PlaceTranslationFixture.MAHOGANY_CAFE_TRANSLATION_KOR;

import java.util.Set;

import com.gongmo.tourgather.repository.entity.Address;
import com.gongmo.tourgather.repository.entity.ImagePlace;
import com.gongmo.tourgather.repository.entity.Place;
import com.gongmo.tourgather.repository.entity.PlaceHashTag;
import com.gongmo.tourgather.repository.entity.PlaceTranslation;
import com.gongmo.tourgather.repository.entity.SingerPlace;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PlaceFixture {

    MAHOGANY_CAFE_PLACE_KOR(
        Set.of(MAHOGANY_CAFE_ADDRESS_KOR.toDomain()),
        Set.of(MAHOGANY_CAFE_TRANSLATION_KOR.toDomain()),
        Set.of(),
        Set.of(),
        Set.of(),
        "https://map.naver.com/p/entry/place/1371876716?c=15.00,0,0,0,dh&placePath=/home",
        "",
        37.568654, 126.9800339),
    ;

    private final Set<Address> address;
    private final Set<PlaceTranslation> placeTranslation;
    private final Set<PlaceHashTag> hashTags;
    private final Set<SingerPlace> singers;
    private final Set<ImagePlace> images;
    private final String link;
    private final String idolLink;
    private final double latitude;
    private final double longitude;

    public Place toDomain() {
        return createBuilder()
            .build();
    }

    public Place toDomainWithId(Long id) {
        return createBuilder()
            .id(id)
            .build();
    }

    private Place.PlaceBuilder createBuilder() {
        return Place.builder()
            .address(address)
            .placeTranslation(placeTranslation)
            .hashTags(hashTags)
            .singers(singers)
            .images(images)
            .link(link)
            .idolLink(idolLink)
            .latitude(latitude)
            .longitude(longitude);
    }
}
