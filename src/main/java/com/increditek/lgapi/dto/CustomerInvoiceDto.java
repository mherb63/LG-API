package com.increditek.lgapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInvoiceDto {
    private Long id;
    private Long jobID;
    private String jobNumber;
    private String division;
    private Long poID;
    private String poNumber;
    private Long customerID;
    private String customer;
    private String customerPaymentTerms;
    private Long invoiceID;
    private String invoiceName;
    private BigDecimal amount;
    private BigDecimal installation;
    private BigDecimal engineering;
    private BigDecimal transportation;
    private BigDecimal materials;
    private BigDecimal warehousing;
    private BigDecimal salesTax;
    private LocalDate sentOn;
    private LocalDate paidOn;
    private String paymentId;
    private String voucherId;
    private String receiptId;
    private String depositTicketId;
}
