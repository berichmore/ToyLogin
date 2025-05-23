package com.example.Login.SessionLogin.Interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                              HttpServletResponse response,
                              Object handler) throws Exception{
        HttpSession session = request.getSession(false);
        if(session ==null || session.getAttribute("member") == null){
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}
