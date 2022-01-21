package com.increditek.lgapi.repository;

import com.increditek.lgapi.domain.ChartOfAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartOfAccountsRepository extends JpaRepository<ChartOfAccount, Long> {
    Page<ChartOfAccount> findAllByType(Pageable p, String type);
}
