package com.testingservice.security;

import com.testingservice.data.UserRepository;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import org.springframework.validation.Errors;

@Controller
@RequestMapping(path = "/register")
public class RegistrationController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserRepository userRepository,
                                  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String showRegisterForm(Model model) {
        RegistrationForm registrationForm = new RegistrationForm();
        model.addAttribute("registrationForm", registrationForm);
        return "registration";
    }

    @PostMapping
    public String processRegistration(@Valid RegistrationForm registrationForm, Errors errors) {
        if(errors.hasErrors()) {
            return "registration";
        }
        else {
            userRepository.save(registrationForm.toUser(passwordEncoder));
            return "redirect:/login";
        }
    }
}
