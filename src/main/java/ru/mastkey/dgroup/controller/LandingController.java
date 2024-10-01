package ru.mastkey.dgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingController {
    @GetMapping("/land")
    public String land() {
        return "lkFinal.html";
    }
}
