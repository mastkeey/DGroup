package ru.mastkey.dgroup.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/user")
    public String user() {
        var us = SecurityContextHolder.getContext().getAuthentication().getName();
        return "user: " + us;
    }

    @GetMapping("/managerr")
    public String manager() {
        return "managerr";
    }
}
