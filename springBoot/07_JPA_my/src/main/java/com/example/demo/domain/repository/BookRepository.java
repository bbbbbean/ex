package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// <Book,Long> = <Entity, PK의 자료형>**
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByBookName(String bookName);
    List<Book> findByPublisher(String publisher);
    List<Book> findByIsbn(String isbn);

    // 두개 이상의 행을 조건절로 잡을 수 있음
    Book findByBookNameAndIsbn(String bookName, String isbn);

    // 포함 문자열 검색 : Contains
    List<Book> findByBookNameContains(String keyword);

    // count
    int countByBookName(String bookName);
    int countByBookNameContains(String BookName);

    // 삭제
    @Transactional
    void deleteByBookName(String BookName);
}
