package com.example.Login.JWT.domain;


import lombok.Data;

@Data
public class JWTMember {
    private String userId;
    private String userPassword;
    private String role;
}
