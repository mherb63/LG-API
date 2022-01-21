package com.increditek.lgapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "journalentryitems")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
public class JournalEntryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "journalEntryID")
    @JsonIgnore
    private JournalEntry journalEntry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chartOfAccountID")
    @NotFound(action= NotFoundAction.IGNORE)
    @JsonIgnore
    private ChartOfAccount chartOfAccount;

    private String invoiceId;
    private String description;
    private BigDecimal amountDebit;
    private BigDecimal amountCredit;
    private String glCode;
    private String division;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobID")
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonIgnore
    private Job job;

    private String poNumber;
    private String receiptId;
    private String depositTicketId;
    private String paymentReferenceId;
    private LocalDate reconciledOn;

}
