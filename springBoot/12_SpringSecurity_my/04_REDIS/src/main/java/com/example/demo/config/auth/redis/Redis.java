package com.example.demo.config.auth.redis;

import com.example.demo.config.auth.jwt.JwtProperties;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

// 리프레시 토큰 만료시간까지만 정보 유지
@RedisHash(value = "JwtToken", timeToLive = JwtProperties.REFRESH_TOKEN_EXPIRATION_TIME)
@AllArgsConstructor
@Data
public class Redis {
    // redis에 저장된 정보들
    @Id
    private String email;
    private String refreshToken;
}