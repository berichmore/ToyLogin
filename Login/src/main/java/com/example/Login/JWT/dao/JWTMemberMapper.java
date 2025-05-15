package com.example.Login.JWT.dao;

import com.example.Login.JWT.domain.JWTMember;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JWTMemberMapper {
    JWTMember findByUserId(String userId);
}
