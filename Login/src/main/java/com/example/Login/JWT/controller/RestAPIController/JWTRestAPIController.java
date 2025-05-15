package com.example.Login.JWT.controller.RestAPIController;


import com.example.Login.JWT.dto.requestDto.JWTLoginRequestDto;
import com.example.Login.JWT.dto.responseDto.TokenResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt/api/member")
public class JWTRestAPIController {
    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> jwtlogin(
                                    @RequestBody JWTLoginRequestDto loginRequestDto)throws Exception{
        String token = jwt
    }
}
