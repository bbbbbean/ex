package com.example.demo.config.auth.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TokenInfo {    // DTO같은 개념
    private String grantType;
    private String accessToken;
    private String refreshToken;
}