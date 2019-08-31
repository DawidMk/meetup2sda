package pl.sda.meetup2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.meetup2.dto.RegisterFormDto;
import pl.sda.meetup2.exception.UserExistsException;
import pl.sda.meetup2.user.UserService;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute(new RegisterFormDto());
        return "registerForm";
    }

    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute
            @Valid RegisterFormDto registerFormDto,
            BindingResult result,
            Model model
    ) {
        try {
            if (result.hasErrors()) {
                System.out.println(registerFormDto.toString());
                return "registerForm";
            }

            userService.saveUserToDb(registerFormDto);
        } catch (UserExistsException e) {
            result.rejectValue("email", "666", e.getMessage());
            return "registerForm";
        }
        return "redirect:/thanks";
    }

    @GetMapping("/thanks")
    public String thanksPage() {
        return "thanks";
    }
}
