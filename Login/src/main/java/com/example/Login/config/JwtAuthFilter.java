package com.example.Login.config;

import com.example.Login.JWT.util.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthFilter implements Filter {

    private final JwtUtil jwtUtil;

    public JwtAuthFilter(JwtUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String token = req.getHeader("Authorization");

        if(token == null || !token.startsWith("Bearer ")){
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Missing or Malformed");
            return;
        }

        String jwt = token.substring(7);

        try{
            if (!jwtUtil.validate(jwt)){
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT Token");
                return;
            }
        }catch (Exception e){
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token verification failed");
            return;
        }
        chain.doFilter(request,response);
    }
}
