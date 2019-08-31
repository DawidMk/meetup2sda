package pl.sda.meetup2.event;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.meetup2.event.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
