package com.preeti.jlogin.service;

import com.preeti.jlogin.model.Role;
import com.preeti.jlogin.model.User;
import com.preeti.jlogin.repository.RoleRepository;
import com.preeti.jlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private  RoleService roleService;



//    public User findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }

    public List<User> saveUser(List<User> users) {

//        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.saveAll(users);
    }

    public Optional<List<User>> findAll() {
        List<User> allUsers =  userRepository.findAll();
        if(allUsers!=null && allUsers.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(allUsers);
    }

    public Optional<List<Map<String, String>>> findByActive() {

        List<User> activeUsers = userRepository.findByActive(true);

        Collections.sort(activeUsers, Comparator.comparing(User::getName).thenComparing(User::getEmail));
//       Collections.sort(activeUsers, (u1, u2) -> u1.getName().compareTo(u2.getName()));

        //Declare a List
        List<Map<String, String>> userNames = new ArrayList();

        activeUsers.stream().forEach(usr -> {
            HashMap<String, String> userName = new HashMap<>();
            userName.put("name", usr.getName());
            userName.put("email", usr.getEmail());
            userNames.add(userName);
        });

        if(userNames!=null && userNames.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(userNames);
    }

    public List<User> findByRolesForUserIn(String role) {
        Optional<Set<Role>> option = roleService.getRoleByNames(Stream.of(role).collect(Collectors.toList()));
        List<User> getUsersByRole = userRepository.findByRolesForUserIn(option.get());
        return getUsersByRole;
    }

}
