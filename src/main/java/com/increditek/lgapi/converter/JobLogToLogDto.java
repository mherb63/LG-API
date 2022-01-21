package com.increditek.lgapi.converter;

import com.increditek.lgapi.domain.JobLog;
import com.increditek.lgapi.domain.User;
import com.increditek.lgapi.dto.LogDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class JobLogToLogDto implements Converter<JobLog, LogDto> {

    @Override
    public LogDto convert(JobLog jobLog) {
        LogDto logDto = new LogDto();

        User user = jobLog.getUser();

        logDto.setId(jobLog.getId());
        logDto.setUserId(user.getId());
        logDto.setPerson(user.getFirstName() + " " + user.getLastName());
        logDto.setLogDate(jobLog.getLogDate());
        logDto.setLogData(jobLog.getLogData());

        return logDto;
    }
}