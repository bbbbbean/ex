package com.example.demo.config.auth.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NaverUserInfo implements OAuth2UserInfo {
    private String id;
    private Map<String,Object> attributes;

    // 네이버 로그인때 확인한 정보 잘 넣어주기
    @Override
    public String getName() {
        return (String)attributes.get("name");
    }

    @Override
    public String getEmail() {
        return (String)attributes.get("email");
    }

    @Override
    public String getProvider() {
        return "Naver";
    }

    @Override
    public String getProviderId() {
        return id;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }
}
