package com.preeti.jlogin.controller;

import com.preeti.jlogin.model.User;
import com.preeti.jlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User newUser){


        User user = userService.saveUser(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        Optional<List<User>> options = userService.findAll();
        if (options.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(options.get());
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/active")
    public ResponseEntity<List<User>> getActiveUsers() {

        Optional<List<User>> options = userService.findByActive();

        if (options.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(options.get());
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
