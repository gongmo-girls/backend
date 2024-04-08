package com.gongmo.tourgather.service;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gongmo.tourgather.controller.dto.request.FooRequest;
import com.gongmo.tourgather.repository.FooRepository;
import com.gongmo.tourgather.repository.entity.Foo;

@ExtendWith(MockitoExtension.class)
class FooServiceTest {

    @Mock
    private FooRepository fooRepository;

    @InjectMocks
    private FooService fooService;

    @DisplayName("Foo 객체를 저장한다")
    @Nested
    class insert {

        @DisplayName("Foo 객체를 성공적으로 저장한다")
        @Test
        void success() {
            // given
            String name = "foo";
            FooRequest fooDto = new FooRequest(name);

            // mock
            when(fooRepository.save(any())).thenReturn(new Foo(1L, name));

            // when & then
            assertThatCode(() -> fooService.insert(fooDto))
                .doesNotThrowAnyException();
        }
    }
}
