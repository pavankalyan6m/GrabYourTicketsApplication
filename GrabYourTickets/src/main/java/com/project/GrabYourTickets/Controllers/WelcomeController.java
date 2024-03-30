package com.project.GrabYourTickets.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "Welcome"; // Assuming "Welcome.html" exists in your static folder
    }

    @GetMapping("/admin")
    public String showAdminLoginPage() {
        return "admin-login";
    }

    @GetMapping("/user")
    public String showUserLoginPage() {
        return "user-login";
    }
}
