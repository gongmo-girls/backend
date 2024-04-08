package com.gongmo.tourgather.respository.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.gongmo.tourgather.repository.entity.Foo;

class FooTest {

    @DisplayName("이름을 수정한다")
    @Nested
    class modifyName {

        @DisplayName("이름을 성공적으로 수정한다")
        @Test
        void success() {
            // given
            Foo foo = new Foo("foo");
            String newName = "bar";

            // when
            foo.modifyName(newName);

            // then
            assertThat(foo.getName()).isEqualTo(newName);
        }

        @DisplayName("이름 수정 시 기준 길이를 초과하면 에러가 발생한다")
        @Test
        void validateNameLengthIsOverStandard() {
            // given
            Foo foo = new Foo("foo");
            String newName = "bar".repeat(100);

            // when & then
            assertThatThrownBy(() -> foo.modifyName(newName))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이름의 길이는")
                .hasMessageContaining("이하여야 합니다");
        }
    }
}
