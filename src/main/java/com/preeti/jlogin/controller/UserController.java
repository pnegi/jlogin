package com.preeti.jlogin.controller;

import com.preeti.jlogin.model.User;
import com.preeti.jlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/add") // Map ONLY GET Requests
    public String addNewUser (@RequestParam String name, @RequestParam String email, @RequestParam String dob, @RequestParam Boolean active) {
        String str = dob;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(str, formatter);
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setDob(dateTime);
        n.setActive(active);
        userService.saveUser(n);
        return "Saved";
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.findAll();
    }

    @GetMapping("/active")
    public Iterable<User> getActiveUsers() {
        // This returns a JSON or XML with the active users
        return userService.findByActive();
    }
}
