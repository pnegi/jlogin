package com.preeti.jlogin.practice;

import com.preeti.jlogin.model.Role;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionPractice {

    public static void main(String[] args) {

        List<Role> roles = Stream.of(
                                    Role.builder().name("dev").build(),
                                    Role.builder().name("MANAGER").build(),
                                    Role.builder().name("ADMIN").build())
                                    .collect(Collectors.toList());

//        Role devRole = Role.builder().name("DEVELOPER").build();
//
//        Role managerRole = Role.builder().name("MANAGER").build();
//
//        Role adminRole = Role.builder().name("ADMIN").build();
//
//        roles.add(devRole);
//        roles.add(managerRole);
//        roles.add(adminRole);

        System.out.println(removeAdmin(roles));

    }

    //remove admin role from list of roles
    //assume roles are coming as input param, remove admin roled and return rest of roles
    public static List<Role> removeAdmin(List<Role> rolesFromDB){

        Iterator<Role> irt = rolesFromDB.iterator();
        while (irt.hasNext()){
            Role r = irt.next();
            if(r.getName().equals("ADMIN"))
                irt.remove();
        }
        return rolesFromDB;

    }
}
