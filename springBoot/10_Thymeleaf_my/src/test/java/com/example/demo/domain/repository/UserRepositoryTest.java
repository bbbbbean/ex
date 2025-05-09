package com.example.demo.domain.repository;

import com.example.demo.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void t1() throws Exception{
        // insert
        User user = User.builder()
                .username("이름")
                .password("1234")
                .role("ROLE_USER")
                .build();
        //userRepository.save(user);

        // update
        user.setPassword("4321");
        user.setRole("ROLE_ADMIN");
        userRepository.save(user);
    }

    @Test
    public void t2() throws Exception{
        // delete
        userRepository.deleteById("이름");
    }

    @Test
    public void t3() throws Exception{
        List<User> list = userRepository.selectByRole("ROLE_USER");
        list.stream().forEach(System.out::println);

        List<User> list2 = userRepository.selectByRoleAndPassword("ROLE_MANAGER","6543");
        list2.stream().forEach(System.out::println);

        List<User> list3 = userRepository.selectByPassword("1234");
        list3.stream().forEach(System.out::println);

        List<User> list4 = userRepository.selectAllLikeUsername("user1");
        list4.stream().forEach(System.out::println);
    }
}