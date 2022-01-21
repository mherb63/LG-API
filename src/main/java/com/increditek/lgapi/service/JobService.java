package com.increditek.lgapi.service;

import com.increditek.lgapi.converter.*;
import com.increditek.lgapi.domain.*;
import com.increditek.lgapi.dto.*;
import com.increditek.lgapi.exception.ItemNotFoundException;
import com.increditek.lgapi.repository.JobRepository;
import com.increditek.lgapi.repository.TimecardRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class JobService {

    private final JobRepository jobRepository;
    private final TimecardRepository timecardRepository;
    private final JobEventLogToJobEventLogDto jobEventLogToJobEventLogDto;
    private final ExpenseReportItemToExpenseReportItemDto expenseReportItemToExpenseReportItemDto;
    private final TimeCardToTimeCardDto timeCardToTimeCardDto;
    private final JobLogToLogDto jobLogToLogDto;
    private final MaterialLogToLogDto materialLogToLogDto;
    private final CustomerInvoiceToCustomerInvoiceDto customerInvoiceToCustomerInvoiceDto;
    private final JobSupplierInvoiceToJobSupplierInvoiceDto jobSupplierInvoiceToJobSupplierInvoiceDto;
    private final JobChangeOrderToJobChangeOrderDto jobChangeOrderToJobChangeOrderDto;
    private final JobBomItemToJobBomItemDto jobBomItemToJobBomItemDto;

    @Value("${itek.job.docs.active}")
    private String jobDocsActiveLocation;

    @Value("${itek.job.docs.active}")
    private String jobDocsArchivedLocation;


    public JobService(JobRepository jobRepository, TimecardRepository timecardRepository, JobEventLogToJobEventLogDto jobEventLogToJobEventLogDto, ExpenseReportItemToExpenseReportItemDto expenseReportItemToExpenseReportItemDto, TimeCardToTimeCardDto timeCardToTimeCardDto, JobLogToLogDto jobLogToLogDto, MaterialLogToLogDto materialLogToLogDto, CustomerInvoiceToCustomerInvoiceDto customerInvoiceToJobCustomerInvoiceDto, JobSupplierInvoiceToJobSupplierInvoiceDto jobSupplierInvoiceToJobSupplierInvoiceDto, JobChangeOrderToJobChangeOrderDto jobChangeOrderToJobChangeOrderDto, JobBomItemToJobBomItemDto jobBomToJobBomDto) {
        this.jobRepository = jobRepository;
        this.timecardRepository = timecardRepository;
        this.jobEventLogToJobEventLogDto = jobEventLogToJobEventLogDto;
        this.expenseReportItemToExpenseReportItemDto = expenseReportItemToExpenseReportItemDto;
        this.timeCardToTimeCardDto = timeCardToTimeCardDto;
        this.jobLogToLogDto = jobLogToLogDto;
        this.materialLogToLogDto = materialLogToLogDto;
        this.customerInvoiceToCustomerInvoiceDto = customerInvoiceToJobCustomerInvoiceDto;
        this.jobSupplierInvoiceToJobSupplierInvoiceDto = jobSupplierInvoiceToJobSupplierInvoiceDto;
        this.jobChangeOrderToJobChangeOrderDto = jobChangeOrderToJobChangeOrderDto;
        this.jobBomItemToJobBomItemDto = jobBomToJobBomDto;
    }

    public Page<Job> getJobs(int page, int pageSize, Optional<Boolean> isArchived, Optional<String> division) {
        return division.get().equals("All") ?
                jobRepository.findByIsArchived(PageRequest.of(page, pageSize), isArchived.get()) :
                jobRepository.findByIsArchivedAndDivision(PageRequest.of(page, pageSize), isArchived.get(), division.get());
    }

    public Job findById(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
    }

    public List<CustomerPurchaseOrder> getCustomerPurchaseOrders(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getCustomerPurchaseOrders();
    }

    public List<CustomerInvoiceDto> getCustomerInvoices(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getCustomerInvoices().stream().map(customerInvoice -> customerInvoiceToCustomerInvoiceDto.convert(customerInvoice)).collect(Collectors.toList());
    }

    public List<JobSupplierPurchaseOrder> getSupplierPurchaseOrders(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getSupplierPurchaseOrders();
    }

    public List<JobSupplierInvoiceDto> getSupplierInvoices(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getSupplierInvoices().stream().map(jobSupplierInvoice -> jobSupplierInvoiceToJobSupplierInvoiceDto.convert(jobSupplierInvoice)).collect(Collectors.toList());
    }

    public List<JobEventLogDto> getEventLogs(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getEventLogs().stream().map(eventLog -> jobEventLogToJobEventLogDto.convert(eventLog)).collect(Collectors.toList());
    }

    public List<ExpenseReportItemDto> getExpenseReportItems(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getExpenseReportItems().stream().map(expenseItem -> expenseReportItemToExpenseReportItemDto.convert(expenseItem)).collect(Collectors.toList());
    }

    public List<TimeCardDto> getTimeCards(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return timecardRepository.findByJobNumber(job.getNumber()).stream().map(timeCard -> timeCardToTimeCardDto.convert(timeCard)).collect(Collectors.toList());
    }

    public List<LogDto> getLogs(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getLogs().stream().map(jobLog -> jobLogToLogDto.convert(jobLog)).collect(Collectors.toList());
    }

    public List<LogDto> getMaterialLogs(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getMaterialLogs().stream().map(materialLog -> materialLogToLogDto.convert(materialLog)).collect(Collectors.toList());
    }
    public List<JobOutOfPocketExpenseItem> getOutOfPocketExpenseItems(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getOutOfPocketExpenseItems();
    }

    public List<JobInvoiceNote> getInvoiceNotes(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getInvoiceNotes();
    }

    public List<JobChangeOrderDto> getChangeOrders(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getChangeOrders().stream().map(co -> jobChangeOrderToJobChangeOrderDto.convert(co)).collect(Collectors.toList());
    }

    public List<JobBomItemDto> getBomItems(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return job.getBomItems().stream().map(bi -> jobBomItemToJobBomItemDto.convert(bi)).collect(Collectors.toList());
    }

    public JobDocumentMapDto getJobDocs(Long id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Job with id: " + id));
        return buildJobDocsMap(job.getNumber(), job.getIsArchived());
    }

    private JobDocumentMapDto buildJobDocsMap(String jobNumber, boolean isArchived) {
        String baseDir = isArchived == true ? this.jobDocsArchivedLocation + "/" + jobNumber : this.jobDocsActiveLocation + "/" + jobNumber;

        JobDocumentMapDto mapDto = new JobDocumentMapDto();

        Stream<Path> walk = null;
        try {
            walk = Files.walk(Paths.get(baseDir));
            walk.filter(Files::isRegularFile).forEach(x -> {
                File file = x.toFile();
                String type = file.getParentFile().getName();
                String name = x.getFileName().toString();
                String uri = baseDir + "/"  + type + "/" + name;
                LocalDateTime lastModified =  LocalDateTime.ofInstant(Instant.ofEpochMilli(file.lastModified()), ZoneId.systemDefault());
                Double size = Long.valueOf(file.length()).doubleValue() / (1024 * 1024);

                JobDocumentDto jdDto = JobDocumentDto.builder()
                        .name(x.getFileName().toString())
                        .uri(uri)
                        .lastModified(lastModified)
                        .size(size)
                        .build();

                List<JobDocumentDto> jdDtoList = mapDto.getMap().get(type);
                if (jdDtoList == null) {
                    jdDtoList = new ArrayList<>();
                    mapDto.getMap().put(type, jdDtoList);
                }

                jdDtoList.add(jdDto);
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return mapDto;
    }

}
