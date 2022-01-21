package com.increditek.lgapi.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class JobDocumentDto {
    private String name;
    private String uri;
    private Double size;
    private LocalDateTime lastModified;
}
