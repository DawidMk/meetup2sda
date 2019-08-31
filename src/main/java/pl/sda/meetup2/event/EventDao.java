package pl.sda.meetup2.event;

import org.springframework.stereotype.Repository;

@Repository
public class EventDao {

    private final
    EventRepository eventRepository;

    public EventDao(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void saveUserToDb(Event event) {
        eventRepository.save(event);
    }

}
