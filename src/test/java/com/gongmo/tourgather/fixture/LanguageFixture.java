package com.gongmo.tourgather.fixture;

import com.gongmo.tourgather.repository.entity.Language;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum LanguageFixture {

    KOR("kor"),
    ;

    private final String code;

    private Language language;

    public Language toDomain() {
        if (language == null) {
            language = new Language(code);
        }
        return language;
    }
}
