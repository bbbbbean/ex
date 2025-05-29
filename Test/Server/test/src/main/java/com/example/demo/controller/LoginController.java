package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String loginpage(){
        log.info("GET /login");
        return "login";
    }

    @PostMapping("/login")
    public void login(){
        log.info("POST /login");
    }

}
