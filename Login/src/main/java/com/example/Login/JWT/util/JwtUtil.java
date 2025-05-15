package com.example.Login.JWT.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class JwtUtil {

    private static String secretKey;

    @Value("${jwt.secret}")
    public void setSecretKey(String secretKey){
        JwtUtil.secretKey = secretKey;
    }

    public static String createToken(String userId, String role, long expireAt) throws Exception{
        String headerJson = "{\"alg\":\"HS256\",\"type\":\"JWT\"}";
        String payloadJson = String.format("{\"sub\":\"%s\",\"role\":\"%s\",\"exp\":%d}", userId,role, expireAt);

        String header = encode(headerJson);
        String payload = encode(payloadJson);
        String signature = sign(header + "." + payload);

        return header + "." + payload + "." + signature;
    }

    public static boolean validate(String token) throws Exception{
        String[] parts = token.split("\\.");
        if(parts.length != 3) return false;

        String expectedSignature = sign(parts[0] + "." + parts[1]);
        return expectedSignature.equals(parts[2]);
    }

    private static String encode(String input){
        return Base64.getUrlEncoder().withoutPadding().encodeToString(input.getBytes());
    }

    private static String sign(String data) throws Exception{
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secretKey.getBytes(), "HmacSHA256"));
        byte[] hash = mac.doFinal(data.getBytes());
        return Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
    }
}
