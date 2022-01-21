package com.increditek.lgapi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class JobSupplierInvoiceDto {
    private Long poID;
    private String poNumber;
    private Long vendorID;
    private String vendor;
    private String invoiceId;
    private BigDecimal amount;
    private BigDecimal installation;
    private BigDecimal engineering;
    private BigDecimal transportation;
    private BigDecimal materials;
    private BigDecimal warehousing;
    private BigDecimal salesTax;
    private String paymentId;
    private String voucherId;
    private LocalDate receivedOn;
    private LocalDate dueOn;
    private LocalDate paidOn;
    private String paymentReferenceId;
    private String paymentAccountId;
    private String paymentDiscrepancyReason;
    private Boolean paymentCleared;
    private String notes;
}
