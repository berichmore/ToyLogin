package com.example.Login.JWT.controller.RestAPIController;


import com.example.Login.JWT.dto.requestDto.JWTLoginRequestDto;
import com.example.Login.JWT.dto.responseDto.TokenResponseDto;
import com.example.Login.JWT.service.JWTMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member/jwt")
@RequiredArgsConstructor
public class JWTRestAPIController {

    private final JWTMemberService jwtMemberService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> jwtLogin(@RequestBody JWTLoginRequestDto jwtLoginRequestDto) throws Exception {
        String token = jwtMemberService.login(jwtLoginRequestDto);
        return ResponseEntity.ok(TokenResponseDto.builder()
                .token(token)
                .build());
    }
}
