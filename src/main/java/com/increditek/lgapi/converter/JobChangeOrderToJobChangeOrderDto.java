package com.increditek.lgapi.converter;

import com.increditek.lgapi.domain.JobChangeOrder;
import com.increditek.lgapi.domain.User;
import com.increditek.lgapi.dto.JobChangeOrderDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class JobChangeOrderToJobChangeOrderDto implements Converter<JobChangeOrder, JobChangeOrderDto> {
    @Override
    public JobChangeOrderDto convert(JobChangeOrder jobChangeOrder) {
        JobChangeOrderDto jcoDto = new JobChangeOrderDto();

        User user = jobChangeOrder.getUser();

        jcoDto.setId(jobChangeOrder.getId());
        jcoDto.setUserID(user.getId());
        jcoDto.setPerson(user.getFirstName() + " " + user.getLastName());
        jcoDto.setNumber(jobChangeOrder.getNumber());
        jcoDto.setCustomerContactInfo(jobChangeOrder.getCustomerContactInfo());
        jcoDto.setCustomerContactSignature(jobChangeOrder.getCustomerContactSignature());
        jcoDto.setChangeOrderNeeded(jobChangeOrder.isChangeOrderNeeded());
        jcoDto.setAdditionalSurveyVisitNeeded(jobChangeOrder.isAdditionalSurveyVisitNeeded());
        jcoDto.setNoMaterialsNeeded(jobChangeOrder.isNoMaterialsNeeded());
        jcoDto.setEngineeringOnlyNeeded(jobChangeOrder.isEngineeringOnlyNeeded());
        jcoDto.setRevisedSurveyUploaded(jobChangeOrder.isRevisedSurveyUploaded());
        jcoDto.setSubmittedToLgDate(jobChangeOrder.getSubmittedToLgDate());
        jcoDto.setSubmittedToVlDate(jobChangeOrder.getSubmittedToVlDate());
        jcoDto.setApprovedInVlDate(jobChangeOrder.getApprovedInVlDate());
        jcoDto.setEngineeringHours(jobChangeOrder.getEngineeringHours());
        jcoDto.setInstallationHours(jobChangeOrder.getInstallationHours());

        return jcoDto;
    }
}

