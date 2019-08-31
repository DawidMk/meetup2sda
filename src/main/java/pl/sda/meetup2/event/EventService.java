package pl.sda.meetup2.event;

import org.springframework.stereotype.Service;
import pl.sda.meetup2.dto.AddEventFormDto;

@Service
public class EventService {

    private final
    EventDao eventDao;
    private final
    DtoToEventConverter dtoToEventConverter;

    public EventService(EventDao eventDao, DtoToEventConverter dtoToEventConverter) {
        this.eventDao = eventDao;
        this.dtoToEventConverter = dtoToEventConverter;
    }

    public void saveEventToDb(AddEventFormDto addEventFormDto) {
        eventDao.saveUserToDb(dtoToEventConverter.rewriteDtoToEvent(addEventFormDto));
    }
}
