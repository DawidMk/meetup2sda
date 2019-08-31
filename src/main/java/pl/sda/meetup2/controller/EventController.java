package pl.sda.meetup2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.meetup2.dto.AddEventFormDto;
import pl.sda.meetup2.event.EventService;

import javax.validation.Valid;

@Controller
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/addEvent")
    public String getAddEventPage(Model model) {
        model.addAttribute(new AddEventFormDto());
        return "addEventForm";
    }

    @PostMapping("/addEvent")
    public String registerUser(
            @ModelAttribute
            @Valid AddEventFormDto addEventFormDto,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            System.out.println(addEventFormDto.toString());
            return "addEventForm";
        }
        eventService.saveEventToDb(addEventFormDto);
        return "redirect:/eventAddSuccess";
    }
}
