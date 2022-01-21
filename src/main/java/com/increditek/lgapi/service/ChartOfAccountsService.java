package com.increditek.lgapi.service;

import com.increditek.lgapi.domain.ChartOfAccount;
import com.increditek.lgapi.exception.ItemNotFoundException;
import com.increditek.lgapi.repository.ChartOfAccountsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChartOfAccountsService {
    private final ChartOfAccountsRepository chartOfAccountsRepository;

    public ChartOfAccountsService(ChartOfAccountsRepository chartOfAccountsRepository) {
        this.chartOfAccountsRepository = chartOfAccountsRepository;
    }

    public Page<ChartOfAccount> getAll(int page, int pageSize, Optional<String> type) {
        if (type.isPresent()) {
            return chartOfAccountsRepository.findAllByType(PageRequest.of(page, pageSize), type.get());
        }
        else {
            return chartOfAccountsRepository.findAll(PageRequest.of(page, pageSize));
        }
    }

    public ChartOfAccount getById(Long id) {
        return  chartOfAccountsRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find ChartOfAccount with id: " + id));
    }
}
