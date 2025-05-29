package com.example.demo.C05Naver;

import com.example.demo.C04Kakao.C02KakaoLoginController;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
@RequestMapping("/naver")
public class C01NaverLoginController {

    // 이런 토큰값은 resource의 application.properties에 넣고 연결
    // properties도 나눠 관리 가능
    // gitignore < 깃 업로드 제외 파일
    private String NAVER_CLIENT_ID="-";
    private String NAVER_CLIENT_SECRET="-";
    private String REDIRECT_URL="http://localhost:8090/naver/callback";

    private NaverTokenResp naverTokenResp;
    private NaverProfileResp naverProfileResp;

    @GetMapping("/login")
    public String login(){
        log.info("GET /naver/login");

        return "redirect:https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id="+NAVER_CLIENT_ID+"&state=STATE_STRING&redirect_uri="+REDIRECT_URL;
    }

    // 네이버 로그인 토큰 발급
    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code,
                         @RequestParam("state") String state){
        log.info("GET /naver/callback : "+code+", "+state);

        // 요청 정보 확인
        String url = "https://nid.naver.com/oauth2.0/token";

        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        // 요청 바디 설정
        // MultiValueMap : 여러 값을 전달할 때 유리
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        params.add("grant_type","authorization_code");
        params.add("client_id",NAVER_CLIENT_ID);
        params.add("client_secret",NAVER_CLIENT_SECRET);
        params.add("code",code);
        params.add("state",state);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params,header);

        // 요청 후 응답 확인
        RestTemplate rt = new RestTemplate();
        ResponseEntity<NaverTokenResp> resp = rt.exchange(url, HttpMethod.POST,entity, NaverTokenResp.class);

        System.out.println(resp);
        this.naverTokenResp = resp.getBody();

        return "redirect:/naver/main";
    }

    // 접근 토큰을 이용하여 프로필 API 호출
    @GetMapping("/main")
    public void main(Model model){
        log.info("GET /naver/main");

        // 정보 확인
        String url="https://openapi.naver.com/v1/nid/me";

        // 요청 헤더
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+this.naverTokenResp.getAccess_token());
        // 요청 바디(x)

        // Entity
        HttpEntity entity = new HttpEntity<>(header);

        // 응답
        RestTemplate rt = new RestTemplate();
        ResponseEntity<NaverProfileResp> resp = rt.exchange(url,HttpMethod.POST,entity, NaverProfileResp.class);
        System.out.println(resp);

        this.naverProfileResp = resp.getBody();
        // 상기 내용 모델에 담아 던지기
        model.addAttribute("profile",naverProfileResp);
    }

    // 로그아웃 : 카카오의 unlink랑 같음, 네이버는 완전 로그아웃 제공x
    @GetMapping("/unlink")
    public void unlink(){
        log.info("GET /naver/unlink");

        // 요청 정보 확인
        String url = "https://nid.naver.com/oauth2.0/token";

        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        // 요청 바디 설정
        // MultiValueMap : 여러 값을 전달할 때 유리
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        params.add("grant_type","delete");
        params.add("client_id",NAVER_CLIENT_ID);
        params.add("client_secret",NAVER_CLIENT_SECRET);
        params.add("access_token",this.naverTokenResp.getAccess_token());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params,header);

        // 요청 후 응답 확인
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> resp = rt.exchange(url, HttpMethod.POST,entity, String.class);

        System.out.println(resp.getBody());
    }

    // 로그아웃 : 실제 로그아웃 시 뜨는 링크 따와서 해보는거
    @GetMapping("/logout")
    public String disConnect(){
        return "redirect:https://nid.naver.com/nidlogin.logout?returl=https://www.naver.com/";
    }

    // ----------------------------------------------------------------------------------------------------------------
    // 네이버 토큰 resp
    @Data
    private static class NaverTokenResp{
        public String access_token;
        public String refresh_token;
        public String token_type;
        public String expires_in;
    }

    // 네이버 프로필 가져오기 resp
    @Data
    private static class Response{
        public String id;
        public String profile_image;
        public String email;
        public String name;
    }
    @Data
    private static class NaverProfileResp{
        public String resultcode;
        public String message;
        public Response response;
    }
}
