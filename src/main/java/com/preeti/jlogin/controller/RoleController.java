package com.preeti.jlogin.controller;

import com.preeti.jlogin.model.Role;
import com.preeti.jlogin.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/save")
    public ResponseEntity<List<Role>> saveRole(@RequestBody List<Role> newRoles){

        List<Role> roles = roleService.saveRole(newRoles);

        return ResponseEntity.status(HttpStatus.CREATED).body(roles);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Role>> getAllRoles() {
        Optional<List<Role>> options = roleService.findAll();
        if (options.isPresent())
            return ResponseEntity.status(HttpStatus.OK).body(options.get());
        else
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/getbyname/{roleName}")
    public ResponseEntity<Role> getAllRoles(@PathVariable("roleName") String roleName) {
        //make call to service
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
