package ru.mastkey.dgroup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LandingController {
    @GetMapping("/lk")
    public String land() {
        return "lkFinal.html";
    }

    @GetMapping("/reg")
    public String registration() {
        return "lkRegistration.html";
    }

    @GetMapping("/land")
    public String showMainPage() {
        return "index.html";
    }
}
