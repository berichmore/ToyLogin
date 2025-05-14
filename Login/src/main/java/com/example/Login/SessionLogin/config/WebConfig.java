package com.example.Login.SessionLogin.config;


import com.example.Login.SessionLogin.Interceptor.AdminCheckInterceptor;
import com.example.Login.SessionLogin.Interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration  //이게 있어야 인터셉터 설정 적용
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //로그인 되어야만 접근 가능한 경로
        registry.addInterceptor(new LoginCheckInterceptor())
                .addPathPatterns("/market", "/board")
                        .excludePathPatterns("/","/login","/join");  //정적 리소스 경로

        //관리자만 접근 가능한 경로
        registry.addInterceptor(new AdminCheckInterceptor())
                .addPathPatterns("/board");
    }
}
