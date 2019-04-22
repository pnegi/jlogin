package com.preeti.jlogin.controller;

import com.preeti.jlogin.model.User;
import com.preeti.jlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<List<User>> saveUser(@RequestBody List<User> newUsers){

        List<User> users = userService.saveUser(newUsers);

        return ResponseEntity.status(HttpStatus.CREATED).body(users);
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
    public ResponseEntity<List<Map<String, String>>> getActiveUsers() {

        Optional<List<Map<String, String>>> options = userService.findByActive();

        if (options.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(options.get());
        }
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
