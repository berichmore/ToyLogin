package com.example.Login.JWT.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jwt")
public class JWTHomeController {
//    @GetMapping("/")
//    public String home(){
//        return "/home/home";
//    }
    @GetMapping("/join")
    public String JWTjoin(){
        return "jwtuser/JWTJoin";
    }
}
