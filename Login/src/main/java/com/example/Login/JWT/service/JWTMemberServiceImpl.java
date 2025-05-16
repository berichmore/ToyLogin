package com.example.Login.JWT.service;

import com.example.Login.JWT.dao.JWTMemberMapper;
import com.example.Login.JWT.domain.JWTMember;
import com.example.Login.JWT.dto.requestDto.JWTLoginRequestDto;
import com.example.Login.JWT.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JWTMemberServiceImpl implements JWTMemberService{

    private final JWTMemberMapper jwtMemberMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String login(JWTLoginRequestDto jwtLoginRequestDto) throws Exception {
        JWTMember member = jwtMemberMapper.findByUserId(jwtLoginRequestDto.getUserId());

        if( member == null){
            throw new RuntimeException("존재하지 않는 사용자입니다.");
        }
        if(!bCryptPasswordEncoder.matches(jwtLoginRequestDto.getUserPassword(), member.getUserPassword())){
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        long expirationTime = System.currentTimeMillis() + (1000 * 60 * 60); //1시간
        return JwtUtil.createToken(member.getUserId(), member.getRole(), expirationTime);
    }
}
