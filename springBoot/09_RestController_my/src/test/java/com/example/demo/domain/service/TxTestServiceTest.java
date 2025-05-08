package com.example.demo.domain.service;

import com.example.demo.domain.dto.MemoDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TxTestServiceTest {
    @Autowired
    private TxTestService txTestService;

    // 에러 상황에서 TX 롤백 처리 확인 중
    @Test
    void t2() throws Exception {
        txTestService.addMemoTx(new MemoDto(1,"TEST1"));
    }

    //JPA TX
    @Test
    void t3() throws Exception {
        txTestService.addMemoTx2(new MemoDto(1,"TEST1"));
    }
}