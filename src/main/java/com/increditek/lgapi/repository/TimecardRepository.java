package com.increditek.lgapi.repository;

import com.increditek.lgapi.domain.TimeCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimecardRepository  extends JpaRepository<TimeCard, Long> {
    List<TimeCard> findByJobNumber(String jobNumber);
}
