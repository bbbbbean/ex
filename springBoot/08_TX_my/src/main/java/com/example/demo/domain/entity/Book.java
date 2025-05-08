package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // 쉽게 말하면 테이블 생성
@Table(name="book") // 지정하지 않으면 테이블 명은 클래스 이름과 동일하게 생성됨
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    // column 지정할 항목
    @Id // PK 지정
   //@GeneratedValue(strategy = GenerationType.IDENTITY) // 유일하게 처리되는 값을 넣어줌 AI 설정
    @Column(name="bookcode")   // name, size, 제약 조건 등 여러 설정 가능
    private Long bookCode;  // 이름 지정 X시 : 카멜 표기법 -> 스네이크 방식 : _소문자로 변환 (book_code) -> 해당 방식 이름 설정시 까딱하면 쿼리 질의가 안됨 편한 이름으로 다시 잘 지정해주기
    @Column(name="bookname")
    private String bookName;
    private String publisher;
    private String isbn;
}
