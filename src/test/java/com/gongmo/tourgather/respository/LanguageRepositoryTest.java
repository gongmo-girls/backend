package com.gongmo.tourgather.respository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.gongmo.tourgather.repository.LanguageRepository;
import com.gongmo.tourgather.repository.entity.Language;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class LanguageRepositoryTest {

    @Autowired
    private LanguageRepository languageRepository;

    @DisplayName("언어 코드를 이용하여 Language 를 조회한다")
    @Nested
    class findByCode {

        @DisplayName("Language Entity 를 성공적으로 조회한다")
        @Test
        void success() {
            // given
            String lang = "kor";
            languageRepository.save(new Language(lang));

            // when
            Optional<Language> language = languageRepository.findByCode(lang);

            // then
            assertThat(language).isPresent();
        }

        @DisplayName("존재하지 않는 언어 코드로 조회하는 경우 빈 값이 조회된다")
        @Test
        void notExist() {
            // given
            String notExistLang = "notExist";

            // when
            Optional<Language> language = languageRepository.findByCode(notExistLang);

            // then
            assertThat(language).isEmpty();
        }
    }
}
