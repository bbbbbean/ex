package com.example.demo.config;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MybatisConfigTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;    // sqlSessionFactory로 세션 만들어 확인

    @Test
    public void t1() throws Exception{
        assertNotNull(sqlSessionFactory);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        assertNotNull(sqlSession);
    }
}