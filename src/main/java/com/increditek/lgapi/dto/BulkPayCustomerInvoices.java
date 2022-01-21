package com.increditek.lgapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulkPayCustomerInvoices {
    private String referenceId;
    private String receiptId;
    private String depositTicketId;
    private Long glAccountID;
    private LocalDate date;
    private BigDecimal totalAmount;
    private List<CustomerInvoiceDto> invoices;
}
