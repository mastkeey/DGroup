package ru.mastkey.dgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {
    @GetMapping("/land")
    public String land() {
        return "lkFinal.html";
    }

    @GetMapping("/reg")
    public String registration() {
        return "lkRegistration.html";
    }

    @GetMapping()
    public String showMainPage() {
        return "index.html";
    }
}
