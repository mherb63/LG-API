package com.increditek.lgapi.converter;

import com.increditek.lgapi.domain.ExpenseReport;
import com.increditek.lgapi.domain.ExpenseReportItem;
import com.increditek.lgapi.domain.User;
import com.increditek.lgapi.dto.ExpenseReportItemDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExpenseReportItemToExpenseReportItemDto implements Converter<ExpenseReportItem, ExpenseReportItemDto> {
    @Override
    public ExpenseReportItemDto convert(ExpenseReportItem expenseReportItem) {
        ExpenseReportItemDto expenseReportItemDto = new  ExpenseReportItemDto();
        expenseReportItemDto.setId(expenseReportItem.getId());

        ExpenseReport expenseReport = expenseReportItem.getExpenseReport();
        User user = expenseReport.getUser();

        expenseReportItemDto.setUserId(user.getId());
        expenseReportItemDto.setPerson(user.getFirstName() + " " + user.getLastName());
        expenseReportItemDto.setExpenseDate(expenseReportItem.getExpenseDate());
        expenseReportItemDto.setExpenseDescription(expenseReportItem.getExpenseDescription());
        expenseReportItemDto.setExpenseCategory(expenseReportItem.getExpenseCategory());
        expenseReportItemDto.setExpenseAmount(expenseReportItem.getExpenseAmount());
        expenseReportItemDto.setExpenseTotalMiles(expenseReportItem.getExpenseTotalMiles());
        expenseReportItemDto.setReceiptFileName(expenseReportItem.getReceiptFileName());

        return expenseReportItemDto;
    }
}
