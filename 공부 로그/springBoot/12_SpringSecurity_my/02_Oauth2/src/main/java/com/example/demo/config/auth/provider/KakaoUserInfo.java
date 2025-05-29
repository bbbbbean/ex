package com.example.demo.config.auth.provider;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

// 서버로부터 전달되는 내용을 각 플랫폼(카카오,네이버,구글)에 맞게 받아 규격화 시키는 작업 중
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KakaoUserInfo implements OAuth2UserInfo{
    // 처음에 모든 정보를 한번에 들고옴
    //private Map<String,Object> attributes;

    // attributes에서 필요한 정보만 추출
    private Long id;
    private LocalDateTime connected_at;
    private Map<String,Object> properties;
    private Map<String,Object> kakao_account;

    @Override
    public String getName() {
        // object기 때문에 string 형변환 필요
        return (String) properties.get("nickname");
    }

    @Override
    public String getEmail() {
        return (String) kakao_account.get("email");
    }

    @Override
    public String getProvider() {
        // 어떤 플랫폼으로 로그인했나, OAuth 구분용
        return "Kakao";
    }

    @Override
    public String getProviderId() {
        return id+"";
    }

    @Override
    public Map<String, Object> getAttributes() {
        // 이미 추출 선별 다 해서 필요없음 -> null처리
        return null;
    }
   

}
