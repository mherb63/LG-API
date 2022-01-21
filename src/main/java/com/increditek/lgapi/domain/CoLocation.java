package com.increditek.lgapi.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class CoLocation {

    private String coName;
    private String coAddress;
    private String coCity;
    private String coState;
    @Column(columnDefinition = "decimal(9,6)")
    Double coGeoLat;
    @Column(columnDefinition = "decimal(9,6)")
    Double coGeoLong;
}
