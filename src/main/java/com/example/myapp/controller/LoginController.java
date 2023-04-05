package com.example.myapp.controller;

import com.example.myapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService loginService;

    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){

        if (loginService.login(username, password)){
            return "mainView.html";
        }
        return "error.html";
    }
}
