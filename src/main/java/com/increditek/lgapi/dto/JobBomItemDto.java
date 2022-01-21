package com.increditek.lgapi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class JobBomItemDto {
    private Long id;
    private Long poID;
    private String poNumber;
    private long bomItemID;
    private String vendor;
    private String updatedBy;
    private LocalDateTime lastUpdated;
    private String pulledBy;
    private LocalDateTime pulledOn;
    private String receivedBy;
    private LocalDateTime receivedOn;
    private String orderedBy;
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
