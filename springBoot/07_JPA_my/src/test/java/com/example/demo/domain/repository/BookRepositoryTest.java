package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    // 기본 CRUD TEST
    @Test
    public void t1() throws Exception{
        // insert
        Book book = Book.builder()
                .bookCode(1111L)
                .bookName("책제목")
                .publisher("출판사")
                .isbn("1234-1234")
                .build();
        //bookRepository.save(book);

        // update
        // 위에 만든 정보를 기준으로 업데이트
        book.setBookName("Java의 정석");
        book.setPublisher("한빛");
        book.setIsbn("4321-4321");
        bookRepository.save(book);
    }

    @Test
    public void t2() throws Exception{
        // delete
        // ById = PK
        bookRepository.deleteById(1111L);
    }

    @Test
    public void t3() throws Exception{
        // 옵셔널 : 해당 데이터가 없을 수도 있음, null체크 관련 옵션이 들어가 있음
        // 반환 형태가 맞지 않아 오류
//        Optional<Book> bookOptional = bookRepository.findById(1111L);
//        if(bookOptional.isPresent())
//            System.out.println(bookOptional.get());

        // bookname, publisher 등을 기준으로 열을 찾고 싶음
        List<Book> list = bookRepository.findByBookName("책1");
        List<Book> list2 = bookRepository.findByPublisher("출판사3");
        List<Book> list3 = bookRepository.findByIsbn("1234-4444");
        list.stream().forEach(System.out::println);
        list2.stream().forEach(System.out::println);
        list3.stream().forEach(System.out::println);

        // 2개 이상의 행 참고 찾기
        Book book = bookRepository.findByBookNameAndIsbn("책2","1234-2222");
        System.out.println("결과 : "+book);

        // 포함 문자 찾기
        List<Book> list4 = bookRepository.findByBookNameContains("책");
        list4.stream().forEach(System.out::println);

        // count
        int result = bookRepository.countByBookName("책1");
        int result2 = bookRepository.countByBookNameContains("1");
        System.out.println("결과들 : "+result+", "+result2 );
    }

    @Test
    public void t4() throws Exception{
        // delete
        bookRepository.deleteByBookName("책3");
    }
}