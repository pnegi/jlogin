package com.preeti.jlogin.service;

import com.preeti.jlogin.model.Role;
import com.preeti.jlogin.model.User;
import com.preeti.jlogin.repository.RoleRepository;
import com.preeti.jlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;



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

        Collections.sort(activeUsers);

        //Declare a List
        List<Map<String, String>> userNames = new ArrayList();

        activeUsers.stream().forEach(usr -> {
            HashMap<String, String> userName = new HashMap<>();
            userName.put("name", usr.getName());
            userName.put("email", usr.getEmail());
            userNames.add(userName);
        });

        //Iterate the List and create a map for each user and
        //put name and email into the map
        // add the map to list in each iteration
//        for (int i = 0; i < activeUsers.size(); i++) {
//            User user = activeUsers.get(i);
//
//            HashMap<String, String> userName = new HashMap<>();
//            userName.put("name", user.getName());
//            userName.put("email", user.getEmail());
//
//            userNames.add(i, userName);
//        }

        //return the list of Map of String, string i.e. List<Map<String, String>> instead of list of Users

         if(userNames!=null && userNames.isEmpty()){
             return Optional.empty();
         }
         return Optional.of(userNames);
    }
}
