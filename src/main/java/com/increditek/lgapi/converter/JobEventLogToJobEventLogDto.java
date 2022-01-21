package com.increditek.lgapi.converter;

import com.increditek.lgapi.domain.JobEventLog;
import com.increditek.lgapi.domain.User;
import com.increditek.lgapi.dto.JobEventLogDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class JobEventLogToJobEventLogDto implements Converter<JobEventLog, JobEventLogDto> {
    @Override
    public JobEventLogDto convert(JobEventLog jobEventLog) {
        JobEventLogDto jobEventLogDto = new JobEventLogDto();

        User user = jobEventLog.getUser();

        jobEventLogDto.setId(jobEventLog.getId());
        jobEventLogDto.setUserId(user.getId());
        jobEventLogDto.setPerson(user.getFirstName() + " " + user.getLastName());
        jobEventLogDto.setLogType(jobEventLog.getLogType());
        jobEventLogDto.setLogDate(jobEventLog.getLogDate());
        jobEventLogDto.setLogData(jobEventLog.getLogData());

        return jobEventLogDto;
    }
}
