package com.increditek.lgapi.converter;

import com.increditek.lgapi.domain.MaterialLog;
import com.increditek.lgapi.domain.User;
import com.increditek.lgapi.dto.LogDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MaterialLogToLogDto implements Converter<MaterialLog, LogDto> {
    @Override
    public LogDto convert(MaterialLog materialLog) {
        LogDto logDto = new LogDto();

        User user = materialLog.getUser();

        logDto.setId(materialLog.getId());
        logDto.setUserId(user.getId());
        logDto.setPerson(user.getFirstName() + " " + user.getLastName());
        logDto.setLogDate(materialLog.getLogDate());
        logDto.setLogData(materialLog.getLogData());

        return logDto;
    }
}
