package com.example.Login.JWT.config;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<Filter> jwtFilter(JwtAuthFilter jwtAuthFilter){
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtAuthFilter);
        registrationBean.addUrlPatterns("/jwt/protected/*"); //JWT 인증이 필요한 경로
        registrationBean.setOrder(1);  //필터 실행 순서
        return registrationBean;
    }
}
