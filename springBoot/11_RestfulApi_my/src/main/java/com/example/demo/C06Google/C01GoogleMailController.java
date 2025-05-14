package com.example.demo.C06Google;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping("/google/mail")
public class C01GoogleMailController {

    @Autowired
    JavaMailSender javaMailSender;

    @GetMapping("/req")
    @ResponseBody
    public void req(
            @RequestParam("email") String email, // 수신자
            @RequestParam("text") String text  // 발신 내용
            // 발신자는 properties에서 설정한 계정
            ){
        log.info("GET /google/mail/req : "+javaMailSender);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);   // 수신자
        message.setSubject("제목입니다.");   // 제목
        message.setText(text);  // 내용
        // 송신 함수인 send를 이용해 메일 발송
        javaMailSender.send(message);
    }

}
