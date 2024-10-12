//package ru.mastkey.dgroup.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserService {
//    public String getCurrentUsername() {
//        var authentication = SecurityContextHolder.getContext().getAuthentication();
//
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return null;
//        }
//
//        var principal = authentication.getPrincipal();
//
//        if (principal instanceof UserDetails userDetails) {
//            return userDetails.getUsername();
//        } else {
//            return principal.toString();
//        }
//    }
//}
