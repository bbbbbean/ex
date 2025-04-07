select * from tbl_user;

-- tbl_order 테이블
CREATE TABLE tbl_order (
  product_id  VARCHAR2(100) PRIMARY KEY,   -- 상품 ID
  userid    VARCHAR2(100) NOT NULL,     -- 사용자 ID (FK)
  product_name VARCHAR2(200) NOT NULL,     -- 상품명
  category   VARCHAR2(100) NOT NULL,     -- 품목
  price     NUMBER(10, 2) NOT NULL,     -- 상품 가격
  quantity   NUMBER(5) NOT NULL,       -- 주문 수량
  order_date  DATE DEFAULT SYSDATE,      -- 주문 날짜
  CONSTRAINT fk_order_user FOREIGN KEY (userid) -- 제약 조건
    REFERENCES tbl_user(userid) -- 기본 키열이 있는 테이블
    ON DELETE CASCADE -- 기본 키열이 삭제되면 외래키열 모두 삭제
);
desc tbl_order;


-- aaa의 주문
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P021', 'aaa', '메모리폼 방석', '생활용품', 15000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P022', 'aaa', '블루라이트 차단 안경', '액세서리', 22000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));


-- bbb의 주문
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P023', 'bbb', '스마트 워치 충전기', '전자기기', 17000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P024', 'bbb', 'USB 선풍기', '생활용품', 13000, 2, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P025', 'bbb', '게이밍 헤드셋', '전자기기', 59000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));


-- ccc의 주문
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P026', 'ccc', '노이즈캔슬링 헤드폰', '전자기기', 198000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P027', 'ccc', 'C타입 허브', '전자기기', 35000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P028', 'ccc', '마우스 손목 보호대', '액세서리', 9000, 2, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P029', 'ccc', '스마트 체중계', '전자기기', 42000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P030', 'ccc', '전동 드라이버 세트', '생활용품', 68000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));


-- aaa의 주문
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P031', 'aaa', '무선 충전 패드', '전자기기', 28000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P032', 'aaa', '데스크 클립 선풍기', '생활용품', 17000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));


-- bbb의 주문
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P033', 'bbb', '노트북 거치대', '사무용품', 39000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P034', 'bbb', '다기능 볼펜 세트', '사무용품', 11000, 2, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P035', 'bbb', 'USB LED 조명', '전자기기', 8000, 3, TO_DATE('2025-04-08', 'YYYY-MM-DD'));


-- ccc의 주문
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P036', 'ccc', '게이밍 체어', '가구', 210000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P037', 'ccc', 'PC 스피커', '전자기기', 47000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P038', 'ccc', '화이트보드', '사무용품', 32000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P039', 'ccc', '문서 파쇄기', '사무용품', 99000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P040', 'ccc', '프린터 토너', '사무용품', 58000, 2, TO_DATE('2025-04-08', 'YYYY-MM-DD'));


-- aaa의 주문
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P041', 'aaa', '스마트 램프', '전자기기', 37000, 1, TO_DATE('2025-04-01', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P042', 'aaa', '멀티탭 정리함', '생활용품', 22000, 1, TO_DATE('2025-04-03', 'YYYY-MM-DD'));


-- bbb의 주문
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P043', 'bbb', '게이밍 마우스', '전자기기', 52000, 1, TO_DATE('2025-04-02', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P044', 'bbb', '접이식 키보드', '전자기기', 46000, 1, TO_DATE('2025-04-04', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P045', 'bbb', '노트북 클리너 세트', '생활용품', 9500, 2, TO_DATE('2025-04-05', 'YYYY-MM-DD'));


-- ccc의 주문
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P046', 'ccc', '고속 충전기', '전자기기', 19000, 1, TO_DATE('2025-04-06', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P047', 'ccc', '미니 빔프로젝터', '전자기기', 129000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P048', 'ccc', '모니터 받침대', '사무용품', 27000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P049', 'ccc', '슬림 전자사전', '전자기기', 87000, 1, TO_DATE('2025-04-09', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P050', 'ccc', '모니터 청소 키트', '생활용품', 12000, 2, TO_DATE('2025-04-10', 'YYYY-MM-DD'));

commit;

alter table tbl_user add addr varchar2(100);
select * from tbl_user;
update tbl_user set addr='대구' where userid='aaa';
update tbl_user set addr='대구' where userid='ccc';
update tbl_user set addr='인천' where userid='bbb';
update tbl_user set addr='울산' where userid='ddd';
update tbl_user set addr='제주' where userid='eee';

select * from tbl_order;

select category, sum(price*quantity)
from tbl_order
group by category
having sum(price*quantity)>=50000
order by sum(price*quantity) desc;

select order_date,round(avg(price*quantity),2)  -- 결과값 2자리수 까지만 표기
from tbl_order
group by order_date;

select *
from tbl_user
join tbl_order
on tbl_user.userid=tbl_order.userid;

-- 구매하지 않은 고객
select tbl_user.userid, addr, quantity
from tbl_user
left outer join tbl_order
on tbl_user.userid=tbl_order.userid
where tbl_order.userid is null;

-- 구매한 고객 > 지역별 구매 총액
select addr, order_date, sum(price*quantity)
from tbl_user
join tbl_order
on tbl_user.userid=tbl_order.userid
group by addr, order_date
order by addr, sum(price*quantity) desc;
