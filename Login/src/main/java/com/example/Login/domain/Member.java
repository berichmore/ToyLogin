package com.example.Login.domain;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Member {
    private Long seq;
    private String userId;
    private String userPassword;
    private String userName;
    private String userEmail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}



// @Data
//    @Getter,@Setter,
//    @ToString,
//    @EqualsAndHashCode
//    @RequiredArgsConstructor