package com.increditek.lgapi.controller;

import com.increditek.lgapi.domain.ChartOfAccount;
import com.increditek.lgapi.domain.PageableResponse;
import com.increditek.lgapi.service.ChartOfAccountsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/glaccounts")
public class ChartOfAccountsController {
    private final ChartOfAccountsService chartOfAccountsService;

    public ChartOfAccountsController(ChartOfAccountsService chartOfAccountsService) {
        this.chartOfAccountsService = chartOfAccountsService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageableResponse getAll(HttpServletRequest request,
                                  @RequestParam Optional<String> type,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "100") int pageSize) {
        return new PageableResponse("lgapi/glaccounts", chartOfAccountsService.getAll(page, pageSize, type), request.getRequestURL().toString());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ChartOfAccount getChartOfAccount(@PathVariable Long id) {
        return chartOfAccountsService.getById(id);
    }
}
