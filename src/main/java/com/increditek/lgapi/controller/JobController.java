package com.increditek.lgapi.controller;


import com.increditek.lgapi.domain.*;
import com.increditek.lgapi.dto.*;
import com.increditek.lgapi.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/job")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageableResponse getJobs(HttpServletRequest request,
                                    @RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "100") int pageSize,
                                    @RequestParam Optional<Boolean> isArchived,
                                   @RequestParam Optional<String> division) {
        return new PageableResponse("lgapi/job", jobService.getJobs(page, pageSize, isArchived, division), request.getRequestURL().toString());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Job getJob(@PathVariable Long id) {
        return jobService.findById(id);
    }


    @GetMapping("/{id}/customerPurchaseOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerPurchaseOrder> getCustomerPurchaseOrders(@PathVariable Long id) {
        return jobService.getCustomerPurchaseOrders(id);
    }

    @GetMapping("/{id}/customerInvoices")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerInvoiceDto> getCustomerInvoices(@PathVariable Long id) {
        return jobService.getCustomerInvoices(id);
    }

    @GetMapping("/{id}/supplierPurchaseOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<JobSupplierPurchaseOrder> getSupplierPurchaseOrders(@PathVariable Long id) {
        return jobService.getSupplierPurchaseOrders(id);
    }

    @GetMapping("/{id}/supplierInvoices")
    @ResponseStatus(HttpStatus.OK)
    public List<JobSupplierInvoiceDto> getSupplierInvoices(@PathVariable Long id) {
        return jobService.getSupplierInvoices(id);
    }

    @GetMapping("/{id}/eventLogs")
    @ResponseStatus(HttpStatus.OK)
    public List<JobEventLogDto> getEventLogs(@PathVariable Long id) {
        return jobService.getEventLogs(id);
    }


    @GetMapping("/{id}/expenseReportItems")
    @ResponseStatus(HttpStatus.OK)
    public List<ExpenseReportItemDto> getExpenseReportItems(@PathVariable Long id) {
        return jobService.getExpenseReportItems(id);
    }

    @GetMapping("/{id}/timeCardItems")
    @ResponseStatus(HttpStatus.OK)
    public List<TimeCardDto> getTimeCardItems(@PathVariable Long id) {
        return jobService.getTimeCards(id);
    }

    @GetMapping("/{id}/materialLogs")
    @ResponseStatus(HttpStatus.OK)
    public List<LogDto> getMaterialLogs(@PathVariable Long id) {
        return jobService.getMaterialLogs(id);
    }

    @GetMapping("/{id}/logs")
    @ResponseStatus(HttpStatus.OK)
    public List<LogDto> getLogs(@PathVariable Long id) {
        return jobService.getLogs(id);
    }

    @GetMapping("/{id}/outOfPocketExpenseItems")
    @ResponseStatus(HttpStatus.OK)
    public List<JobOutOfPocketExpenseItem> getOutOfPocketExpenseItems(@PathVariable Long id) {
        return jobService.getOutOfPocketExpenseItems(id);
    }

    @GetMapping("/{id}/invoiceNotes")
    @ResponseStatus(HttpStatus.OK)
    public List<JobInvoiceNote> getInvoiceNotes(@PathVariable Long id) {
        return jobService.getInvoiceNotes(id);
    }

    @GetMapping("/{id}/changeOrders")
    @ResponseStatus(HttpStatus.OK)
    public List<JobChangeOrderDto> getChangeOrders(@PathVariable Long id) {
        return jobService.getChangeOrders(id);
    }

    @GetMapping("/{id}/bomItems")
    @ResponseStatus(HttpStatus.OK)
    public List<JobBomItemDto> getBomItems(@PathVariable Long id) {
        return jobService.getBomItems(id);
    }

    @GetMapping("/{id}/jobDocs")
    @ResponseStatus(HttpStatus.OK)
    public JobDocumentMapDto getJobDocs(@PathVariable Long id) {
        return jobService.getJobDocs(id);
    }

}

