package com.gongmo.tourgather.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Foo {

    private static final int MAXIMUM_NAME_LENGTH = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Foo(String name) {
        this.name = name;
    }

    public void modifyName(String name) {
        validateNameLengthIsOverStandard(name);
        this.name = name;
    }

    private void validateNameLengthIsOverStandard(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new RuntimeException(String.format("Foo 이름의 길이는 %d 이하여야 합니다.", MAXIMUM_NAME_LENGTH));
        }
    }
}
