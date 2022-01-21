package com.increditek.lgapi.converter;

import com.increditek.lgapi.domain.TimeCard;
import com.increditek.lgapi.domain.User;
import com.increditek.lgapi.dto.TimeCardDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TimeCardToTimeCardDto implements Converter<TimeCard, TimeCardDto> {
    @Override
    public TimeCardDto convert(TimeCard timeCard) {
        TimeCardDto timeCardDto = new TimeCardDto();
        timeCardDto.setId(timeCard.getId());

        User user = timeCard.getUser();
        timeCardDto.setPerson(user.getFirstName() + " " + user.getLastName());
        timeCardDto.setPunchDate(timeCard.getPunchDate());
        timeCardDto.setPunchHours(timeCard.getPunchHours());
        timeCardDto.setWorkClassType(timeCard.getWorkClassType());
        timeCardDto.setWorkClassSubType(timeCard.getWorkClassSubType());
        timeCardDto.setIsPunchAppEntry(timeCard.getIsPunchAppEntry());
        timeCardDto.setIsOverTime(timeCard.getIsOverTime());
        timeCardDto.setLlr(timeCard.getLlr());
        timeCardDto.setIsOverTime(timeCard.getIsOverTime());

        return timeCardDto;
    }
}
