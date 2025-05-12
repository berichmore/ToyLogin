package com.example.Login.dao;


import com.example.Login.domain.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member findByUserId(String userId);
    void insertMember(Member member);
}
