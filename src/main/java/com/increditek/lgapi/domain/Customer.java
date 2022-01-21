package com.increditek.lgapi.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customerinvoicecontacts")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    private String customerId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String contactName;
    private String contactPhone;
    private String contactEmail;
    private String accountNumber;
    private String paymentTerms;
    private String division;

}