package com.example.demo.domain.repository;

import com.example.demo.domain.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("select u from User as u where u.role=?1")
    // ? 뒤 숫자 1 : 첫번째 파라미터???
    List<User> selectByRole(String role);

    @Query("select u from User as u where u.role=?1 and u.password=?2")
    List<User> selectByRoleAndPassword(String role, String password);

    @Query("select u from User as u where u.password =: password")
    List<User> selectByPassword(@Param("password") String pw);

    @Query("select u from User as u where u.username like concat('%',:username,'%')")
    List<User> selectAllLikeUsername(@Param("username") String username);
}
