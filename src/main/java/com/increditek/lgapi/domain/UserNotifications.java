package com.increditek.lgapi.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class UserNotifications {
    private Boolean notifyOnDueDateChange;
    private Boolean notifyOnEstimatedInvoiceDateChange;
    private Boolean notifyOnAdvanceCompleteDateChange;
    private Boolean notifyOnJobStatusEOJ;
    private Boolean notifyOnJobEngDocUpload;
    private Boolean notifyOnJobDocUpload;
    private Boolean notifyOnWarehouseInventoryTransaction;
    private Boolean notifyOnFTQ360HotSpotDocUpload;
    private Boolean notifyOnTeoApproved;
    private Boolean notifyOnBomUpload;
    private Boolean notifyOnLibraryDocUpload;
    private Boolean notifyDailyJobReport;
    private Boolean notifyInvoiceReminder;
    private Boolean notifyJobBomInvoice;
    private Boolean notifyOnJobStatusChange;
    private Boolean notifyOnMaterialNoteEntered;
    private Boolean notifyDailyVzMrdReport;
    private Boolean notifyOnMaterialDelivery;
    private Boolean notifyOnNewChangeOrder;
    private Boolean notifyOnChangeOrderSubmittedToVlDateChange;
    private Boolean notifyOnQualityDefect;

    private Boolean notifyOnJobStatusNew;
    private Boolean notifyOnJobStatusSiteSurveyComplete;
    private Boolean notifyOnJobStatusQuoteComplete;
    private Boolean notifyOnJobStatusTEOApprovedUploadBOM;
    private Boolean notifyOnJobStatusBOMUploaded;
    private Boolean notifyOnJobStatusEngineeringComplete;
    private Boolean notifyOnJobStatusMaterialsOrdered;
    private Boolean notifyOnJobStatusNDM100Received;
    private Boolean notifyOnJobStatusMOPSigned;
    private Boolean notifyOnJobStatusNDMTelcoMaterials100CalledOut;
    private Boolean notifyOnJobStatusInstallStarted;
    private Boolean notifyOnJobStatusAdvanceCompletionNoticeSubmitted;
    private Boolean notifyOnJobStatusBarCodingComplete;
    private Boolean notifyOnJobStatusInstallComplete;
    private Boolean notifyOnJobStatusTrashRemoved;
    private Boolean notifyOnJobStatusInTesting;
    private Boolean notifyOnJobStatusCompletionNoticeSubmitted;
    private Boolean notifyOnJobStatusEOJComplete;
    private Boolean notifyOnJobStatusOnHold;
    private Boolean notifyOnJobStatusPreSales;
    private Boolean notifyOnJobStatusJobCancelled;
}
