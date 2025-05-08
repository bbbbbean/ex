package com.example.demo.domain.mapper;

import com.example.demo.domain.dto.MemoDto;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

// 테스트 지 : 별개 -> mapper scan 필요
@SpringBootTest
@MapperScan
class MemoMapperTest {

    @Autowired
    private MemoMapper memoMapper;

    @Test
    public void insert() throws Exception {
        MemoDto memoDto = new MemoDto(444,"aa","aa", LocalDateTime.now(),null);
        memoMapper.insert(memoDto);
        System.out.println(memoDto);
    }

    @Test
    public void insert1() throws Exception {
        MemoDto memoDto = new MemoDto(555,"aa","aa", LocalDateTime.now(),null);
        memoMapper.insert(memoDto);
        System.out.println(memoDto);
    }

    @Test
    public void delete() throws Exception {
        memoMapper.delete(444);
    }
}