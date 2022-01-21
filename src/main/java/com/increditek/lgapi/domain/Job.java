package com.increditek.lgapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
@EqualsAndHashCode(exclude = {"customerPurchaseOrders", "customerInvoices"}, callSuper = false)
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    private Boolean isArchived;
    private String number;
    private String type;
    private String division;
    private CoLocation coLocation;
    private String teo;
    private Integer ccr;
    private String jobDescription;
    private String status;
    private String invoice;
    private Integer paymentTerms;
    private String wbNumber;
    private Boolean barcodeRequired;
    private Boolean barcodeCompleted;
    private String barcode;
    private String barcodeEnteredBy;
    private JobDates dates;
    private JobQuality quality;
    private Boolean advanceCompletionNotified;
    private Boolean completionNotified;
    private Boolean trashRemoved;
    private Boolean bomUploaded;
    private Boolean bomCalledOut;
    private Boolean tbomCalledOut;
    private Boolean t100received;
    private Boolean teoApproved;
    private ChangeOrder changeOrder;
    private Integer engineeringHours;
    private Integer materialsHours;
    private Integer installationHours;
    private Integer qualityHours;
    private String oopExpensesDescription;
    private BigDecimal oopExpenseTotal;
    private Boolean engCompleteWoIcon;

    @OneToOne
    @JoinColumn(name = "glContact")
    private Contact glContact;

    @OneToOne
    @JoinColumn(name = "feContact")
    private Contact feContact;

    @OneToOne
    @JoinColumn(name = "vmContact")
    private Contact vmContact;

    @OneToOne
    @JoinColumn(name = "coeContact")
    private Contact coeContact;

    @OneToOne
    @JoinColumn(name = "cosContact")
    private Contact cosContact;

    @OneToOne
    @JoinColumn(name = "tlContact")
    private Contact tlContact;

    @OneToOne
    @JoinColumn(name = "itekEContact")
    private Contact itekEContact;

    @OneToOne
    @JoinColumn(name = "itekSContact")
    private Contact itekSContact;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @OrderBy(value = "receivedOn DESC")
    @JsonIgnore
    private List<CustomerPurchaseOrder> customerPurchaseOrders  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CustomerInvoice> customerInvoices  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<JobSupplierPurchaseOrder> supplierPurchaseOrders  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<JobSupplierInvoice> supplierInvoices  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @OrderBy(value = "logDate DESC")
    @JsonIgnore
    private List<JobEventLog> eventLogs  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @OrderBy(value = "expenseDate DESC")
    @JsonIgnore
    private List<ExpenseReportItem> expenseReportItems  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @OrderBy(value = "logDate DESC")
    @JsonIgnore
    private List<MaterialLog> materialLogs = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @OrderBy(value = "date DESC")
    @JsonIgnore
    private List<JobOutOfPocketExpenseItem> outOfPocketExpenseItems  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @OrderBy(value = "noteDate DESC")
    @JsonIgnore
    private List<JobInvoiceNote> invoiceNotes  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @OrderBy(value = "logDate DESC")
    @JsonIgnore
    private List<JobLog> logs  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @OrderBy(value = "number")
    @JsonIgnore
    private List<JobChangeOrder> changeOrders  = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "job", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<JobBomItem> bomItems  = new ArrayList<>();
}

