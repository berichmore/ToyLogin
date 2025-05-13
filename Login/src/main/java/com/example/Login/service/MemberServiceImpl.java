package com.example.Login.service;

import com.example.Login.dao.MemberMapper;
import com.example.Login.domain.Member;
import com.example.Login.dto.request.JoinRequestDto;
import com.example.Login.dto.request.LoginRequestDto;
import com.example.Login.dto.response.MemberResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void join(JoinRequestDto joinRequestDto) {

        Member member = new Member();
        member.setUserId(joinRequestDto.getUserId());
        member.setUserPassword(bCryptPasswordEncoder.encode(joinRequestDto.getUserPassword()));
        member.setUserName(joinRequestDto.getUserName());
        member.setUserEmail(joinRequestDto.getUserEmail());

        memberMapper.insertMember(member);

    }

    @Override
    public MemberResponseDto login(LoginRequestDto loginRequestDto, HttpServletRequest request) {
        Member member = memberMapper.findByUserId(loginRequestDto.getUserId());
        System.out.println("userPassword: from Db = " + member.getUserPassword());

        if(member == null){
            throw new RuntimeException("존재하지 않는 회원입니다.");
        }

        if(!bCryptPasswordEncoder.matches(loginRequestDto.getUserPassword(), member.getUserPassword())){
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        //세션 저장
        HttpSession session = request.getSession();
        session.setAttribute("member", member);  //로그인 세션 등록

        return MemberResponseDto.builder()
                .userId(member.getUserId())
                .userName(member.getUserName())
                .userEmail(member.getUserEmail())
                .build();
    }



}
