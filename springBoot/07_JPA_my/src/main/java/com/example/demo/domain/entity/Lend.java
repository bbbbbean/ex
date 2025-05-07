package com.example.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="lend")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 외래키열 연결
    @ManyToOne
    @JoinColumn(name="bookcode", foreignKey = @ForeignKey(name="FK_LEND_BOOK",
            foreignKeyDefinition = "FOREIGN KEY(bookcode) references book(bookcode) on delete cascade on update cascade"))
            // 만든 bookcode를 외래키로 잡겠다. 어떤 bookcode? book 테이블에서 참조한 bookcode로 만든 bookcode행
    private Book book;  // book 테이블이랑 join

    @ManyToOne
    @JoinColumn(name="username", foreignKey = @ForeignKey(name="FK_LEND_USER",
            foreignKeyDefinition = "FOREIGN KEY(username) references user(username) on delete cascade on update cascade"))
    private User user;  // user 테이블이랑 join
}
