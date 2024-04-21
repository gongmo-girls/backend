package com.gongmo.tourgather.service;

import static com.gongmo.tourgather.domain.LanguageErrorCode.INVALID_LANGUAGE;
import static com.gongmo.tourgather.domain.PlaceErrorCode.NOT_EXIST_PLACE;
import static com.gongmo.tourgather.fixture.PlaceFixture.MAHOGANY_CAFE_PLACE_KOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gongmo.tourgather.controller.dto.response.PlaceResponse;
import com.gongmo.tourgather.repository.LanguageRepository;
import com.gongmo.tourgather.repository.PlaceRepository;
import com.gongmo.tourgather.repository.entity.Language;
import com.gongmo.tourgather.repository.entity.Place;

@ExtendWith(MockitoExtension.class)
public class PlaceServiceTest {

    @Mock
    private PlaceRepository placeRepository;

    @Mock
    private LanguageRepository languageRepository;

    @InjectMocks
    private PlaceService placeService;

    @DisplayName("Place 를 조회한다")
    @Nested
    class findById {

        @DisplayName("Place 를 성공적으로 조회한다")
        @Test
        void success() {
            // given
            long id = 1L;
            String lang = "kor";

            // mock
            Language language = new Language(lang);
            Place place = MAHOGANY_CAFE_PLACE_KOR.toDomainWithId(id);
            when(languageRepository.findByCode(lang)).thenReturn(Optional.of(language));
            when(placeRepository.findByIdAndLang(id, language)).thenReturn(Optional.of(place));

            // when
            PlaceResponse response = placeService.findById(id, lang);

            // then
            assertThat(response).isNotNull();
        }

        @DisplayName("언어 코드가 존재하지 않을 경우 예외가 발생한다")
        @Test
        void notExistLanguage() {
            // given
            long id = 1L;
            String notExistLang = "notExist";

            // when & then
            assertThatThrownBy(() -> placeService.findById(id, notExistLang))
                .hasMessageContaining(INVALID_LANGUAGE.getMessage());
        }

        @DisplayName("Place 가 존재하지 않을 경우 예외가 발생한다")
        @Test
        void notExistPlace() {
            // given
            long notExistId = 0L;
            String lang = "kor";

            // mock
            Language language = new Language(lang);
            when(languageRepository.findByCode(lang)).thenReturn(Optional.of(language));

            // when & then
            assertThatThrownBy(() -> placeService.findById(notExistId, lang))
                .hasMessage(NOT_EXIST_PLACE.getMessage());
        }
    }
}
