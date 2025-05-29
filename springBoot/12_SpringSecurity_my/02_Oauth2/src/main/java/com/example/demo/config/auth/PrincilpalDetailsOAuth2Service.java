package com.example.demo.config.auth;

import com.example.demo.config.auth.provider.GoogleUserInfo;
import com.example.demo.config.auth.provider.KakaoUserInfo;
import com.example.demo.config.auth.provider.NaverUserInfo;
import com.example.demo.config.auth.provider.OAuth2UserInfo;
import com.example.demo.domain.dto.UserDto;
import com.example.demo.domain.entity.User;
import com.example.demo.domain.repository.UserRepositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Optional;

@Service
public class PrincilpalDetailsOAuth2Service extends DefaultOAuth2UserService {

    @Autowired
    private UserRepositor userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("PrincilpalDetailsOAuth2Service's loadUser invoke");
//        // 내용이 보이면 객체가 잘 생성된거,,
//        // 확인 후 해당 요소들을 저장할 무언가를 만들어 내야함 - 카카오, 네이버, 구글 다 폼이 다름 : 세부 내용은 따로 두고 상위 클래스 생성
//        System.out.println("userRequest : "+userRequest);
//        System.out.println("PrincipalDetailsOauth2ServiceImpl's loadUser ..." + userRequest);
//        // 등록 정보, 프로퍼티 내용
//        System.out.println("userRequest.getClientRegistration() :"+ userRequest.getClientRegistration());
//        // ***
//        System.out.println("userRequest.getAccessToken() : "+ userRequest.getAccessToken());
//        System.out.println("userRequest.getAdditionalParameters() : "+ userRequest.getAdditionalParameters());
//        System.out.println("userRequest.getAccessToken().getTokenValue() : "+ userRequest.getAccessToken().getTokenValue());
//        // 토큰 유형
//        System.out.println("userRequest.getAccessToken().getTokenType().getValue() : "+ userRequest.getAccessToken().getTokenType().getValue());
//        // 동의 항목
//        System.out.println("userRequest.getAccessToken().getScopes() : "+ userRequest.getAccessToken().getScopes());



        // OAuthe User Info
        OAuth2User oAuth2User = super.loadUser(userRequest);
        // 찍으면 정보가 많음, [] 대괄호를 기준으로 나뉨, 보고 취사선택
        System.out.println("oAuth2User : "+oAuth2User);
        System.out.println("oAuth2User's get Attributes : "+oAuth2User.getAttributes());

        // 여기에 들어올 객체는 카카오일수도 네이버일수도 구글일수도 있음
        // 로그인 객체 판별 필요 - 카카오일까, 구글일까, 네이버일까
        // userRequest.getClientRegistration()를 찍어보면 registrationId='kakao', registrationId='naver'
        OAuth2UserInfo oAuth2UserInfo = null;
        String provider = userRequest.getClientRegistration().getRegistrationId();
        Map<String,Object> attributes = oAuth2User.getAttributes();

        // 판별 시작
        if(provider.startsWith("kakao")) {
            // 카카오 로그인 시
            Long id = (Long) attributes.get("id");
            // 시간 결과 : connected_at=2025-05-13T03:23:50Z << Z가 붙어있음
            // 이럴 경우 offset으로 파싱해주기
            LocalDateTime connected_at = OffsetDateTime.parse(attributes.get("connected_at").toString()).toLocalDateTime();
            Map<String, Object> properties = (Map<String, Object>) attributes.get("properties");
            Map<String, Object> kakao_account = (Map<String, Object>) attributes.get("kakao_account");

            // 인터페이스화 시킬 부분 : kakaoUserInfo
            oAuth2UserInfo = new KakaoUserInfo(id, connected_at, properties, kakao_account);
        } else if (provider.startsWith("naver")) {
            // 네이버 로그인 시
            // id만 살리고 나머지는 attribute로 한번에 넣을 예정 - 선별 필요하면 해보기
            Map<String,Object> response = (Map<String,Object>)attributes.get("response");
            String id = (String) response.get("id");

            oAuth2UserInfo = new NaverUserInfo(id,response);
        } else if (provider.startsWith("google")) {
            // 구글 로그인 시
            // 값 잘보고 꺼내기
            String id = (String)attributes.get("sub");
            oAuth2UserInfo = new GoogleUserInfo(id,attributes);

        }
        System.out.println("oAuth2UserInfo : " + oAuth2UserInfo);
        //----------------------------------------------------------------
        // 플랫폼 로그인을 한 계정을 DB에 저장, id와 임시 pw 저장 -> 다음 로그인 시 해당 id와 pw로 로그인 할 수 있게 할 예정
        // Oauth가 아닌 local로그인을 할 수 있게 최초 로그인 시 로컬 계정 DB 저장 처리
        // ex ) kakao_1234 이런식으로 플랫폼_고유아이디로 username 지정
        String username=oAuth2UserInfo.getProvider()+"_"+oAuth2UserInfo.getProviderId();
        String password=passwordEncoder.encode("1234"); // 언제나 암호화 잊지말기
        // DB에 정보 유무를 기준으로 최초인지 아닌지 판단
        Optional<User> userOptional = userRepository.findById(username);
        // UserDto 생성 : PrincipalDetails에 포함
        // UserEntity 생성 : 최초 로그인 시 DB 저장 용도

        // 양쪽 모두에서 사용 -> 다 잡히는 변수 생성
        UserDto userDto = null;
        if(userOptional.isEmpty()){
            // 최초 로그인 (Dto, Entity 생성)
            userDto = UserDto.builder().username(username).password(password).role("ROLE_USER").build();
            User user = userDto.toEntity();
            userRepository.save(user);  // 계정 등록
        }else {
            // 기존 유저 존재 (로그인 2회차~)(Dto 생성)
            // 이미 Entity가 있다는 소리
            User user = userOptional.get(); // entity 들고오기
            userDto = UserDto.toDto(user);  // 들고 온 entity dto로 변환
            // 이미 DB에 있는 내용이니 등록 할 이유 X
        }

        // principal Details는 OAuth를 제대로 처리못할 수도 있음
        // principal Detail이 Oauth도 담을 수 있는 형태가 되도록 조정 - 상속시킴
        // principal Details 전달 - OAuth 대체(상속 관계니까 대체 가능)
        PrincipalDetails principalDetails = new PrincipalDetails();
        userDto.setProvider(provider);
        userDto.setProviderId(oAuth2UserInfo.getProviderId());
        principalDetails.setUserDto(userDto);
        principalDetails.setAttributes(oAuth2User.getAttributes()); // 중요, 민감 정보가 있으면 분할시키기
        principalDetails.setAccess_token(userRequest.getAccessToken().getTokenValue()); // 각 플랫폼 서비스 이용을 위해


        return principalDetails;
    }
}
