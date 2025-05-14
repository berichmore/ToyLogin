package com.example.Login.SessionLogin.service;


import com.example.Login.SessionLogin.dto.request.JoinRequestDto;
import com.example.Login.SessionLogin.dto.request.LoginRequestDto;
import com.example.Login.SessionLogin.dto.response.MemberResponseDto;
import jakarta.servlet.http.HttpServletRequest;

public interface MemberService {
    void join(JoinRequestDto joinRequestDto);
    MemberResponseDto login(LoginRequestDto loginRequestDto, HttpServletRequest request);
}
