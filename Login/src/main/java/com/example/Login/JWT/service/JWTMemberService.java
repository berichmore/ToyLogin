package com.example.Login.JWT.service;

import com.example.Login.JWT.dto.requestDto.JWTLoginRequestDto;

public interface JWTMemberService {
    String login(JWTLoginRequestDto jwtLoginRequestDto) throws Exception;
}
