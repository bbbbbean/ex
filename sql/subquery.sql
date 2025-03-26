---------------------------------------------
-- 단일 행 서브 쿼리(Single Row Subquery)
-- 김경호보다 키가 큰 사용자 조회
SELECT userID, name, height 
FROM userTbl
WHERE height > (SELECT height FROM userTbl WHERE name = '김경호');

---------------------------------------------
-- 다중 행 서브쿼리
-- 서브 쿼리의 실행 결과가 여러 행 반환
-- 다중 행 비교 연산자 사용: IN, ANY, ALL, EXISTS

-- in : 정확한 값 반환
SELECT userID, name, addr, height
FROM userTbl
WHERE height IN (SELECT height FROM userTbl WHERE addr = '경남');

-- any : 어떤 것도 상관하지 않음, or 연산자 느낌
SELECT userID, name, addr, height
FROM userTbl
WHERE height >= any (SELECT height FROM userTbl WHERE addr = '경남');
-- 경남에 사는 사람들의 키보다 크면 만족

-- all : 전부 만족시켜야 함, and 연산자 느낌
SELECT userID, name, addr, height
FROM userTbl
WHERE height >= all (SELECT height FROM userTbl WHERE addr = '경남');

-- 주소별로 가장 키가 큰 사람들 조회
SELECT userID, name, addr, height
FROM userTbl
WHERE (addr, height) IN (SELECT addr, MAX(height) FROM userTbl GROUP BY addr);
SELECT addr, MAX(height) FROM userTbl GROUP BY addr;

---------------------------------------------
-- 스칼라 서브 쿼리 : return 값이 1개
-- 한개의 값만 나오는 경우

-- 각 사용자의 구매 총액 계산
-- 서브 쿼리 열 삽입 가능
SELECT u.userID, name, 
       (SELECT SUM(price*amount) FROM buyTbl b WHERE b.userID = u.userID) AS "총구매액"
FROM userTbl u
join buytbl b
on u.userID = b.userID
group by u.userid,name;
-- 값을 하나만 반환
SELECT SUM(price*amount)
FROM buyTbl b
join usertbl u
on u.userID = b.userID
WHERE b.userID = u.userID;

---------------------------------------------
-- 서브쿼리 문제 확인
select * from buytbl;
select * from usertbl;
-- 1. 서울 지역에 거주하는 회원 중, 전체 평균 키보다 큰 회원의 이름과 키를 조회하시오
select name, addr, height,(select avg(height) from usertbl b where a.addr=b.addr group by addr) as 평균키
from usertbl a
where height >= (select avg(height) from usertbl b where a.addr=b.addr group by addr)
group by name, addr, height
order by height desc, name;

select addr, avg(height)
from usertbl b
group by addr;

-- 2. 물품을 한 번이라도 구매한 적이 있는 회원의 이름과 주소를 조회하시오
--    (단, buyTbl의 userID 기준)
select distinct name, addr
from usertbl u
join buytbl b
on u.userid = b.userid
where prodname is not null;

-- 3. ‘전자’ 분류 상품 중 가장 비싼 상품을 구매한 회원의 이름과 상품명, 가격을 조회하시오.
select * from buytbl;
select name, prodname, price
from usertbl u
join buytbl b
on u.userid = b.userid
where price = (
    select max(price)
    from buytbl
    where groupname = '전자');
-- 가장 비싼 제품 찾기
select max(price)
from buytbl
where groupname = '전자';

-- 4. 각 회원이 구매한 총 금액(price × amount)의 평균보다 더 많이 구매한 회원의 이름과 총 구매 금액을 조회하시오.
-- group 함수 불가 절에는 그룹함수에 쓰여진 컬럼만 작성하면 됨
select name, sum(price*amount) as 총금액
from usertbl u
join buytbl b
on u.userid = b.userid
where price*amount >= (select avg(price*amount) from buytbl)
group by name;

select avg(price*amount)
from buytbl;

-- 5. 한 번도 물건을 구매한 적 없는 회원의 이름과 가입일을 조회하시오
select name, mdate
from usertbl u
left join buytbl b
on u.userid = b.userid
where amount is null;

-- 6. 청바지를 구매한 회원들과 같은 지역에 사는 다른 회원들의 이름과 지역을 조회하시오
--    (단, 청바지를 구매한 사람은 제외)
select distinct name, addr
from usertbl u
left join buytbl b
on u.userid = b.userid
where u.addr = (
    select u1.addr
    from usertbl u1
    join buytbl b1
    on u1.userid = b1.userid
    where prodname = '청바지' and u.addr=u1.addr
);
-- 청바지 구매자의 지역 조회
select addr
from usertbl u
join buytbl b
on u.userid = b.userid
where prodname = '청바지';

-- 7. 각 회원의 userID와 그 회원이 구매한 가장 비싼 물품의 이름과 가격을 조회하시오
select u.userid,(select prodname from buytbl where price = max(price)),max(price) as 최고가
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.userid;
-- 비싼 물건의 이름 반환
select prodname
from buytbl a
where price=(select max(price) from buytbl b group by prodname);

select max(price) from buytbl group by prodname;

-- 