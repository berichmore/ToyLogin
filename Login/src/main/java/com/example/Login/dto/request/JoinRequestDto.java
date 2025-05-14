package com.example.Login.dto.request;

import lombok.Data;

@Data
public class JoinRequestDto {
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;

    //optional - 기본값을 user로 처리할 예정
    private String role;
}
