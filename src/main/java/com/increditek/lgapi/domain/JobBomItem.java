package com.increditek.lgapi.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "jobbom")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
@EqualsAndHashCode(exclude = {"updatedBy", "pulledBy", "receivedBy", "orderedBy"}, callSuper = false)
public class JobBomItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobID")
    @JsonIgnore
    private Job job;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poID")
    @JsonIgnore
    private CustomerPurchaseOrder purchaseOrder;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bomItemID")
    @JsonIgnore
    private BomItem bomItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lastUpdatedBy")
    @JsonIgnore
    private User updatedBy;
    private LocalDateTime lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pulledBy")
    @JsonIgnore
    private User pulledBy;
    private LocalDateTime pulledOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receivedBy")
    @JsonIgnore
    private User receivedBy;
    private LocalDateTime receivedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderedBy")
    @JsonIgnore
    private User orderedBy;
    private LocalDateTime orderedOn;

    private String partNumber;
    private String partDescription;
    private BigDecimal unitCost;
    private BigDecimal itekUnitCost;
    private Integer qty;
    private String um;
    private LocalDate estShip;
    private LocalDate actShip;
    private Boolean isInvoiced;
    private String notes;
    private String shipNotes;
    private Integer qtyOrdered;
    private Integer qtyInStock;
    private Integer qtyRec;
    private LocalDate dateRec;
    private Short coNumber;
}