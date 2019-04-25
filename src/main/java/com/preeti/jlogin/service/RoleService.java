package com.preeti.jlogin.service;

import com.preeti.jlogin.model.Role;
import com.preeti.jlogin.repository.RoleRepository;
import com.preeti.jlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("roleService")
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> saveRole(List<Role> roles) {
        return roleRepository.saveAll(roles);
    }

    public Optional<List<Role>> findAll() {
        List<Role> allRoles =  roleRepository.findAll();
        if(allRoles!=null && allRoles.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(allRoles);
    }

    public List<Role> getRoleByNames(List<String> names) {
        List<Role> roles = roleRepository.findByNameIn(names);
        return roles;

    }

}
