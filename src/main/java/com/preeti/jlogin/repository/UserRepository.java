package com.preeti.jlogin.repository;

import com.preeti.jlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByActive(Boolean active);
}
