package com.example.demo.C04Kakao;

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
@RequestMapping("/kakao/pay")
public class C04KakaoPayController {

    private String SECRET_KEY = "-";

    @GetMapping("/req")
    @ResponseBody
    public void req(){
        log.info("GET /kakao/pay/req");
        // 요청 정보 확인
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";

        // 요청 헤더 설정
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization","SECRET_KEY "+SECRET_KEY);
        header.add("Content-Type","application/json");
        // 요청 바디 설정
        // MultiValueMap : 여러 값을 전달할 때 유리
        //MultiValueMap<String, String> params = new LinkedMultiValueMap();
        JSONObject params = new JSONObject();
        params.put("cid","TC0ONETIME"); // 테스트용 코드
        params.put("partner_order_id","partner_order_id");
        params.put("partner_user_id","partner_user_id");
        params.put("item_name","초코파이");
        params.put("quantity","1");
        params.put("total_amount","2200");
        params.put("vat_amount","200");
        params.put("tax_free_amount","0");
        params.put("approval_url","http://localhost:8090/kakao/pay/success");  // 결제 성공 시 돌아올 URL
        params.put("fail_url","http://localhost:8090/kakao/pay/fail");  // 결제 실패 시 돌아올 URL
        params.put("cancel_url","http://localhost:8090/kakao/pay/cancel");    // 결제 취소 시 돌아올 URL

        HttpEntity<JSONObject> entity = new HttpEntity<>(params,header);

        // 요청 후 응답 확인
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> resp = rt.exchange(url, HttpMethod.POST, entity, String.class);

        System.out.println(resp);
    }

    @GetMapping("/success")
    public void success(){
        log.info("GET /kakao/pay/success");
    }

    @GetMapping("/fail")
    public void fail(){
        log.info("GET /kakao/pay/fail");
    }

    @GetMapping("/cancel")
    public void cancel(){
        log.info("GET /kakao/pay/cancel");
    }

}
