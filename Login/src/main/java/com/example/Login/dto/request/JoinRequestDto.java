package com.example.Login.dto.request;

import lombok.Data;

@Data
public class JoinRequestDto {
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;
}
