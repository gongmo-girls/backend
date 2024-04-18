package com.gongmo.tourgather.repository.entity;

import static com.gongmo.tourgather.domain.PlaceErrorCode.NOT_EXIST_PLACE_TRANSLATION;

import java.util.List;

import com.gongmo.tourgather.domain.ImagePlaceType;
import com.gongmo.tourgather.exception.ApplicationException;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private List<PlaceTranslation> placeTranslation;

    @OneToMany
    @JoinColumn(name = "place_id")
    private List<PlaceHashTag> hashTags;

    @OneToMany
    @JoinColumn(name = "place_id")
    private List<SingerPlace> singers;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private List<ImagePlace> images;

    private String link;
    private String idolLink;

    private double latitude;
    private double longitude;

    public PlaceTranslation getTranslation() {
        if (placeTranslation == null || placeTranslation.isEmpty()) {
            throw new ApplicationException(NOT_EXIST_PLACE_TRANSLATION);
        }
        return placeTranslation.get(0);
    }

    public List<String> extractImageTo(ImagePlaceType type) {
        return images.stream()
            .filter(image -> image.getImageType().equals(type))
            .map(ImagePlace::getImage)
            .toList();
    }
}
