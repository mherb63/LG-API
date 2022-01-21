package com.increditek.lgapi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobEventLogDto {
    private long id;
    private long userId;
    private String person;
    private LocalDateTime logDate;
    private String logType;
    private String logData;
}
