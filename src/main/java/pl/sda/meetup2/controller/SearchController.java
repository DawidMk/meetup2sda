package pl.sda.meetup2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.meetup2.event.Event;
import pl.sda.meetup2.event.EventService;

import java.util.List;

@Controller
public class SearchController {
    private final EventService eventService;

    public SearchController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/search")
    public String getEventSearchResult(@RequestParam(name="search") String search, Model model) {
        List<Event> searchResultByInput = eventService.findByInput(search);
        model.addAttribute("q", search);
        model.addAttribute("foundEvents", searchResultByInput);
        return "searchResultPage";
    }
}
