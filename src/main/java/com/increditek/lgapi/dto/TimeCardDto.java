package com.increditek.lgapi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TimeCardDto {

    private Long id;
    private String person;
    private LocalDate punchDate;
    private BigDecimal punchHours;
    private String workClassType;
    private String workClassSubType;
    private Boolean isPunchAppEntry;
    private BigDecimal llr;
    private Boolean isOverTime;
}


