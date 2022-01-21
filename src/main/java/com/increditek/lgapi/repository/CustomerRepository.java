package com.increditek.lgapi.repository;

import com.increditek.lgapi.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customerinvoicecontacts where id in (select distinct customerID from jobinvoicepayments where paidOn is NULL)", nativeQuery = true)
    Page<Customer> findAllUnPaidCustomers(Pageable p);
}
