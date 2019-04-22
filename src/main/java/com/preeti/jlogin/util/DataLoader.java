package com.preeti.jlogin.util;

import com.preeti.jlogin.model.User;
import com.preeti.jlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//@Controller/RestController   ; @Service   ;@Repository
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    public void run(ApplicationArguments args) {
        LocalDate dob = LocalDate.of(1990, 01, 01);

        List<User> userList = new ArrayList<>();

        for (int i  =  0; i < 10; i++) {
            User user = new User("mail"+i+"@gmail.com", "name"+i, dob.plusYears(i), i<5?true:false);
            userList.add(user);
        }

        userRepository.saveAll(userList);

//        userRepository.save(new User("lala", "lala", "lala"));
    }


}
