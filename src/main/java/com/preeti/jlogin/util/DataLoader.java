package com.preeti.jlogin.util;

import com.preeti.jlogin.model.Role;
import com.preeti.jlogin.model.User;
import com.preeti.jlogin.repository.RoleRepository;
import com.preeti.jlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//@Controller/RestController   ; @Service   ;@Repository
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    public void run(ApplicationArguments args) {
        List<Role> roles = Stream.of(new Role("ADMIN"), new Role("MANAGER"), new Role("DEVELOPER")).collect(Collectors.toList());
        roleRepository.saveAll(roles);

        LocalDate dob = LocalDate.of(1990, 01, 01);

        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(getAlphaNumericString(4) + "@gmail.com", getAlphaNumericString(4), dob.plusYears(i), i < 5 ? true : false);
            userList.add(user);
        }
        userRepository.saveAll(userList);



    }

    // function to generate a random string of length n
    static String getAlphaNumericString(int n) {

        String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());

            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }


}