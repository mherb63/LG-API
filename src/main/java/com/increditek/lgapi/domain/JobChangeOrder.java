package com.increditek.lgapi.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jobchangeorders")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
@EqualsAndHashCode(exclude = {"job", "user"}, callSuper = false)
public class JobChangeOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobID")
    @JsonIgnore
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issuerContact")
    @JsonIgnore
    private User user;

    private Short number;
    private String customerContactInfo;

    @Column(length = 65535, columnDefinition = "text")
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
