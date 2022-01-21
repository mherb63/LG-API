package com.increditek.lgapi.repository;


import com.increditek.lgapi.domain.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    Page<Job> findByIsArchived(Pageable p, Boolean isArchived);
    Page<Job> findByIsArchivedAndDivision(Pageable p, Boolean isArchived, String division);
}
