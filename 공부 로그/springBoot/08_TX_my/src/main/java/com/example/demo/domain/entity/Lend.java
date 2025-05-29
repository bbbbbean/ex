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
    // update 방식 : eager - 기본값 / lazy
    // Lazy를 기본으로 잡기 : 데이터 여러개를 처음부터 다 부름-> 서버 부담, 필요할 때만 질의
    // 커밋을 미뤄야하니 Tx 옵션 꼭 넣어주기
    @ManyToOne(fetch = FetchType.EAGER)     // 실행 시 관련된 모든 데이터를 가져오는 방식
    //@ManyToOne(fetch = FetchType.LAZY)  // 필요할때만 데이터를 가져오는 방식
    @JoinColumn(name="bookcode", foreignKey = @ForeignKey(name="FK_LEND_BOOK",
            foreignKeyDefinition = "FOREIGN KEY(bookcode) references book(bookcode) on delete cascade on update cascade"))
            // 만든 bookcode를 외래키로 잡겠다. 어떤 bookcode? book 테이블에서 참조한 bookcode로 만든 bookcode행
    private Book book;  // book 테이블이랑 join

    //@ManyToOne(fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="username", foreignKey = @ForeignKey(name="FK_LEND_USER",
            foreignKeyDefinition = "FOREIGN KEY(username) references user(username) on delete cascade on update cascade"))
    private User user;  // user 테이블이랑 join
}
