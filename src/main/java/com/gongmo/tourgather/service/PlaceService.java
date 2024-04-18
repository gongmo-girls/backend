package com.gongmo.tourgather.service;

import static com.gongmo.tourgather.domain.LanguageErrorCode.INVALID_LANGUAGE;
import static com.gongmo.tourgather.domain.PlaceErrorCode.NOT_EXIST_PLACE;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gongmo.tourgather.controller.dto.response.PlaceResponse;
import com.gongmo.tourgather.exception.ApplicationException;
import com.gongmo.tourgather.repository.LanguageRepository;
import com.gongmo.tourgather.repository.PlaceRepository;
import com.gongmo.tourgather.repository.entity.Language;
import com.gongmo.tourgather.repository.entity.Place;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final LanguageRepository languageRepository;

    @Transactional(readOnly = true)
    public PlaceResponse findById(Long placeId, String lang) {
        Language language = findLanguage(lang);
        Place savedPlace = findPlaceById(placeId, language);
        return PlaceResponse.from(savedPlace, savedPlace.getTranslation());
    }

    private Language findLanguage(String lang) {
        return languageRepository.findByCode(lang)
            .orElseThrow(() -> new ApplicationException(INVALID_LANGUAGE));
    }

    private Place findPlaceById(Long placeId, Language language) {
        return placeRepository.findByIdWithLang(placeId, language)
            .orElseThrow(() -> new ApplicationException(NOT_EXIST_PLACE));
    }
}
