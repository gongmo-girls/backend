package com.gongmo.tourgather.respository;

import static com.gongmo.tourgather.fixture.PlaceFixture.MAHOGANY_CAFE_PLACE_KOR;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.gongmo.tourgather.repository.LanguageRepository;
import com.gongmo.tourgather.repository.PlaceRepository;
import com.gongmo.tourgather.repository.entity.Language;
import com.gongmo.tourgather.repository.entity.Place;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class PlaceRepositoryTest {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @DisplayName("원하는 언어 코드의 장소 정보를 조회한다")
    @Nested
    class findByIdAndLang {

        @DisplayName("Place Entity 를 성공적으로 조회한다")
        @Test
        void success() {
            // given
            Place savedPlace = placeRepository.save(MAHOGANY_CAFE_PLACE_KOR.toDomain());

            // when
            Optional<Place> place = placeRepository.findByIdAndLang(savedPlace.getId(), savedPlace.getAddress().getLanguage());

            // then
            assertThat(place).isPresent();
        }

        @DisplayName("장소 아이디에 해당하는 정보가 없을 경우 빈 값이 조회된다")
        @Test
        void notExist() {
            // given
            long notExistId = 0L;
            Language savedLanguage = languageRepository.save(new Language("kor"));

            // when
            Optional<Place> place = placeRepository.findByIdAndLang(notExistId, savedLanguage);

            // then
            assertThat(place).isEmpty();
        }
    }
}
