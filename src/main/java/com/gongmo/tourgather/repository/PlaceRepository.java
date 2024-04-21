package com.gongmo.tourgather.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gongmo.tourgather.repository.entity.Language;
import com.gongmo.tourgather.repository.entity.Place;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query(
        "select p "
            + "from Place p "
            + "left join fetch p.address a "
            + "left join fetch p.placeTranslation t "
            + "left join fetch p.hashTags h "
            + "left join fetch p.singers s "
            + "left join fetch p.images i "
            + "where p.id = :id "
            + "and t.language = :language "
    )
    Optional<Place> findByIdAndLang(@Param("id") Long id, @Param("language") Language language);
}
