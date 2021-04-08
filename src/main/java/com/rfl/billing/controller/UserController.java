package com.rfl.billing.controller;

import com.rfl.billing.model.User;
import com.rfl.billing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController extends AbstractUserController{

    private PasswordEncoder encoder;

    @Autowired
    public UserController(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("login")
    public String login(M) {
        return "login";
    }

    @PostMapping("register")
    public String register(@ModelAttribute User user, Model model) {
        user.setPassword(encoder.encode(user.getPassword()));
        service.create(user);
        model.addAttribute("registered", true);
        return "login";
    }
}
