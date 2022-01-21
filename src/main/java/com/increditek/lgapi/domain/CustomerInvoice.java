package com.increditek.lgapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jobinvoicepayments")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
@EqualsAndHashCode(exclude = {"job", "purchaseOrder", "customer"}, callSuper = false)
public class CustomerInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobID")
    @NotFound(action=NotFoundAction.IGNORE)
    @JsonIgnore
    private Job job;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "poID")
    @NotFound(action= NotFoundAction.IGNORE)
    @JsonIgnore
    private CustomerPurchaseOrder purchaseOrder;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerID")
    @NotFound(action=NotFoundAction.IGNORE)
    @JsonIgnore
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journalEntryID")
    @NotFound(action=NotFoundAction.IGNORE)
    @JsonIgnore
    private JournalEntry journalEntry;

    private InvoiceItem invoiceItem;
    private LocalDate sentOn;
    private LocalDate paidOn;
    private String receiptId;
    private String depositTicketId;
}
