package com.example.Login.Controller;

import com.example.Login.domain.Member;
import com.example.Login.domain.MemberRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String board(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session == null){
            return "redirect:/login";
        }
//        enum 비교는 equals()대신 == 또는 != 비교 가능(enum은 단일 인스턴스)
        Member member = (Member) session.getAttribute("member");
        if(member.getRole() != MemberRole.ADMIN){
            return "redirect:/login";
        }
        return "/board/board";
    }

}
