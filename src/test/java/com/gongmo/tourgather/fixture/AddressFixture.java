package com.gongmo.tourgather.fixture;

import static com.gongmo.tourgather.fixture.LanguageFixture.KOR;

import com.gongmo.tourgather.repository.entity.Address;
import com.gongmo.tourgather.repository.entity.Language;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AddressFixture {

    MAHOGANY_CAFE_ADDRESS_KOR(KOR.toDomain(), "서울특별시", "중구", "청계천로 24", "1층", "04521"),
    ;

    private final Language language;
    private final String sido;
    private final String sigungu;
    private final String road;
    private final String detail;
    private final String zipcode;

    public Address toDomain() {
        return Address.builder()
            .language(language)
            .sido(sido)
            .sigungu(sigungu)
            .road(road)
            .detail(detail)
            .zipcode(zipcode)
            .build();
    }
}
