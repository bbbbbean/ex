package com.example.demo.config.auth.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class RedisProperties {
    // redis 서버 위치 잡기
    @Value("${spring.redis.port}")
    private int port;
    
    @Value("${spring.redis.host}")
    private String host;
}