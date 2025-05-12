package com.example.Login.service;

import com.example.Login.dao.MemberMapper;
import com.example.Login.domain.Member;
import com.example.Login.dto.request.JoinRequestDto;
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
}
