package com.example.Login.config;


import com.example.Login.SessionLogin.Interceptor.AdminCheckInterceptor;
import com.example.Login.SessionLogin.Interceptor.LoginCheckInterceptor;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration  //이게 있어야 인터셉터 설정 적용
public class WebConfig implements WebMvcConfigurer {

    //Session Interceptor
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
    @Bean
    public FilterRegistrationBean<Filter> jwtFilter(JwtAuthFilter jwtAuthFilter){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtAuthFilter);
        registrationBean.addUrlPatterns("/jwt/protected/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
//package com.example.Login.JWT.config;
//
//import com.example.Login.config.JwtAuthFilter;
//import jakarta.servlet.Filter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class WebConfigff {
//
//    @Bean
//    public FilterRegistrationBean<Filter> jwtFilter(JwtAuthFilter jwtAuthFilter){
//        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(jwtAuthFilter);
//        registrationBean.addUrlPatterns("/jwt/protected/*"); //JWT 인증이 필요한 경로
//        registrationBean.setOrder(1);  //필터 실행 순서
//        return registrationBean;
//    }
//}
