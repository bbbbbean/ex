package com.example.demo.C04Kakao;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
@Slf4j
@RequestMapping("/kakao")
public class C02KakaoLoginController {

    // 카카오 로그인 step1 인가 코드받기
    // 인가 코드받기의 요청 쿼리 파라미터 필수 3개
    //String REDITECT_URI="http://localhost:8090/kakao/callback";
    String REDITECT_URI="http://192.168.16.17:8090/kakao/callback";
    String CLIENT_ID="cb3c7d1743d2dbab986fed97bc53bccd";
    String LOGOUT_REDITECT_URI="http://localhost:8090/kakao/login";

    KakaoTokenResp kakaoTokenResp;
    KakaoProfileResp kakaoProfileResp;
    KakaoLogoutResp kakaoLogoutResp;
    KakaoUnlinkResp kakaoUnlinkResp;
    KakaoFriendsResp kakaoFriendsResp;

    @GetMapping("/login")
    public String login(){
        log.info("GET /kakao/login");
        // 인가 코드 받기 기본 정보의 URL
        return "redirect:https://kauth.kakao.com/oauth/authorize?client_id="+CLIENT_ID+"&redirect_uri="+REDITECT_URI+"&response_type=code";
    }

    // 카카오 로그인 step2 토큰
    @GetMapping("/callback")
    public String callback(@RequestParam("code") String code){   // 서버가 준 코드, 응답으로 받은 코드
        log.info("GET /kakao/callback"+code);
        // 요청 정보 확인
        String url = "https://kauth.kakao.com/oauth/token";

        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        // 요청 바디 설정
        // MultiValueMap : 여러 값을 전달할 때 유리
        MultiValueMap<String, String> params = new LinkedMultiValueMap();
        params.add("grant_type","authorization_code");
        params.add("client_id",CLIENT_ID);
        params.add("redirect_uri",REDITECT_URI);
        params.add("code",code);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params,header);

        // 요청 후 응답 확인
        RestTemplate rt = new RestTemplate();
        ResponseEntity<KakaoTokenResp> resp = rt.exchange(url, HttpMethod.POST,entity,KakaoTokenResp.class);

        //System.out.println(resp.getBody()); // 나온 결과 json -> java 클래스화
        System.out.println(resp); // 상단으로 나온 결과를 다시 resp으로 저장함 -> getbody 필요없어짐. 이미 그 내용이니까

        // 가공 처리
        // 다른 곳들에서 KakaoTokenResp 사용해야 하니까 위에서 한번 전역으로 빼주기
        this.kakaoTokenResp = resp.getBody();

        return "redirect:/kakao/main";
    }

    // 카카오 사용자 정보 가져오기 - main에서 하자
    @GetMapping("/main")
    public void main(Model model){
        log.info("GET /kakao/main");
        // 정보 확인
        String url="https://kapi.kakao.com/v2/user/me";

        // 요청 헤더
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","Bearer "+kakaoTokenResp.getAccess_token());
        header.add("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        // 요청 바디(x)

        // Entity
        HttpEntity entity = new HttpEntity<>(header);

        // 응답
        RestTemplate rt = new RestTemplate();
        ResponseEntity<KakaoProfileResp> resp = rt.exchange(url,HttpMethod.POST,entity,KakaoProfileResp.class);
        System.out.println(resp);

        this.kakaoProfileResp = resp.getBody();
        // 모델로 내용 뷰로 던져주기
        model.addAttribute("profile",kakaoProfileResp);
    }

    // 로그아웃
    @GetMapping("/logout")
    @ResponseBody   // 위치 이동 예정 없음
    public void logout(){
        log.info("GET /kakao/logout");
        // 정보 확인
        String url = "https://kapi.kakao.com/v1/user/logout";
        // 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+kakaoTokenResp.getAccess_token());
        // 요청 바디(x)
        // entity - 헤더, 바디 담기
        HttpEntity entity = new HttpEntity<>(headers);

        // 응답
        RestTemplate rt = new RestTemplate();
        ResponseEntity<KakaoLogoutResp> resp = rt.exchange(url,HttpMethod.POST,entity,KakaoLogoutResp.class);
        System.out.println(resp);

        this.kakaoLogoutResp = resp.getBody();
    }

    @GetMapping("/unlink")
    @ResponseBody
    public void unlink(){
        log.info("GET /kakao/unlink");
        // 정보 확인
        String url = "https://kapi.kakao.com/v1/user/unlink";
        // 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+kakaoTokenResp.getAccess_token());
        // 요청 바디(x)
        // entity
        HttpEntity entity = new HttpEntity<>(headers);

        // 응답
        RestTemplate rt = new RestTemplate();
        ResponseEntity<KakaoUnlinkResp> resp = rt.exchange(url,HttpMethod.POST,entity,KakaoUnlinkResp.class);
        System.out.println(resp);

        this.kakaoUnlinkResp = resp.getBody();
    }

    @GetMapping("/logoutAll")
    public String allLogout(){
        log.info("GET /kakao/logoutAll");
        return "redirect:https://kauth.kakao.com/oauth/logout?client_id="+CLIENT_ID+"&logout_redirect_uri="+LOGOUT_REDITECT_URI;
    }


    // 메세지 보내기
    // 나에게 보내기
    // 이용 중 동의
    @GetMapping("/getCodeMsg")
    public String getCode_message(){
        log.info("GET /kakao/getCodeMsg");
        return "redirect:https://kauth.kakao.com/oauth/authorize?client_id="+CLIENT_ID+"&redirect_uri="+REDITECT_URI+"&response_type=code&scope=talk_message";
    }

    @GetMapping("/message/me/{message}")
    public void message_me(@PathVariable("message") String message){
        // 정보
        String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";

        // 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+kakaoTokenResp.getAccess_token());
        headers.add("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        // 요청 바디
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        JSONObject template_object = new JSONObject(); //{}
        template_object.put("object_type","text");
        template_object.put("text",message);
        template_object.put("link",new JSONObject());
        template_object.put("button_title","");
        param.add("template_object",template_object.toString());
        // entity
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(param,headers);

        // 응답
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> resp = rt.exchange(url,HttpMethod.POST,entity,String.class);
        System.out.println(resp.getBody());
    }

    // 친구에게 메세지 보내기
    // 이용 중 동의
    @GetMapping("/getCodeFriends")
    public String getCodeFriends(){
        log.info("GET /kakao/getCodeFriends");
        return "redirect:https://kauth.kakao.com/oauth/authorize?client_id="+CLIENT_ID+"&redirect_uri="+REDITECT_URI+"&response_type=code&scope=friends,talk_message";
    }

    @GetMapping("/friends")
    @ResponseBody
    public void getFriends(){
        log.info("GET /kakao/friends");
        // 정보
        String url = "https://kapi.kakao.com/v1/api/talk/friends";

        // 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+kakaoTokenResp.getAccess_token());
        // 요청 바디(x)
        // entity
        HttpEntity entity = new HttpEntity<>(headers);

        // 응답
        RestTemplate rt = new RestTemplate();
        ResponseEntity<KakaoFriendsResp> resp = rt.exchange(url,HttpMethod.GET,entity,KakaoFriendsResp.class);
        System.out.println(resp.getBody());
        this.kakaoFriendsResp = resp.getBody();
    }

    @GetMapping("/message/friends/{message}")
    @ResponseBody
    public void friendsMessage(@PathVariable("message")String message){
        log.info("GET /kakao/message/friends"+message);
        // 정보
        String url = "https://kapi.kakao.com/v1/api/talk/friends/message/default/send";

        // 요청 헤더
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization","Bearer "+kakaoTokenResp.getAccess_token());
        headers.add("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        // 요청 바디
        MultiValueMap<String,String> param = new LinkedMultiValueMap<>();
        //Receiver
        JSONArray uuids = new JSONArray();
        List<Element> list = kakaoFriendsResp.getElements();
        for(int i=0; i<list.size(); i++){
            uuids.add(list.get(i).getUuid());
        }
        //Template
        JSONObject template_object = new JSONObject(); // {}
        template_object.put("object_type","text");
        template_object.put("text",message);
        template_object.put("link",new JSONObject());
        template_object.put("button_title","");
        // 꺼낸 요소들 담기
        param.add("template_object",template_object.toString());
        param.add("receiver_uuids",uuids.toString());
        // entity
        HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(param,headers);

        // 응답
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> resp = rt.exchange(url,HttpMethod.POST,entity,String.class);
        System.out.println(resp.getBody());
    }

    //====================================================================================================================

    // Token 응답
    @Data
    private static class KakaoTokenResp{
        public String access_token;
        public String token_type;
        public String refresh_token;
        public int expires_in;
        public String scope;
        public int refresh_token_expires_in;
    }

    // 사용자 정보 가져오기 파트 응답
    @Data
    private static class KakaoAccount{
        public boolean profile_nickname_needs_agreement;
        public boolean profile_image_needs_agreement;
        public Profile profile;
        public boolean has_email;
        public boolean email_needs_agreement;
        public boolean is_email_valid;
        public boolean is_email_verified;
        public String email;
    }

    @Data
    private static class Profile{
        public String nickname;
        public String thumbnail_image_url;
        public String profile_image_url;
        public boolean is_default_image;
        public boolean is_default_nickname;
    }

    @Data
    private static class Properties{
        public String nickname;
        public String profile_image;
        public String thumbnail_image;
    }

    @Data
    private static class KakaoProfileResp{
        public long id;
        public Date connected_at;
        public Properties properties;
        public KakaoAccount kakao_account;
    }

    // 로그아웃 응답
    @Data
    private static class KakaoLogoutResp{
        public long id;
    }

    // 연결끊기 응답
    @Data
    private static class KakaoUnlinkResp{
        public long id;
    }

    // 친구 가져오기 응답
    @Data
    private static class Element{
        public String profile_nickname;
        public String profile_thumbnail_image;
        public boolean allowed_msg;
        public long id;
        public String uuid;
        public boolean favorite;
    }

    @Data
    private static class KakaoFriendsResp{
        public ArrayList<Element> elements;
        public int total_count;
        public Object after_url;
        public int favorite_count;
    }


}
