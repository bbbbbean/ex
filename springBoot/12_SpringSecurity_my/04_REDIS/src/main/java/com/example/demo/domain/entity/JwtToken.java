package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class JwtToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // name지정 : accessToken -> access_token으로 테이블에 들어감, 이름을 지정해 카멜법으로 표기되게
    // columnDefinition : 자료형 지정, text하면 크기 기본 6만자 정도
    @Column(name = "accessToken", columnDefinition = "TEXT", nullable = false)
    private String accessToken;
    @Column(name = "refreshToken", columnDefinition = "TEXT", nullable = false)
    private String refreshToken;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "createAt", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime createAt;
}
