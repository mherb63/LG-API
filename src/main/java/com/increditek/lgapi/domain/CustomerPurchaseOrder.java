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
@Table(name = "jobpurchaseorders")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
@EqualsAndHashCode(exclude = {"job"}, callSuper = false)
public class CustomerPurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobID")
    @JsonIgnore
    private Job job;

    private String number;
    private Boolean isChangeOrder;
    private LocalDate receivedOn;
    //private BigDecimal amount;
    private BigDecimal installation;
    private BigDecimal engineering;
    private BigDecimal transportation;
    private BigDecimal materials;
    private BigDecimal warehousing;
    private BigDecimal salesTax;
    private Boolean isInvoiced;
    private Boolean isPaid;
}