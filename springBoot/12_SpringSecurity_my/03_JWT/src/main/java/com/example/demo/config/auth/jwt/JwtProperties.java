package com.example.demo.config.auth.jwt;

/**
 * JWT 기본 설정값
 */
public class JwtProperties {
    public static final int ACCESS_TOKEN_EXPIRATION_TIME = 1000*30; // 60초, 미리초단위
    public static final int REFRESH_TOKEN_EXPIRATION_TIME = 1000*60*2; // 5분, 미리초단위
    public static final String ACCESS_TOKEN_COOKIE_NAME = "access-token";    // 쿠키 이름
    public static final String REFRESH_TOKEN_COOKIE_NAME = "refresh-token";    // 쿠키 이름
}