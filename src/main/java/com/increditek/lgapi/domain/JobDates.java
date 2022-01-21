package com.increditek.lgapi.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Data
public class JobDates {

    private LocalDateTime createdDate;
    private LocalDate estInvoiceDate;
    private LocalDate invoicedDate;
    private LocalDate paidDate;
    private LocalDate archivedDate;
    private LocalDate fpqDate;
    private LocalDate fpqUploaded;
    private LocalDate advanceCompleteDate;
    private LocalDate siteSurveyCompletedDate;
    private LocalDate materialsDueDate;
    private LocalDate materialsOrderedDate;
    private LocalDate materialsDeliveredDate;
    private LocalDate vzMrdDate;
    private LocalDate engDueDate;
    private LocalDate engStartedDate;
    private LocalDate engCompletedDate;
    private LocalDate mopSignedDate;
    private LocalDate dueDate;
    private LocalDate completedDate;
    private LocalDate materialDeliveryReadyDate;
    private LocalDate materialDeliveryMadeDate;
    private LocalDate emopSubmittedDate;
    private LocalDate emopPartialApprovalDate;
    private LocalDate emopFullApprovalDate;
    private LocalDate eqpInstalledDate;
    private LocalDate eqpReadyDate;
}

