package com.example.demo.controller;


import com.example.demo.domain.dto.BoardDto;
import com.example.demo.restcontroller.BoardRestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value={BoardController.class, BoardRestController.class})
public class BoardControllerTests {

    @Autowired
    MockMvc mvc;


    @DisplayName("GET /board/get 테스트")
    @Test
    public void t1() throws Exception{
        //given

        //when

        //then
    }


    @DisplayName("PUT /board/put 테스트")
    @Test
    public void t3() throws Exception{
        //given
        BoardDto dto = new BoardDto();
        dto.setNo(10L);
        dto.setTitle("title_user1");
        dto.setContents("contents_user1");
        dto.setWriter("user1@naver.com");

        ObjectMapper objectMapper = new ObjectMapper();
        String params = objectMapper.writeValueAsString(dto);

        //when


        //then
        mvc.perform(
                put("/board/put")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(params)
        )
                .andExpect(status().isOk())
                .andDo(print());

    }




}
