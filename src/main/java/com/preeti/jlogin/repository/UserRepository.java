package com.preeti.jlogin.repository;

import com.preeti.jlogin.model.Role;
import com.preeti.jlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByActive(Boolean active);
    List<User> findByRolesForUserIn(Set<Role> role);
}
