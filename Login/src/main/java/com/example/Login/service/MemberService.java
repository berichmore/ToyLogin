package com.example.Login.service;


import com.example.Login.domain.Member;
import com.example.Login.dto.request.JoinRequestDto;

public interface MemberService {
    void join(JoinRequestDto joinRequestDto);
}
