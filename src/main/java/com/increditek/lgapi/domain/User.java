package com.increditek.lgapi.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    private boolean isDeleted;
    private String userName;
    private String privLevel;
    private String jobTypeAccessList;
    private String privTypeAccessList;
    private String userType;
    private String installerGrade;
    private Boolean isPunchAppUser;
    private Boolean isPunchAppWarehouseUser;
    private String supervisor;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime lastLogin;
    private LocalDateTime lastLogoff;
    private UserNotifications userNotifications;
    private LocalDate employeeHandbookAccepted;
    private BigDecimal ptoHours;
    private BigDecimal llrrt;
    private BigDecimal llrot;
    private String corpCardNumber;
    private LocalDate lastPasswordChange;
    private boolean twoFactorAuthRequired;
    private String googleAuthSecretKey;
}