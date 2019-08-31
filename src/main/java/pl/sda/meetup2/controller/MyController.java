package pl.sda.meetup2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }


    @GetMapping("/restricted")
    public String restrictedPage(Authentication authentication){
        authentication.getName();

        return "restrictedPage";
    }
}

