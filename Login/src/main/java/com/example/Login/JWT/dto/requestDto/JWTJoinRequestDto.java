package com.example.Login.JWT.dto.requestDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JWTJoinRequestDto {
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;
    private String role;
}

//builder방식은
//1. 필드 순서를 몰라도 되고
//2. 객체 생성 시 명시적 필드 지정 -> 실수도 방지가능
//3. 필드가 많아질수록 장점이 될 거임
