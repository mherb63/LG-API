package com.increditek.lgapi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ExpenseReportItemDto {
    private long id;
    private long userId;
    private String person;
    private LocalDate expenseDate;
    private String expenseDescription;
    private String expenseCategory;
    private BigDecimal expenseAmount;
    private BigDecimal expenseTotalMiles;
    private String receiptFileName;
}
