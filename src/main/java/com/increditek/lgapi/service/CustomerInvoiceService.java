package com.increditek.lgapi.service;

import com.increditek.lgapi.converter.CustomerInvoiceToCustomerInvoiceDto;
import com.increditek.lgapi.domain.Customer;
import com.increditek.lgapi.domain.CustomerInvoice;
import com.increditek.lgapi.dto.CustomerInvoiceDto;
import com.increditek.lgapi.exception.ItemNotFoundException;
import com.increditek.lgapi.repository.CustomerInvoiceRepository;
import com.increditek.lgapi.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CustomerInvoiceService {
    private CustomerInvoiceRepository customerInvoiceRepository;
    private CustomerRepository customerRepository;
    private CustomerInvoiceToCustomerInvoiceDto customerInvoiceToCustomerInvoiceDto;

    public CustomerInvoiceService(CustomerInvoiceRepository customerInvoiceRepository, CustomerRepository customerRepository, CustomerInvoiceToCustomerInvoiceDto customerInvoiceToCustomerInvoiceDto) {
        this.customerInvoiceRepository = customerInvoiceRepository;
        this.customerRepository = customerRepository;
        this.customerInvoiceToCustomerInvoiceDto = customerInvoiceToCustomerInvoiceDto;
    }

    public CustomerInvoice findById(Long id) {
        return customerInvoiceRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Customer Invoice with id: " + id));
    }

    public Page<CustomerInvoice> findAllBySentOnDateRange(int page, int pageSize, LocalDate startDate, LocalDate endDate) {
        return customerInvoiceRepository.findAllBySentOnBetween(PageRequest.of(page, pageSize), startDate, endDate);
    }

    public Page<CustomerInvoice> findAllByPaidOnDateRange(int page, int pageSize, LocalDate startDate, LocalDate endDate) {
        return customerInvoiceRepository.findAllByPaidOnBetween(PageRequest.of(page, pageSize), startDate, endDate);
    }

    public Page<CustomerInvoiceDto> findAllUnpaid(Optional<Long> customerId, int page, int pageSize) {
        if (customerId.isPresent()) {
            Customer customer = customerRepository.findById(customerId.get()).orElseThrow(() -> new ItemNotFoundException("Count not find Customer with id: " + customerId.get()));
            return customerInvoiceRepository.findAllByCustomerAndPaidOnIsNull(PageRequest.of(page, pageSize), customer).map(customerInvoice -> customerInvoiceToCustomerInvoiceDto.convert(customerInvoice));
        }
        else
            return customerInvoiceRepository.findAllByPaidOnIsNull(PageRequest.of(page, pageSize)).map(customerInvoice -> customerInvoiceToCustomerInvoiceDto.convert(customerInvoice));
    }

    public Page<Customer> findAllUnpaidCustomers(int page, int pageSize) {
        return customerRepository.findAllUnPaidCustomers(PageRequest.of(page, pageSize));
    }
}
