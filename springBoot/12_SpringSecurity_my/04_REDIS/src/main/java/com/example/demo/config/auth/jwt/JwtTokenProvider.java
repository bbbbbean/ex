package com.example.demo.config.auth.jwt;


import com.example.demo.config.auth.PrincipalDetails;
import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.entity.Signature;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.SignatureRepository;
import com.example.demo.domain.repository.UserRepositor;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider {

    @Autowired
    private UserRepositor userRepository;

    @Autowired
    private SignatureRepository signatureRepository;

    //Key 저장
    private Key key;
    public void setKey(Key key){
        this.key = key;
    }
    public Key getKey(){
        return this.key;
    }

    // Signature 저장
    @PostConstruct
    public void init(){
        List<Signature> list = signatureRepository.findAll();   // 어파치 1개 값만 저장되어 있음
        if(list.isEmpty()){
            // 처음 Signature 발급-> 처음 발급하면? DB에두 넣어야함
            byte[] keyBytes = KeyGenerator.getKeygen();
            this.key = Keys.hmacShaKeyFor(keyBytes);
            Signature signature = new Signature();
            signature.setKeyBytes(keyBytes);
            signature.setCreateAt(LocalDate.now());
            signatureRepository.save(signature);
            System.out.println("JwtTokenProvider Constructor  Key init: " + key);
        }else{
            // 기존 Signature dldyd
            Signature signature = list.get(0);
            this.key = Keys.hmacShaKeyFor(signature.getKeyBytes());
            System.out.println("JwtTokenProvider Constructor  기존 Key : " + key);
        }
    }

        public JwtTokenProvider() {
            // 키젠값 해시 암호화
            // 서명값은 일정 기간동안 유지되어야 함 - DB 혹은 서버에 저장 - 서명값이 달라지면 키젠 암호값도 달라짐
//            byte[] keyBytes = KeyGenerator.getKeygen();
//            this.key = Keys.hmacShaKeyFor(keyBytes);
//            System.out.println("JwtTokenProvider Constructor  Key init: " + key);

        }

    // 유저 정보를 가지고 AccessToken, RefreshToken 을 생성하는 메서드
    public TokenInfo generateToken(Authentication authentication) {
        // 권한 가져오기
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        long now = (new Date()).getTime();

        // Access Token 생성
        Date accessTokenExpiresIn = new Date(now+JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME); // 만료 시간 1분
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("username",authentication.getName()) //정보저장
                .claim("auth", authorities)//정보저장
                .setExpiration(accessTokenExpiresIn)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        // Refresh Token 생성
        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now + JwtProperties.REFRESH_TOKEN_EXPIRATION_TIME))    // 만료 시간 5분
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        System.out.println("JwtTokenProvider.generateToken.accessToken : " + accessToken);
        System.out.println("JwtTokenProvider.generateToken.refreshToken : " + refreshToken);

        return TokenInfo.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }


    // JWT 토큰을 복호화하여 토큰에 들어있는 정보를 꺼내는 메서드
    // 한번 이상 로그인 한 이후
    public Authentication getAuthentication(String accessToken) {
        // 토큰 복호화
        Claims claims = parseClaims(accessToken);   // access 토큰을 꺼내서 claims를 꺼낼 때 사용, 검증하는 과정 포함 - 하단에 정의 ㅇ

        if (claims.get("auth") == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }
        // 클레임에서 권한 정보 가져오기
        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get("auth").toString().split(","))
                        .map(auth -> new SimpleGrantedAuthority(auth))
                        .collect(Collectors.toList());

        String username = claims.getSubject(); //username
        // UserDetails 객체를 만들어서 Authentication 리턴
        PrincipalDetails principalDetails =new PrincipalDetails();
        // UserDto userDto = new UserDto(); 이 과정 레포지토리에서 들고와서 완성, 왜? 내용이 너무 없음..
        Optional<User> userOptional = userRepository.findById(username);
        UserDto userDto = null;
        if(userOptional.isPresent()){
            userDto = userDto.toDto(userOptional.get());
        }
        principalDetails.setUserDto(userDto);

        //UserDetails principal = new User(username, "", authorities);
        System.out.println("JwtTokenProvider.getAuthentication UsernamePasswordAuthenticationToken : " + accessToken);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(principalDetails, "", authorities);
        return usernamePasswordAuthenticationToken;
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).getBody();   // 결과물의 body, 본문을 꺼냄
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    // 토큰 정보를 검증하는 메서드
    public boolean validateToken(String token) throws ExpiredJwtException {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("Invalid JWT Token", e);
        }
        catch (ExpiredJwtException e) {   // 토큰이 만료됐을때
            log.info("Expired JWT Token", e);
            throw new ExpiredJwtException(null,null,null);
        } catch (UnsupportedJwtException e) {   // 시스템에서 지원하지 않는 토큰
            log.info("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT claims string is empty.", e);
        }
        return false;
    }
}