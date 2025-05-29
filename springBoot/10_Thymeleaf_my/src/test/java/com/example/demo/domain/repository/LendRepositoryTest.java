package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import com.example.demo.domain.entity.Lend;
import com.example.demo.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class LendRepositoryTest {
    // join하기 전 기본 CRUD 체크
    @Autowired
    private LendRepository lendRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void t1() throws Exception{
        // 저장되어있는 도서 코드를 가지는 Book
        Book book = bookRepository.findById(1111L).get();
        // 저장되어있는 유저 정보를 가지는 User
        User user = userRepository.findById("user1").get();
        // 위 두가지가 같이 포함되어 있어야 작업 가능 -> user, book 연결
        Lend lend = new Lend();
        lend.setBook(book);
        lend.setUser(user);
        lendRepository.save(lend);
    }

    @Test
    public void t4() throws Exception{
        List<Lend> list = lendRepository.findLendsByUser("user1");
        list.stream().forEach(System.out::println);
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void t5() throws Exception{
        System.out.println("------------fetch 방식 테스트 시작------------");
        Optional<Lend> lendOptional = lendRepository.findById(3L);
        System.out.println("------------fetch by id (3L)------------");
        Lend lend = lendOptional.get();
        System.out.println("------------get user()------------");
        User user = lend.getUser(); // LAZY Option 사용시 해당 시점에서 쿼리 실행

        System.out.println("------------fetch 방식 테스트 종료------------");
    }
}