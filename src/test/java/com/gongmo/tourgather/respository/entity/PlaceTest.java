package com.gongmo.tourgather.respository.entity;

import static com.gongmo.tourgather.domain.PlaceErrorCode.NOT_EXIST_PLACE_ADDRESS;
import static com.gongmo.tourgather.domain.PlaceErrorCode.NOT_EXIST_PLACE_TRANSLATION;
import static com.gongmo.tourgather.fixture.PlaceFixture.MAHOGANY_CAFE_PLACE_KOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.gongmo.tourgather.domain.ImagePlaceType;
import com.gongmo.tourgather.fixture.PlaceFixture;
import com.gongmo.tourgather.repository.entity.Address;
import com.gongmo.tourgather.repository.entity.Place;
import com.gongmo.tourgather.repository.entity.PlaceTranslation;

public class PlaceTest {

    @DisplayName("주소 정보를 조회한다")
    @Nested
    class getAddress {

        @DisplayName("주소 정보를 성공적으로 조회한다")
        @Test
        void success() {
            // given
            PlaceFixture placeFixture = MAHOGANY_CAFE_PLACE_KOR;

            // when
            Address address = placeFixture.toDomain().getAddress();

            // then
            assertThat(placeFixture.getAddress()).contains(address);
        }

        @DisplayName("주소 정보가 없을 경우 예외가 발생한다")
        @Test
        void empty() {
            // given
            Place place = MAHOGANY_CAFE_PLACE_KOR.toDomainWithoutAddress();

            // when & then
            assertThatThrownBy(place::getAddress)
                .hasMessage(NOT_EXIST_PLACE_ADDRESS.getMessage());
        }
    }

    @DisplayName("다국어 정보를 조회한다")
    @Nested
    class getTranslation {

        @DisplayName("다국어 정보를 성공적으로 조회한다")
        @Test
        void success() {
            // given
            PlaceFixture placeFixture = MAHOGANY_CAFE_PLACE_KOR;

            // when
            PlaceTranslation translation = placeFixture.toDomain().getTranslation();

            // then
            assertThat(placeFixture.getPlaceTranslation()).contains(translation);
        }

        @DisplayName("다국어 정보가 없을 경우 예외가 발생한다")
        @Test
        void empty() {
            // given
            Place place = MAHOGANY_CAFE_PLACE_KOR.toDomainWithoutTranslation();

            // when & then
            assertThatThrownBy(place::getTranslation)
                .hasMessage(NOT_EXIST_PLACE_TRANSLATION.getMessage());
        }
    }

    @DisplayName("특정 타입에 맞는 이미지만 추출한다")
    @Nested
    class extractImageTo {

        @DisplayName("특정 타입에 맞는 이미지를 성공적으로 추출한다")
        @Test
        void success() {
            // given
            ImagePlaceType type = ImagePlaceType.IDOL;
            Place place = MAHOGANY_CAFE_PLACE_KOR.toDomain();

            // when & then
            assertThatCode(() -> place.extractImageTo(type))
                .doesNotThrowAnyException();
        }
    }
}
