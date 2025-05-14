package com.example.Login.Interceptor;


import com.example.Login.domain.Member;
import com.example.Login.domain.MemberRole;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AdminCheckInterceptor implements HandlerInterceptor {
   @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception{
       HttpSession session = request.getSession(false);
       if(session ==null || session.getAttribute("member") == null){
           response.sendRedirect("/login");
           return false;
       }
       Member member = (Member) session.getAttribute("member");
       if(member.getRole() != MemberRole.ADMIN){
           response.sendError(HttpServletResponse.SC_FORBIDDEN, "관리자만 접근 가능합니다.");
           return false;
       }
       return true;
   }
}
