package com.example.Login.SessionLogin.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@CrossOrigin
public class HomeController {

    @GetMapping("/")
    public String home(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        boolean isLogin = session != null && session.getAttribute("member") != null;
        model.addAttribute("isLogin", isLogin);
        return "/home/home";
    }
    @GetMapping("/login")
    public String login(){
        return "/user/login";
    }
    @GetMapping("/join")
    public String join(){
        return "/user/join";
    }
    @GetMapping("/market")
    public String market(){
        return "/market/market";
    }

    @GetMapping("/board")
    public String board(){
        return "/board/board";
    }

}
