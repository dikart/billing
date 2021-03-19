package com.rfl.billing.controller;

import com.rfl.billing.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController extends AbstractUserController {
    @GetMapping("/users")
    public String getAll(Model model) {
        List<User> users = service.getAll();
        model.addAttribute("users", users);
        return "users";
    }

}
