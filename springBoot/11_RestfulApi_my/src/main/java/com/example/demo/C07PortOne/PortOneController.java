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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequestMapping("/portOne")
public class PortOneController {

    String RESRAPI_KEY="6206758257785877";
    String RESRAPI_SECTET="YWnk69aqoVILehOxeo2DUV3UdALhKnvoNbtuqTkrygSFhoFl570oCchlleHty7Ug4I3lLxRsAnxO3BUx";
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

        // 요청 정보 확인
        String url = "https://api.iamport.kr/payments?imp_uid[]=imp_794331117854&merchant_uid[]=";

        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+portOneTokenResp.getResponse().getAccess_token());
        // 요청 바디 설정
        // MultiValueMap : 여러 값을 전달할 때 유리
//        MultiValueMap<String, String> params = new LinkedMultiValueMap();
//        params.add("imp_uid[]","[]");
//        params.add("merchant_uid[]","[]");

        HttpEntity entity = new HttpEntity<>(header);

        // 요청 후 응답 확인
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> resp = rt.exchange(url, HttpMethod.GET,entity, String.class);

        System.out.println(resp.getBody());
    }

    // 결제 취소
    @GetMapping("/payment/cancle")
    @ResponseBody
    public void payment_cancle(){
        log.info("GET /portOne/payment/cancle");

        // 요청 정보 확인
        String url = "https://api.iamport.kr/payments/cancel";

        // 요청 헤더 설정(x)
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type","application/json");
        header.add("Authorization","Bearer "+portOneTokenResp.getResponse().getAccess_token());
        // 요청 바디 설정
        JSONObject params = new JSONObject();
        params.put("imp_uid","-");
        params.put("merchant_uid","-");

        HttpEntity<String> entity = new HttpEntity<>(params.toString(),header);

        // 요청 후 응답 확인
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> resp = rt.exchange(url, HttpMethod.POST,entity, String.class);
        System.out.println(resp.getBody());
    }

    // 인증 조회
    @GetMapping("/certifications/{imp_uid}")
    @ResponseBody
    public void certifications(@PathVariable("imp_uid") String imp_uid){
        log.info("GET /portOne/certifications");

        // 요청 정보 확인
        String url = "https://api.iamport.kr/certifications/"+imp_uid;

        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+portOneTokenResp.getResponse().getAccess_token());
        header.add("Content-Type","application/json");
        // 요청 바디 설정
//        MultiValueMap<String, String> params = new LinkedMultiValueMap();
//        params.add("imp_uid[]","[]");
//        params.add("merchant_uid[]","[]");

        HttpEntity entity = new HttpEntity<>(header);

        // 요청 후 응답 확인
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> resp = rt.exchange(url, HttpMethod.GET,entity, String.class);

        System.out.println(resp.getBody());
    }

    // -----------------------------------------------------------------------------------------
    // 토큰 응답
    @Data
    private static class Response{
        public String access_token;
        public int now;
        public int expired_at;
    }
    @Data
    private static class PortOneTokenResp{
        public int code;
        public Object message;
        public Response response;
    }
}
