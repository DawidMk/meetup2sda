package pl.sda.meetup2.event;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByEventName(String eventName);

//    List<Event> findAllOrderByStartDate();
}
