package com.preeti.jlogin.repository;

import com.preeti.jlogin.model.Role;
import com.preeti.jlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    List<Role> findByNameIn(List<String> names);
}
