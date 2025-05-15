package com.example.demo.C01OpenData;

import com.example.demo.C01OpenData.bus.BUSResult;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/openData")
public class OpenData03Controller {
    @GetMapping("/bus/realtime")
    public void bus_realtime() throws Exception{
        String url = "https://apis.data.go.kr/6270000/dbmsapi01/getRealtime";
        String serviceKey= "-";
        // 하단 : 지금은 수동으로 넣어줘야함 -> 자동으로 만들기 위해서는 사전 작업이 많대..
        String bsId="7001003800";
        String routeNo="304";

//        url+="?serviceKey="+URLEncoder.encode(serviceKey);
//        url+="&bsId="+bsId;
//        url+="&routeNo="+routeNo;

        URI uri = UriComponentsBuilder
                .fromHttpUrl(url)
                .queryParam("serviceKey", URLEncoder.encode(serviceKey, "UTF-8")) // 인코딩 꼭 필요
                .queryParam("bsId", bsId)
                .queryParam("routeNo", routeNo)
                .build(true) // 자동 인코딩 방지 → true 설정 중요
                .toUri();
        System.out.println(uri);

        // 요청 헤더(x)
        // 요청 바디(x)
        // 요청 후 응답 값 받기
        RestTemplate rt = new RestTemplate();
        ResponseEntity<BUSResult> response = rt.exchange(uri, HttpMethod.GET,null,BUSResult.class);
        System.out.println(response.getBody());

        // 가공 처리



    }
    // 버스 데이터 xml -> java파일은 bus 폴더에 빼둠

}
