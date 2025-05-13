package com.example.Login.Controller.RestAPIController;

import com.example.Login.dto.request.JoinRequestDto;
import com.example.Login.dto.request.LoginRequestDto;
import com.example.Login.dto.response.MemberResponseDto;
import com.example.Login.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberRestController {

    private final MemberService memberService;


    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        // getSession(false)는 새로 만들지 않고
        // 있는 세션만 가져오도록 해서 불필요한 세션 생성 방지 (없으면 null반환)
        if(session != null){
            session.invalidate();  //세션 무효화
        }
        return ResponseEntity.ok("로그아웃이 완료되었습니다.");
    }

    @PostMapping("/join")
    public ResponseEntity<MemberResponseDto> join(@RequestBody JoinRequestDto joinRequestDto){
        memberService.join(joinRequestDto);

        MemberResponseDto responseDto= MemberResponseDto.builder()
                .userId(joinRequestDto.getUserId())
                .userName(joinRequestDto.getUserName())
                .userEmail(joinRequestDto.getUserEmail())
                .build();

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<MemberResponseDto> login(@RequestBody LoginRequestDto loginRequestDto,
                                                   HttpServletRequest request){
        MemberResponseDto responseDto = memberService.login(loginRequestDto, request);
        return ResponseEntity.ok(responseDto);
    }

}
