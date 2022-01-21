package com.increditek.lgapi.repository;

import com.increditek.lgapi.domain.Customer;
import com.increditek.lgapi.domain.CustomerInvoice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CustomerInvoiceRepository extends JpaRepository<CustomerInvoice, Long>  {
    Page<CustomerInvoice> findAllBySentOnBetween(Pageable p, LocalDate startDate, LocalDate endDate);
    Page<CustomerInvoice> findAllByPaidOnBetween(Pageable p, LocalDate startDate, LocalDate endDate);
    Page<CustomerInvoice> findAllByCustomerAndPaidOnIsNull(Pageable p, Customer customer);
    Page<CustomerInvoice> findAllByPaidOnIsNull(Pageable p);
}
