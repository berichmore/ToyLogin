package com.example.Login.JWT.config;

import com.example.Login.JWT.util.JwtUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String token = req.getHeader("Authorization");

        //1. 토큰이 없거나 잘못된 형식일 경우 -> 거절
        if(token == null || !token.startsWith("Bearer ")){
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Missing or Malformed");
            return;
        }

        //2. Bearer 제거하고 실제 토큰만 추출
        String jwt = token.substring(7);

        //3. JWT 유효성 검사
        try{
            if(!JwtUtil.validate(jwt)) {
                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT Token");
                return;
            }
        }catch (Exception e){
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Verification Failed");
            return;
        }

        //4. 모든 검사 통과 -> 다음 필터 또는 컨트롤러로 진행
        chain.doFilter(request, response);
    }
}
