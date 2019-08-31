package pl.sda.meetup2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.meetup2.user.UserService;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        String userName = userService.getLoggedUserName();
        model.addAttribute("loggedUserName", userName);
        return "loginForm";
    }
}
