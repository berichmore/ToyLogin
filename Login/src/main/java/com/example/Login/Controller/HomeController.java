package com.example.Login.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
@CrossOrigin
public class HomeController {

    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }
    @GetMapping("/join")
    public String join(){
        return "/user/join";
    }
}
