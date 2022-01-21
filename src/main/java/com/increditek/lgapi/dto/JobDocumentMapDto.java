package com.increditek.lgapi.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class JobDocumentMapDto {
    private Map<String, List<JobDocumentDto>> map = new HashMap<>();
}
