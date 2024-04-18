package com.gongmo.tourgather.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gongmo.tourgather.repository.entity.Language;
import com.gongmo.tourgather.repository.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query(
        "select p "
            + "from Place p "
            + "left join fetch p.placeTranslation t "
            + "where p.id = :id "
            + "and t.language = :language "
    )
    Optional<Place> findByIdWithLang(Long placeId, Language language);
}
