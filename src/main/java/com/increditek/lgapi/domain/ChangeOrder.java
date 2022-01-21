package com.increditek.lgapi.domain;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
@Data
public class ChangeOrder {
    private Boolean changeOrder;
    private Boolean internalEngNotRequired;
    private String changeOrderDescription;
    private Integer coEngineeringHours;
    private Integer coMaterialsHours;
    private Integer coInstallationHours;
    private Integer coQualityHours;
    private LocalDate changeOrderSubmittedDate;
    private LocalDate changeOrderApprovedDate;
    private LocalDate changeOrderInvoicedDate;
    private LocalDate changeOrderPaidDate;
}
