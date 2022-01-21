package com.increditek.lgapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LogDto {
    private long id;
    private long userId;
    private String person;
    private LocalDateTime logDate;
    private String logData;
}
