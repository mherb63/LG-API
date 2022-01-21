package com.increditek.lgapi.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    private Boolean isDeleted;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String type;
}
