package com.increditek.lgapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "vendorcontacts")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    private String vendorId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String contactName;
    private String contactPhone1;
    private String contactPhone2;
    private String contactEmail;
    private String accountNumber;
    private String paymentTerms;
    private String division;
    private String shipVia;
    private String expenseCategory;
    private Boolean is1099;
    private String taxIdNumber;
}
