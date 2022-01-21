package com.increditek.lgapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jobsupplierinvoicepayments")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
@EqualsAndHashCode(exclude = {"Job"}, callSuper = false)
public class JobSupplierInvoice {

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
    private JobSupplierPurchaseOrder purchaseOrder;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendorID")
    private Vendor vendor;

    private InvoiceItem invoiceItem;
    private LocalDate receivedOn;
    private LocalDate dueOn;
    private LocalDate paidOn;
    private String paymentReferenceId;
    private String paymentAccountId;
    private String paymentDiscrepancyReason;
    private Boolean paymentCleared;
    private String notes;
}
