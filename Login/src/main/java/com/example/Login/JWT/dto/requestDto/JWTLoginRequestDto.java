package com.example.Login.JWT.dto.requestDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class JWTLoginRequestDto {
    private String userId;
    private String userPassword;
}
