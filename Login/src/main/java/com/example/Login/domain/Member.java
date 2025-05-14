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

    private MemberRole role;


    // resultType으로 매핑할 경우 문자열로 들어오기 때문에 아래 setter 필요
    public void setRole(MemberRole role){
//        this.role = MemberRole.valueOf(role.toUpperCase());
//        toUpperCase는 String에만 있는거고 enum을 써야하니 쓰지마
        this.role = role;
    }

    //Db에서 String으로 읽어올 때 (MyBatis용)
    public void setRole(String role){
        this.role = MemberRole.valueOf(role.toUpperCase());
    }


}

//MyBatis는 enum을 자동으로 매핑 안 해주기 때문에, 수동으로
//.name() 또는 .valueOf()를 써야 해.

//1. insertMember 매핑 (Java -> DB)
//#[role] -> #{role.name()}로 변경
//
 // INSERT INTO member (user_id, user_password, user_name, user_email, role)
//  VALUES (#{userId}, #{userPassword}, #{userName}, #{userEmail}, #{role.name()});

//2. findByUserId 매핑 ( DB -> Java)
//MyBatis는 자동으로 String -> Enum 변환을 못하므로
//Mapper XML에서 특별한 설정이 없으면 이렇게한다.

//xml
//<select id="findByUserId" resultType = "com.example.Login.domain.Member">
//    SELECT seq, user_id, user_password, user_name, user_email, role,
//            created_at, updated_at
//    FROM member
//    WHERE user_id = #{userId}
//</select>

//그리고 member 클래스의 setRole()이 아래처럼 자동 변환을 처리하게 된다면

//public void setRole(String role){
//    this.role = MemberRole.valueOf(role.toUpperCase());
//}

// 또는 enum 매핑용 TypeHandler를 따로 지정할 수도 있음
//하지만 지금은 String <-> enum  직접처리로 충분함



// @Data
//    @Getter,@Setter,
//    @ToString,
//    @EqualsAndHashCode
//    @RequiredArgsConstructor