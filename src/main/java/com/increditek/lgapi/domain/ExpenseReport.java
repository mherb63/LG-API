package com.increditek.lgapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "expensereports")
@Data
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@EqualsAndHashCode(exclude = {"user", "approval1User", "approval2User"}, callSuper = false)
public class ExpenseReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userID")
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approval1UserId")
    @JsonIgnore
    private User approval1User;
    private LocalDate approval1Date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "approval2UserId")
    @JsonIgnore
    private User approval2User;
    private LocalDate approval2Date;

    private LocalDate savedOn;
    private LocalDate submittedOn;
    private LocalDate paidOn;
    private String status;
}
