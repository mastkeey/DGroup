//package ru.mastkey.dgroup.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ru.mastkey.dgroup.service.UserService;
//
//@RestController
//@RequiredArgsConstructor
//public class TestController {
//    private final UserService userService;
//
//    @GetMapping("/user")
//    public String user() {
//        var us = SecurityContextHolder.getContext().getAuthentication().getName();
//        return "user: " + us + "   " + userService.getCurrentUsername();
//    }
//
//    @GetMapping("/managerr")
//    public String manager() {
//        return "managerr";
//    }
//}
