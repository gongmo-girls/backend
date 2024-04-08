package com.gongmo.tourgather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gongmo.tourgather.repository.entity.Foo;

@Repository
public interface FooRepository extends JpaRepository<Foo, Long> {
}
