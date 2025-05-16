package com.example.Login.JWT.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    public boolean validate(String token) throws Exception{
        String[] parts = token.split("\\.");
        if(parts.length != 3) return false;

        String expectedSignature = sign(parts[0] + "." + parts[1]);
        return expectedSignature.equals(parts[2]);
    }

    public static String createToken(String userId, String role, long expireAt) throws Exception{
        String headerJson = "{\"alg\":\"HS256\",\"type\":\"JWT\"}";
        String payloadJson = String.format("{\"sub\":|\"%s\",\"role\":\"%s\",\"exp\":%d}", userId, role, expireAt);

        String header = encode(headerJson);
        String payload = encode(payloadJson);
        String signature = signStatic(header + "." + payload, secretKeyStatic);

        return header + "." + payload + "." + signature;
    }

    private String sign(String data) throws Exception{
       Mac mac = Mac.getInstance("HmacSHA256");
       mac.init(new SecretKeySpec(secretKey.getBytes(), "HmacSHA256"));
       byte[] hash = mac.doFinal(data.getBytes());
       return Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
    }

    private static String encode(String input){
        return Base64.getUrlEncoder().withoutPadding().encodeToString(input.getBytes());
    }

    //static 전용 토큰 생성용 key 저장 (createToken 용도)
    private static String secretKeyStatic;
    @Value("${jwt.secretKey}")
    public void setStaticKey(String secretKey){
        secretKeyStatic = secretKey;
    }

    private static String signStatic(String data, String key)throws Exception{
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(key.getBytes(), "HmacSHA256"));
        byte[] hash = mac.doFinal(data.getBytes());
        return Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
    }
}
