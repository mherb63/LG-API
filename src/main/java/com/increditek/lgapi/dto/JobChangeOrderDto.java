package com.increditek.lgapi.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class JobChangeOrderDto {
    private Long id;
    private Long userID;
    private String person;
    private Short number;
    private String customerContactInfo;
    private String customerContactSignature;
    private boolean changeOrderNeeded;
    private boolean additionalSurveyVisitNeeded;
    private boolean noMaterialsNeeded;
    private boolean engineeringOnlyNeeded;
    private boolean revisedSurveyUploaded;
    private LocalDate submittedToLgDate;
    private LocalDate submittedToVlDate;
    private LocalDate approvedInVlDate;
    private String description;
    private String materialsNeededDescription;
    private Integer engineeringHours;
    private Integer installationHours;
}
