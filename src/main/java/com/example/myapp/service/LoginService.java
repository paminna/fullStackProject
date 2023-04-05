package com.example.myapp.service;

import com.example.myapp.entity.User;
import com.example.myapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String username, String password){
        Optional<User> foundUser = userRepository.findByUsername(username);
        if (foundUser.isPresent() && foundUser.get().getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
