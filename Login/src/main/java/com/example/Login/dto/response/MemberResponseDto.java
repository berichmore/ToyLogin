package com.example.Login.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {
    private String userId;
    private String userName;
    private String userEmail;
}
