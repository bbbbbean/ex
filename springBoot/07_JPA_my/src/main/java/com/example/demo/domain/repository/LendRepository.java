package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Lend;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LendRepository extends JpaRepository<Lend,Long> {
    @Query("select l from Lend as l join fetch l.user where l.user.username = :username")
    List<Lend> findLendsByUser(@Param("username") String username);

    @Query("select l from Lend as l join fetch l.user join fetch l.book")
    List<Lend> findLendsByUserAndBook();
}
