package com.example.Login.service;


import com.example.Login.domain.Member;
import com.example.Login.dto.request.JoinRequestDto;
import com.example.Login.dto.request.LoginReqeustDto;
import com.example.Login.dto.response.MemberResponseDto;
import jakarta.servlet.http.HttpServletRequest;

public interface MemberService {
    void join(JoinRequestDto joinRequestDto);
    MemberResponseDto login(LoginReqeustDto loginReqeustDto, HttpServletRequest request);
}
