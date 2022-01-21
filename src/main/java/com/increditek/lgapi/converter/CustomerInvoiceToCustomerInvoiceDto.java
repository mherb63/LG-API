package com.increditek.lgapi.converter;

import com.increditek.lgapi.domain.Customer;
import com.increditek.lgapi.domain.CustomerInvoice;
import com.increditek.lgapi.domain.CustomerPurchaseOrder;
import com.increditek.lgapi.domain.Job;
import com.increditek.lgapi.dto.CustomerInvoiceDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerInvoiceToCustomerInvoiceDto implements Converter<CustomerInvoice, CustomerInvoiceDto> {
    @Override
    public CustomerInvoiceDto convert(CustomerInvoice customerInvoice) {
        CustomerInvoiceDto ciDto = new CustomerInvoiceDto();
        ciDto.setId(customerInvoice.getId());

        Job job = customerInvoice.getJob();
        Customer customer = customerInvoice.getCustomer();
        CustomerPurchaseOrder purchaseOrder = customerInvoice.getPurchaseOrder();

        if (job != null) {
            ciDto.setJobID(job.getId());
            ciDto.setJobNumber(job.getNumber());
            ciDto.setDivision(job.getDivision());
        }

        if (customer != null) {
            ciDto.setCustomerID(customer.getId());
            ciDto.setCustomer(customer.getCustomerId());
            ciDto.setCustomerPaymentTerms(customer.getPaymentTerms());
        }

        if (purchaseOrder != null) {
            ciDto.setPoID(purchaseOrder.getId());
            ciDto.setPoNumber(purchaseOrder.getNumber());
        }
        ciDto.setInvoiceID(customerInvoice.getId());
        ciDto.setInvoiceName(customerInvoice.getInvoiceItem().getInvoiceId());
        ciDto.setAmount(customerInvoice.getInvoiceItem().getAmount());
        ciDto.setInstallation(customerInvoice.getInvoiceItem().getInstallation());
        ciDto.setEngineering(customerInvoice.getInvoiceItem().getEngineering());
        ciDto.setTransportation(customerInvoice.getInvoiceItem().getTransportation());
        ciDto.setMaterials(customerInvoice.getInvoiceItem().getMaterials());
        ciDto.setWarehousing(customerInvoice.getInvoiceItem().getWarehousing());
        ciDto.setSalesTax(customerInvoice.getInvoiceItem().getSalesTax());
        ciDto.setSentOn(customerInvoice.getSentOn());
        ciDto.setPaidOn(customerInvoice.getPaidOn());
        ciDto.setPaymentId(customerInvoice.getInvoiceItem().getPaymentId());
        ciDto.setVoucherId(customerInvoice.getInvoiceItem().getVoucherId());
        ciDto.setReceiptId(customerInvoice.getReceiptId());
        ciDto.setDepositTicketId(customerInvoice.getDepositTicketId());

        return ciDto;
    }
}

