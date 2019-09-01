package pl.sda.meetup2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.meetup2.dto.AddEventFormDto;
import pl.sda.meetup2.user.User;
import pl.sda.meetup2.user.UserRepository;
import pl.sda.meetup2.user.UserService;

@Component
public class DtoToEventConverter {
    private final
    UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public DtoToEventConverter(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    private User loggedUser(){
        String loggedUserName = userService.getLoggedUserName();
        return userRepository.findByEmail(loggedUserName).get(0);

    }

    public Event rewriteDtoToEvent(AddEventFormDto addEventFormDto) {
        return Event.builder()
                .eventName(addEventFormDto.getEventName())
                .startDate(addEventFormDto.getStartDate())
                .endDate(addEventFormDto.getEndDate())
                .description(addEventFormDto.getDescription())
                .owner(loggedUser())
                .build();
    }
}
