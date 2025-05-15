package com.example.Login.JWT.dto.responseDto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponseDto {
    private final String token;
}
