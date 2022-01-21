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
@Table(name = "expensereportitems")
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@EqualsAndHashCode(exclude = {"job"}, callSuper = false)
public class ExpenseReportItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expenseReportID")
    @JsonIgnore
    private ExpenseReport expenseReport;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobID")
    @JsonIgnore
    private Job job;

    private LocalDate expenseDate;
    private String expenseDescription;
    private String expenseCategory;
    private BigDecimal expenseAmount;
    private BigDecimal expenseTotalMiles;
    private String receiptFileName;
}
