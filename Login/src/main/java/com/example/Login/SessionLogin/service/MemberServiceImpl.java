package com.example.Login.SessionLogin.service;

import com.example.Login.SessionLogin.dao.MemberMapper;
import com.example.Login.SessionLogin.domain.Member;
import com.example.Login.SessionLogin.domain.MemberRole;
import com.example.Login.SessionLogin.dto.request.JoinRequestDto;
import com.example.Login.SessionLogin.dto.request.LoginRequestDto;
import com.example.Login.SessionLogin.dto.response.MemberResponseDto;
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

        //기본 권한 설정
        member.setRole(MemberRole.USER);
//        member.setRole(MemberRole.USER.name()); -
//        -> 이렇게 쓰면 결국 enum이 아닌 String을 쓰는 꼴이 되기에 이리는 하지말아야

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
