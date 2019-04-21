package com.preeti.jlogin.controller;

import com.preeti.jlogin.model.User;
import com.preeti.jlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/add") // Map ONLY GET Requests
    public String addNewUser (@RequestParam String name, @RequestParam String email) {
        
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userService.saveUser(n);
        return "Saved";
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userService.findAll();
    }

}
