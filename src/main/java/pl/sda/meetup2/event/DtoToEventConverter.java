package pl.sda.meetup2.event;

import org.springframework.stereotype.Component;
import pl.sda.meetup2.dto.AddEventFormDto;

@Component
public class DtoToEventConverter {
    public Event rewriteDtoToEvent(AddEventFormDto addEventFormDto) {
        return Event.builder()
                .eventName(addEventFormDto.getEventName())
                .startDate(addEventFormDto.getStartDate())
                .endDate(addEventFormDto.getEndDate())
                .description(addEventFormDto.getDescription())
                .build();
    }
}
