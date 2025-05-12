package com.example.Login.Controller.RestAPIController;

import com.example.Login.dto.request.JoinRequestDto;
import com.example.Login.dto.response.MemberResponseDto;
import com.example.Login.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/member")
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

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

}
