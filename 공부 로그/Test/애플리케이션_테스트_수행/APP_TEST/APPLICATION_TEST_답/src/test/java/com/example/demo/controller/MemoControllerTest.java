package com.example.demo.controller;

import com.example.demo.domain.dto.MemoDto;
import com.example.demo.restcontroller.MemoRestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(value={MemoController.class})
class MemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("01MVC GET TEST")
    @Test
    public void t1() throws Exception {
        //given
        /*
        테스트를 준비하는 과정 / 변수 / 입력값 정의 
         */
        MemoDto memoDto = new MemoDto(1L,"text1");

        //when(생략)
        /*
         처리해야되는 Action을 준비 (Repository 나 Service Layer에서의 함수 작업)
         */

        //then
        /*
        테스트 검증 과정 , 예상한값 과 실제 실행을 통해서 나오는 값을 검증
         */
        this.mockMvc.perform(MockMvcRequestBuilders.get("/memo/get")
                        .param("memoDto", String.valueOf(memoDto)))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());

    }
    @DisplayName("02MVC POST TEST")
    @Test
    public void t2() throws Exception {
        //given
        MemoDto memoDto = new MemoDto(1L,"text1");

        //when(생략)

        //then
        this.mockMvc.perform(MockMvcRequestBuilders.post("/memo/post")
                        .param("memoDto", String.valueOf(memoDto)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @DisplayName("02MVC POST TEST")
    @Test
    public void t2_3() throws Exception {
        //given
        MemoDto memoDto = new MemoDto(1L,"text1");
        ObjectMapper objectMapper = new ObjectMapper();
        String params = objectMapper.writeValueAsString(memoDto);

        //when(생략)

        //then
        this.mockMvc.perform(MockMvcRequestBuilders.post("/memo/post_header")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(params))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }


    @DisplayName("03MVC PUT TEST")
    @Test
    public void t3(){
        //given

        //when

        //then
    }
    @DisplayName("04MVC DELETE TEST")
    @Test
    public void t4(){
        //given

        //when

        //then
    }
}