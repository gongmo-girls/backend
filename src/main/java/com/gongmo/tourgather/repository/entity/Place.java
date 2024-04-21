package com.gongmo.tourgather.repository.entity;

import static com.gongmo.tourgather.domain.PlaceErrorCode.NOT_EXIST_PLACE_ADDRESS;
import static com.gongmo.tourgather.domain.PlaceErrorCode.NOT_EXIST_PLACE_TRANSLATION;

import java.util.List;
import java.util.Set;

import com.gongmo.tourgather.domain.ImagePlaceType;
import com.gongmo.tourgather.exception.ApplicationException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Set<Address> address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "place_id")
    private Set<PlaceTranslation> placeTranslation;

    @OneToMany
    @JoinColumn(name = "place_id")
    private Set<PlaceHashTag> hashTags;

    @OneToMany
    @JoinColumn(name = "place_id")
    private Set<SingerPlace> singers;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Set<ImagePlace> images;

    private String link;
    private String idolLink;

    private double latitude;
    private double longitude;

    public Address getAddress() {
        return address.stream()
            .findFirst()
            .orElseThrow(() -> new ApplicationException(NOT_EXIST_PLACE_ADDRESS));
    }

    public PlaceTranslation getTranslation() {
        return placeTranslation.stream()
            .findFirst()
            .orElseThrow(() -> new ApplicationException(NOT_EXIST_PLACE_TRANSLATION));
    }

    public List<String> extractImageTo(ImagePlaceType type) {
        return images.stream()
            .filter(image -> image.getImageType().equals(type))
            .map(ImagePlace::getImage)
            .toList();
    }
}
