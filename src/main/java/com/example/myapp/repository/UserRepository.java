package com.example.myapp.repository;

import com.example.myapp.entity.User;
import com.example.myapp.utils.JpaBase;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaBase<User, Integer> {
    Optional<User> findByUsername(String username);
}
