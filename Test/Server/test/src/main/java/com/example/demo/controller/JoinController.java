package com.example.demo.controller;

import com.example.demo.domain.Dto.UserDto;
import com.example.demo.domain.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class JoinController {


    @Autowired
    private UserMapper userMapper;

    @Autowired(required=true)
    private UserDto userDto;

    @GetMapping("/join")
    public String joinpage(){
        log.info("GET /join");
        return "/join";
    }

    @PostMapping("/join")
    public void join(){
        log.info("Post /join");
        userMapper.insert(userDto);
    }
}
