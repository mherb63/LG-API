package com.increditek.lgapi.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchCriteria {
    private String embedded;
    private String key;
    private String operation;
    private Object value;
}
