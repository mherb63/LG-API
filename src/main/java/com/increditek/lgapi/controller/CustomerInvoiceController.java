package com.increditek.lgapi.controller;

import com.increditek.lgapi.domain.CustomerInvoice;
import com.increditek.lgapi.domain.PageableResponse;
import com.increditek.lgapi.dto.BulkPayCustomerInvoices;
import com.increditek.lgapi.service.CustomerInvoiceService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer-invoice")
public class CustomerInvoiceController {

    private final CustomerInvoiceService customerInvoiceService;

    public CustomerInvoiceController(CustomerInvoiceService customerInvoiceService) {
        this.customerInvoiceService = customerInvoiceService;
    }

    @GetMapping("/sent-on-range")
    @ResponseStatus(HttpStatus.OK)
    public PageableResponse getCustomerInvoiceSentOnDateRage(HttpServletRequest request,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "100") int pageSize,
                                    @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                    @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new PageableResponse("lgapi/customer-invoice", customerInvoiceService.findAllBySentOnDateRange(page, pageSize, startDate, endDate), request.getRequestURL().toString());
    }

    @GetMapping("/paid-on-range")
    @ResponseStatus(HttpStatus.OK)
    public PageableResponse getCustomerInvoicePaidOnDateRage(HttpServletRequest request,
                                                             @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "100") int pageSize,
                                                             @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                             @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new PageableResponse("lgapi/customer-invoice", customerInvoiceService.findAllByPaidOnDateRange(page, pageSize, startDate, endDate), request.getRequestURL().toString());
    }

    @GetMapping("unpaid")
    @ResponseStatus(HttpStatus.OK)
    public PageableResponse getUnpaidCustomerInvoices(HttpServletRequest request,
                                                      @RequestParam Optional<Long> customerId,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "100") int pageSize) {
        return new PageableResponse("lgapi/customer-invoice", customerInvoiceService.findAllUnpaid(customerId, page, pageSize), request.getRequestURL().toString());
    }

    @GetMapping("unpaid-customers")
    @ResponseStatus(HttpStatus.OK)
    public PageableResponse getUnpaidCustomers(HttpServletRequest request,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "100") int pageSize) {
        return new PageableResponse("lgapi/customer-invoice", customerInvoiceService.findAllUnpaidCustomers(page, pageSize), request.getRequestURL().toString());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerInvoice getById(@PathVariable Long id) {
        return customerInvoiceService.findById(id);
    }


    @PostMapping("bulk-pay")
    @ResponseStatus(HttpStatus.CREATED)
    public List<BulkPayCustomerInvoices> bulkPayCustomerInvoices(@RequestBody BulkPayCustomerInvoices bulkPayCustomerInvoices) {
        return null;
    }

}
