package com.preeti.jlogin.service;

import com.preeti.jlogin.model.Role;
import com.preeti.jlogin.model.User;
import com.preeti.jlogin.repository.RoleRepository;
import com.preeti.jlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



//    public User findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }

    public User saveUser(User user) {

//        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
    }

    public Optional<List<User>> findAll() {
        List<User> allUsers =  userRepository.findAll();
        if(allUsers!=null && allUsers.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(allUsers);
    }

    public Optional<List<User>> findByActive() {

        List<User> activeUsers = userRepository.findByActive(true);
         if(activeUsers!=null && activeUsers.isEmpty()){
             return Optional.empty();
         }
         return Optional.of(activeUsers);
    }
}
