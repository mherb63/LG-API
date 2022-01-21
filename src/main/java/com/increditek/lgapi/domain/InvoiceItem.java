package com.increditek.lgapi.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Data
public class InvoiceItem {
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
}
