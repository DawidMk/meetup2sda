package pl.sda.meetup2.event;

import org.springframework.stereotype.Service;
import pl.sda.meetup2.dto.AddEventFormDto;
import pl.sda.meetup2.exception.NoSuchEventException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final
    EventDao eventDao;
    private final
    DtoToEventConverter dtoToEventConverter;
    private final
    EventRepository eventRepository;

    public EventService(EventDao eventDao, DtoToEventConverter dtoToEventConverter, EventRepository eventRepository) {
        this.eventDao = eventDao;
        this.dtoToEventConverter = dtoToEventConverter;
        this.eventRepository = eventRepository;
    }

    public void saveEventToDb(AddEventFormDto addEventFormDto) {
        eventDao.saveUserToDb(dtoToEventConverter.rewriteDtoToEvent(addEventFormDto));
    }

//    public List<Event> findAllEventsOrderedByStartDate() {
//        return eventRepository.findAllOrderByStartDate();
//    }
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> findByInput(String searchInput){
        return eventRepository.findAll().stream().filter(e -> e.getEventName().contains(searchInput)).collect(Collectors.toList());
    }
    public Event findById(Integer id){
        return eventRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
