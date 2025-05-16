package com.example.demo.config.auth.provider;


import java.util.Map;

public interface OAuth2UserInfo {   // 지금은 카카오지만 공통적으로 내용을 담을 수 있는 추상함수를 만들 예정
    String getName();
    String getEmail();
    String getProvider();
    String getProviderId();
    Map<String, Object> getAttributes();
}
