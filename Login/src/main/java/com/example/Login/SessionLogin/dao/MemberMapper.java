package com.example.Login.SessionLogin.dao;


import com.example.Login.SessionLogin.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member findByUserId(String userId);
    void insertMember(Member member);
}
