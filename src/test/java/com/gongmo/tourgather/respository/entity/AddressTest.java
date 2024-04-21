package com.gongmo.tourgather.respository.entity;

import static com.gongmo.tourgather.fixture.AddressFixture.MAHOGANY_CAFE_ADDRESS_KOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.gongmo.tourgather.repository.entity.Address;

public class AddressTest {

    @DisplayName("전체 주소 정보를 조회한다")
    @Nested
    class getFullAddress {

        @DisplayName("전체 주소 정보를 성공적으로 조회한다")
        @Test
        void success() {
            // given
            Address address = MAHOGANY_CAFE_ADDRESS_KOR.toDomain();

            // when
            String fullAddress = address.getFullAddress();

            // then
            assertAll(
                () -> assertThat(fullAddress).contains(
                    address.getSido(),
                    address.getSigungu(),
                    address.getRoad(),
                    address.getDetail()),
                () -> assertThat(fullAddress).doesNotContain(address.getZipcode()));
        }
    }
}
