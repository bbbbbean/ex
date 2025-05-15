package com.example.demo.C07PortOne;

import com.example.demo.C04Kakao.C02KakaoLoginController;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequestMapping("/portOne")
public class PortOneController {

    String RESRAPI_KEY="-";
    String RESRAPI_SECTET="-";
    private PortOneTokenResp portOneTokenResp;

    @GetMapping("/index")
    public void index(){
        log.info("GET /portOne/index");
    }

    // 토큰
    @GetMapping("/getToken")
    @ResponseBody
    public void getToken(){
        log.info("GET /portOne/getToken");

        // 요청 정보 확인
        String url = "https://api.iamport.kr/users/getToken";

        // 요청 헤더 설정(x)
        HttpHeaders header = new HttpHeaders();
        // 요청 바디 설정
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        params.add("imp_key",RESRAPI_KEY);
        params.add("imp_secret",RESRAPI_SECTET);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params,header);

        // 요청 후 응답 확인
        RestTemplate rt = new RestTemplate();
        ResponseEntity<PortOneTokenResp> resp = rt.exchange(url, HttpMethod.POST,entity, PortOneTokenResp.class);
        System.out.println(resp);

        this.portOneTokenResp = resp.getBody();
    }

    // 결제 조회(다건 조회)
    @GetMapping("/getPayments")
    @ResponseBody
    public void payments(){
        log.info("GET /portOne/getPayments");
    }

    // 결제 취소
    // 인증 조회

    // -----------------------------------------------------------------------------------------
    // 토큰 응답
    @Data
    private static class TokenData{
        public String access_token;
        public int now;
        public int expired_at;
    }
    @Data
    private static class PortOneTokenResp{
        public int code;
        public Object message;
        public TokenData tokenData;
    }
}
