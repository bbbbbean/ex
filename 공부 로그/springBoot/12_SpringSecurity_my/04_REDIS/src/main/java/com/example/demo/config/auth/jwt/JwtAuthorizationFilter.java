package com.example.demo.config.auth.jwt;


///**
// * JWT를 이용한 인증
// */
//public class JwtAuthorizationFilter extends OncePerRequestFilter {
//
//    private final UserRepositor userRepository;
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public JwtAuthorizationFilter(
//            UserRepositor userRepository,
//            JwtTokenProvider jwtTokenProvider
//    ) {
//        this.userRepository = userRepository;
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @Override
//    protected void doFilterInternal(    // 필터 역할 클래스
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain chain
//    ) throws IOException, ServletException, IOException {
//        System.out.println("[JWTAUTHORIZATIONFILTER] doFilterInternal...");
//
//        // 쿠키에서 토큰을 꺼내는 작업
//        String token = null;
//        try {
//            // cookie 에서 JWT token을 가져옵니다.
//            token = Arrays.stream(request.getCookies())
//                    .filter(cookie -> cookie.getName().equals(JwtProperties.ACCESS_TOKEN_COOKIE_NAME)).findFirst()
//                    .map(cookie -> cookie.getValue())
//                    .orElse(null);
//        } catch (Exception ignored) {
//
//        }
//        // 토큰이 존재한다면? 유효성 판단. 유효한지 아닌지
//        if (token != null) {
//            try {
//                if(jwtTokenProvider.validateToken(token)) {
//                    // 유효한 경우
//                    Authentication authentication = getUsernamePasswordAuthenticationToken(token);
//                    SecurityContextHolder.getContext().setAuthentication(authentication);   // 로그인 한 이후 사용자의 정보를 auth로 만드는 작업
//                    System.out.println("[JWTAUTHORIZATIONFILTER] : " + authentication);
//                }
//            } catch (ExpiredJwtException e)     //토큰만료시 예외처리(쿠키 제거)
//            {
//
//                System.out.println("[JWTAUTHORIZATIONFILTER] : ...ExpiredJwtException ...."+e.getMessage());
//
//                //토큰 만료시 처리(Refresh-token으로 갱신처리는 안함-쿠키에서 제거)
////                Cookie cookie = new Cookie(JwtProperties.COOKIE_NAME, null);
////                cookie.setMaxAge(0);
////                response.addCookie(cookie);
//
//            }catch(Exception e2){
//
//            }
//        }
//        chain.doFilter(request, response);
//    }
//
//    /**
//     * JWT 토큰으로 User를 찾아서 UsernamePasswordAuthenticationToken를 만들어서 반환한다.
//     * User가 없다면 null
//     */
//    private Authentication getUsernamePasswordAuthenticationToken(String token) {
//
//        Authentication authentication = jwtTokenProvider.getAuthentication(token);  // 들어온 토큰을 받음
//        Optional<User> user = userRepository.findById(authentication.getName()); // 유저를 유저명으로 찾습니다. DB에 있는지 여부
//        System.out.println("JwtAuthorizationFilter.getUsernamePasswordAuthenticationToken...authenticationToken : " +authentication );
//        if(user.isPresent())
//            return authentication; // 유저가 DB에 있다면
//        return null; // 유저가 없으면 NULL
//    }

//}

import com.example.demo.config.auth.redis.RedisUtil;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.JwtTokenRepository;
import com.example.demo.domain.repository.UserRepositor;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

/**
 * JWT를 이용한 인증
 */
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final UserRepositor userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtTokenRepository jwtTokenRepository;
    private final RedisUtil redisUtil;


    @Override
    @Transactional(rollbackFor = Exception.class)
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException, IOException {
        System.out.println("[JWTAUTHORIZATIONFILTER] doFilterInternal...");

        // cookie 에서 JWT token을 가져옵니다.
        // 쿠키가 아예 없을 수도 있음 -> if나 try catch로 예외 잡기
        String token = null;
        String username = null;

        try{
            token = Arrays.stream(request.getCookies())
                    .filter(cookie -> cookie.getName().equals(JwtProperties.ACCESS_TOKEN_COOKIE_NAME)).findFirst()
                    .map(cookie -> cookie.getValue())
                    .orElse(null);
            username = Arrays.stream(request.getCookies())
                    .filter(cookie -> cookie.getName().equals("username")).findFirst()
                    .map(cookie -> cookie.getValue())
                    .orElse(null);
        }catch (Exception e){

        }
        if (token != null && username!=null) {
            // AT를 받았음
            try {
                if(jwtTokenProvider.validateToken(token)) { // AT 유효성 체크 - 만료 예외 발생 시 .validateToken이 만료 예외를 던짐, 어디로? 아래 catch로
                    Authentication authentication = getUsernamePasswordAuthenticationToken(token);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println("[JWTAUTHORIZATIONFILTER] : " + authentication);
                }
            } catch (ExpiredJwtException e)     //토큰만료시 예외처리(쿠키 제거)
            {
                // (DB) 토큰 만료시 리프레시 토큰 확인
//                JwtToken jwtToken = jwtTokenRepository.findByAccessToken(token);

//                if(jwtToken!=null){

//                    try{
//                        if(jwtTokenProvider.validateToken(refreshToken)){
//                            // accessToken 만료, refreshToken 유효 -> AT 갱신 처리
//                            // AT 새로 만든단다.........
//                            long now = (new Date()).getTime();
//                            // findByUsername 걍 만들어
//                            User user = userRepository.findByUsername(jwtToken.getUsername());
//                            // Access Token 생성
//                            Date accessTokenExpiresIn = new Date(now+JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME); // 만료 시간 1분
//                            String accessToken = Jwts.builder()
//                                    .setSubject(jwtToken.getUsername())
//                                    .claim("username",jwtToken.getUsername()) //정보저장
//                                    .claim("auth", user.getRole()) //role정보저장
//                                    .setExpiration(accessTokenExpiresIn)
//                                    // key도 꺼내올 수 있게 provider가서 getter만듦
//                                    .signWith(jwtTokenProvider.getKey(), SignatureAlgorithm.HS256)
//                                    .compact();
//                            // 클라이언트에게 전달 + DB저장
//                            // 쿠키 전달을 로그인 핸들러에서 했었대.. 그거 들고오기...................
//                            Cookie cookie = new Cookie(JwtProperties.ACCESS_TOKEN_COOKIE_NAME,accessToken); // (key, value)
//                            cookie.setMaxAge(JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME);
//                            cookie.setPath("/");
//                            response.addCookie(cookie);
//                            // DB에 갱신된 내용 저장
//                            jwtToken.setAccessToken(accessToken);
//                            jwtTokenRepository.save(jwtToken);
//                        }
//                    }catch (ExpiredJwtException refreshTokenExpiredException){
//                        // AT, RT 모두 만료 시
//                        // 클라이언트(브라우저) AT 삭제(만료된거들고있으면 안되니까...............)
//                        // 토큰쿠키 삭제는 로그아웃에 있댕.........
//                        Cookie cookie = new Cookie(JwtProperties.ACCESS_TOKEN_COOKIE_NAME,null);
//                        cookie.setMaxAge(0);
//                        cookie.setPath("/");
//                        response.addCookie(cookie);
//                        // DB에서도 토큰 삭제
//                        jwtTokenRepository.deleteById(jwtToken.getId());
//                    }
                // --------------------------------------------------------------------------
                // redis
                // 유저 네임을 뽑을 곳이 없네.. 쿠키로 유저 네임만 던지기..
                String refreshToken = redisUtil.getRefreshToken("RT:"+username);
                try{
                    if(jwtTokenProvider.validateToken(refreshToken)){
                        // accessToken 만료, refreshToken 유효 -> AT 갱신 처리
                        long now = (new Date()).getTime();
                        User user = userRepository.findByUsername(username);
                        // Access Token 생성
                        Date accessTokenExpiresIn = new Date(now+JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME); // 만료 시간 1분
                        String accessToken = Jwts.builder()
                                .setSubject(username)
                                .claim("username",username) //정보저장
                                .claim("auth", user.getRole()) //role정보저장
                                .setExpiration(accessTokenExpiresIn)
                                // key도 꺼내올 수 있게 provider가서 getter만듦
                                .signWith(jwtTokenProvider.getKey(), SignatureAlgorithm.HS256)
                                .compact();
                        // 클라이언트에게 전달
                        Cookie cookie = new Cookie(JwtProperties.ACCESS_TOKEN_COOKIE_NAME,accessToken); // (key, value)
                        cookie.setMaxAge(JwtProperties.ACCESS_TOKEN_EXPIRATION_TIME);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }catch (ExpiredJwtException refreshTokenExpiredException){
                    // AT, RT 모두 만료 시
                    Cookie cookie = new Cookie(JwtProperties.ACCESS_TOKEN_COOKIE_NAME,null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    // username 쿠키도 삭제
                    Cookie usercookie = new Cookie(username,null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(usercookie);
                    // redis에서 삭제
                    redisUtil.delete("RT:"+username);
                }

                System.out.println("[JWTAUTHORIZATIONFILTER] : ...ExpiredJwtException ...."+e.getMessage());
            }catch(Exception e2){
                //그외 나머지
            }
        }
        chain.doFilter(request, response);
    }

    // TOKEN -> AUTHENTICATION 변환
    private Authentication getUsernamePasswordAuthenticationToken(String token) {
        Authentication authentication = jwtTokenProvider.getAuthentication(token);
        Optional<User> user = userRepository.findById(authentication.getName()); // 유저를 유저명으로 찾습니다.
        System.out.println("JwtAuthorizationFilter.getUsernamePasswordAuthenticationToken...authenticationToken : " +authentication );
        if(user.isPresent())
            return authentication;
        return null; // 유저가 없으면 NULL
    }

}