package com.increditek.lgapi.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "journalentries")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
@EqualsAndHashCode(exclude = {"journalEntryItems"}, callSuper = false)
@Data
public class JournalEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11)")
    private Long id;

    private String referenceId;

    @Column(columnDefinition = "tinyint(4)")
    private Short period;

    private LocalDate date;
    private BigDecimal amount;
    private Boolean autoGenerated;
    private String glCode;
    private String cvIdentifier;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journalEntry", fetch = FetchType.LAZY)
    private List<JournalEntryItem> journalEntryItems  = new ArrayList<>();
}