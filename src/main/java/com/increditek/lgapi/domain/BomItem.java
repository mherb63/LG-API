package com.increditek.lgapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bomitems")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
@EqualsAndHashCode(exclude = {"updatedByUser"}, callSuper = false)
public class BomItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updatedByUserId")
    @JsonIgnore
    private User updatedByUser;

    private Boolean isDeleted;
    private String vendor;
    private String itemId;
    private String itemType;
    private String description;
    private String um;
    private BigDecimal cost;
    private LocalDate costUpdateDate;
    private Integer leadWeeks;
}