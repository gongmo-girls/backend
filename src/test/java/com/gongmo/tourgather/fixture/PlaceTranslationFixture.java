package com.gongmo.tourgather.fixture;

import static com.gongmo.tourgather.fixture.LanguageFixture.KOR;

import com.gongmo.tourgather.repository.entity.Language;
import com.gongmo.tourgather.repository.entity.PlaceTranslation;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PlaceTranslationFixture {

    MAHOGANY_CAFE_TRANSLATION_KOR(
        KOR.toDomain(),
        "마호가니 광화문 케이스퀘어시티점",
        "21:30 에 라스트 오더",
        "공모걸즈 첫 모임 장소 :)",
        ""),
    ;

    private final Language language;
    private final String name;
    private final String openTime;
    private final String description;
    private final String idolDescription;

    public PlaceTranslation toDomain() {
        return PlaceTranslation.builder()
            .language(language)
            .name(name)
            .openTime(openTime)
            .description(description)
            .idolDescription(idolDescription)
            .build();
    }
}
