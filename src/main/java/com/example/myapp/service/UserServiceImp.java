package com.example.myapp.service;

import com.example.myapp.dto.UserDto;
import com.example.myapp.entity.User;
import com.example.myapp.repository.UserRepository;
import com.example.myapp.utils.JpaBaseImp;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImp extends JpaBaseImp<User, Integer, UserRepository, UserDto> implements UserService {

    public UserServiceImp() {
        super(UserRepository.class, User.class, UserDto.class);
    }

    public List<UserDto> findUsers() {
        return getDao().findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<User> findAllByFilter(Specification specification){
        return getDao().findAll(specification);
    }

    public UserDto findUserByLogin(String username){
        Optional<User> user =  getDao().findByUsername(username);
        if (user.isPresent()){
            return user.map(this::entityToDto).get();
        }
        return null;
    }
}
