package com.increditek.lgapi.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
public class JobQuality {
    private String qualityAudit;
    private LocalDate qualityAuditDate;
    private String vzQualityAudit;
    private LocalDate vzQualityAuditDate;
    private String vzEngQualityAudit;
    private LocalDate vzEngQualityAuditDate;
    private Boolean vzAuditConforms;
    private Boolean installationProblemReported;
    private LocalDate installationProblemReportedDate;
    private Boolean installationProblemFixedWithinResponseTime;
    private Boolean outageOccurred;
    private LocalDate outageOccurredDate;
}
