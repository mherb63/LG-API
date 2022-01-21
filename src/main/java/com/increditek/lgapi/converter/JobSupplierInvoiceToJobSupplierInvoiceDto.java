package com.increditek.lgapi.converter;

import com.increditek.lgapi.domain.JobSupplierInvoice;
import com.increditek.lgapi.domain.JobSupplierPurchaseOrder;
import com.increditek.lgapi.domain.Vendor;
import com.increditek.lgapi.dto.JobSupplierInvoiceDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class JobSupplierInvoiceToJobSupplierInvoiceDto implements Converter<JobSupplierInvoice, JobSupplierInvoiceDto> {
    @Override
    public JobSupplierInvoiceDto convert(JobSupplierInvoice jobSupplierInvoice) {
        JobSupplierInvoiceDto jsiDto = new JobSupplierInvoiceDto();

        Vendor vendor = jobSupplierInvoice.getVendor();
        JobSupplierPurchaseOrder purchaseOrder = jobSupplierInvoice.getPurchaseOrder();

        jsiDto.setPoID(purchaseOrder.getId());
        jsiDto.setPoNumber(purchaseOrder.getNumber());
        if (vendor != null) {
            jsiDto.setVendorID(vendor.getId());
            jsiDto.setVendor(vendor.getVendorId());
        }
        jsiDto.setInvoiceId(jobSupplierInvoice.getInvoiceItem().getInvoiceId());
        jsiDto.setAmount(jobSupplierInvoice.getInvoiceItem().getAmount());
        jsiDto.setInstallation(jobSupplierInvoice.getInvoiceItem().getInstallation());
        jsiDto.setEngineering(jobSupplierInvoice.getInvoiceItem().getEngineering());
        jsiDto.setTransportation(jobSupplierInvoice.getInvoiceItem().getTransportation());
        jsiDto.setMaterials(jobSupplierInvoice.getInvoiceItem().getMaterials());
        jsiDto.setWarehousing(jobSupplierInvoice.getInvoiceItem().getWarehousing());
        jsiDto.setSalesTax(jobSupplierInvoice.getInvoiceItem().getSalesTax());
        jsiDto.setPaymentId(jobSupplierInvoice.getInvoiceItem().getPaymentId());
        jsiDto.setVoucherId(jobSupplierInvoice.getInvoiceItem().getVoucherId());
        jsiDto.setReceivedOn(jobSupplierInvoice.getReceivedOn());
        jsiDto.setDueOn(jobSupplierInvoice.getDueOn());
        jsiDto.setPaidOn(jobSupplierInvoice.getPaidOn());
        jsiDto.setPaymentReferenceId(jobSupplierInvoice.getPaymentReferenceId());
        jsiDto.setPaymentAccountId(jobSupplierInvoice.getPaymentAccountId());
        jsiDto.setPaymentDiscrepancyReason(jobSupplierInvoice.getPaymentDiscrepancyReason());
        jsiDto.setPaymentCleared(jobSupplierInvoice.getPaymentCleared());
        jsiDto.setNotes(jobSupplierInvoice.getNotes());

        return jsiDto;
    }
}
