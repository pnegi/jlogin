package com.preeti.jlogin.controller;

import com.preeti.jlogin.model.Role;
import com.preeti.jlogin.model.User;
import com.preeti.jlogin.service.RoleService;
import com.preeti.jlogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @PostMapping("/save/all")
    public ResponseEntity<List<User>> saveUsers(@RequestBody List<User> newUsers){

        List<User> users = userService.saveUser(newUsers);

        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User newUsers, @RequestParam("roles") List<String > roles){

        Optional<Set<Role>> roleOptional=  roleService.getRoleByNames(roles);
        if(roleOptional.isPresent()){
            Set<Role> roleSet = roleOptional.get();
            newUsers.setRolesForUser(roleSet);
        }
        List<User> savedUsers = userService.saveUser(Stream.of(newUsers).collect(Collectors.toList()));

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsers.get(0));
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
