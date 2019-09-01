package pl.sda.meetup2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.meetup2.event.Event;
import pl.sda.meetup2.event.EventService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
public class HomePageController {

    private final
    EventService eventService;

    @Autowired
    public HomePageController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("events", eventService.findAllEvents().stream()
                .filter(e -> e.getEndDate()
                .isAfter(LocalDate.now()))
                .sorted(Comparator.comparing(Event::getStartDate))
                .collect(Collectors.toList()));
        return "index";
    }

    @GetMapping("/restricted")
    public String restrictedPage(Authentication authentication) {
        authentication.getName();
        return "restrictedPage";
    }
}

