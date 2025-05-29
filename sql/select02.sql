---------------------------------------------
-- 정렬 (기본 오름차순)
-- order by
-- order by 정렬열 desc

-- 날짜를 기준으로 정렬
select name, mdate from usertbl order by mdate; -- 오름차순
select name, mdate from usertbl order by name;
select name, mdate from usertbl order by mdate desc; -- 내림차순
select name, height from usertbl order by height desc, name desc; -- 키 내림차순 정렬 후 이름 오름차순 정렬(같은 키 안에서의 정렬)

-- 서브 쿼리 - 쿼리 안에 들어가는 쿼리 ()안에 가둬 사용
-- 그냥 run했을때 나오는 제일 앞의 번호는 프로그램이 임의로 보여주는 인덱스 (mysql에서는 지원 안함)
-- -> 실제 행이 아니라 이용 불가
-- rownum을 이용하면 행 번호가 출력됨 : 이걸 실제 행으로 만들어 이용 가능
-- 쿼리 안에 쿼리를 넣어 이용하는 형태로 사용 (예시 확인)
select rownum as RN, usertbl.* from usertbl;
-- 예시 ) 
select * from
(select rownum as RN, usertbl.* from usertbl) where RN=2;

-- 출생년도 기준 사용자 수
select birthyear, count(*) as 인원수
from usertbl
group by birthyear
order by birthyear; -- 오름차순 정렬
---------------------------------------------
-- GROUP BY 절
-- 특정 그룹별 수치값 확인
-- SELECT 절에는 GROUP BY에 명시된 컬럼과 집계 함수만 사용가능

-- 기본 구문
-- SELECT 컬럼1, 컬럼2, ... 집계함수(컬럼)
-- FROM 테이블
-- [WHERE 조건식]
-- GROUP BY 컬럼1, 컬럼2, ...
-- [ORDER BY 컬럼 [ASC|DESC]];
-- [] : 생략가능 표시

select * from buytbl;

-- 각 userid의 가격 * 수량
select userid,price, amount from buytbl;
-- group by 를 쓰면 집계 처리를 해줘야함
select userid, sum(price*amount) as 구매총액 -- 구별되는 값을 여러개 넣으면 오류
from buytbl
group by userid; -- 사용자 별로 묶음

--
select userid, count(*) as 구매횟수 -- count 횟수 
from buytbl
group by userid;

-- 지역별 사용자 수 계산
select * from usertbl;
select addr, count(*) as 사용자수
from usertbl
group by addr;

-- 제품 그룹별 판매 금액 합계
select * from buytbl;
select groupname, sum(price*amount) as 판매액
from buytbl
where groupname is not null
group by groupname; -- where절 뒤에 적기

---------------------------------------------
-- 문제 확인
select * from usertbl;
select * from buytbl;

-- 1. userTbl에서 지역(addr)별 사용자 수를 구하시오
select addr, count (*) as 사용자수
from usertbl
group by addr;

-- 2. buyTbl에서 userID별 총 구매액을 구하시오. 총 구매액은 price*amount의 합
select userid, sum(price*amount) as 총구매액
from buytbl
group by userid;

-- 3. buyTbl에서 groupName별 판매 수량의 합계를 구하시오. NULL 값은 '미분류'로 표시하시오
-- coalesce?? null값 체크 함수, null값 체크 후 null 부분에 지정 값 적용 가능
--select coalesce(groupname,'미분류') as 제품그룹, sum(amount) as 전체판매수량
-- nvl?? nullvalue
--select nvl(groupname,'미분류') as 제품그룹, sum(amount) as 전체판매수량
-- case ~ is null then??
select
    -- case 처리 (end로 종료)
    case when groupname is null then '미분류'
    else groupname
    end
    as 제품그룹, sum(amount) as 전체판매수량
from buytbl
group by groupname;

-- 4. userTbl에서 birthYear별 평균 height를 구하시오
select birthyear, avg(height) as 평균키
from usertbl
group by birthyear;

-- 5. buyTbl에서 prodName별 구매 횟수와 총 구매액을 구하하시오. 구매 횟수가 많은 순으로 정렬
select prodname,count(amount) as "구매 횟수",sum(price*amount) as "총 구매액"
from buytbl
GROUP by prodname
order by "구매 횟수" desc;

-- 6. userTbl에서 mobile1 별 가입자 수를 구하되, NULL 값은 '미입력'으로 표시하시오
select nvl(mobile1,'미입력') as 통신사, count(*) as 가입자수
from usertbl
group by mobile1;

-- 7. userTbl과 buyTbl을 조인하여 지역(addr)별 총 구매액을 구하시오.
select u.addr, sum(b.price*b.amount) as "총 구매액"
from usertbl u
join buytbl b
on u.usertbl = b.buytbl
group by u.addr;

-- 8. buyTbl에서 사용자별 구매한 제품의 종류 수를 구하시오
-- select userid,count(prodname) as 구매한제품종류수 -- 단순 카운트, 제품 종류 수 카운트 하려면 중복값 제거 후 카운트 -> distinct
select userid,count(distinct prodname) as "구매한 제품 종류수"
-- select userid, groupname,count(groupname) from buytbl group by userid, groupname;
from buytbl
group by userid;

-- 9. userTbl에서 가입 연도별(mDate의 연도 부분) 가입자 수를 구하하시오
-- 형변환 파트 보기
select substr(mdate,1,2),count(*)
from usertbl
group by substr(mdate,1,2);

-- 10. buyTbl과 userTbl을 조인하여 연령대별(10대, 20대, ...) 구매 총액을 계산하시오. 연령은 2023년 기준으로 계산하시오.
SELECT FLOOR((2025 - u.birthYear) / 10) * 10 AS 연령대, 
       SUM(b.price * b.amount) AS 구매총액
FROM userTbl u
JOIN buyTbl b
ON u.userID = b.userID
GROUP BY FLOOR((2025 - u.birthYear) / 10) * 10
ORDER BY 연령대;
-- floor : 소수점 이하를 버리는 함수


---------------------------------------------
-- having절 : GROUP BY로 그룹화된 결과에 조건을 적용할 때 사용
-- group by로 테이블 정렬까지 끝난 이후에 having 조건 적용

-- HAVING vs WHERE
--   WHERE  : 그룹화하기 전에 개별 행을 필터링
--   HAVING : 그룹화한 후에 그룹을 필터링

-- 구매 금액 합계가 1000 이상인 사용자 조회
SELECT userID, SUM(price * amount) AS 총구매액
FROM buyTbl
GROUP BY userID
HAVING SUM(price * amount) >= 1000;

-- 평균 키가 175 이상인 지역 조회
select addr, avg(height) as 평균키
from usertbl
group by addr
having avg(height)>= 175;

-- 총 구매 횟수가 3회 이상이고 총 구매액이 100 이상인 사용자
select * from buytbl;
select userid, count(*) as 구매횟수, sum(price*amount) as 구매액
from buytbl
group by userid
having count(*)>=3 and sum(price*amount)>=100;

-- 사용자 지역별, 제품 그룹별 구매액 합계
-- 이너 조인 기본 형태 : on이하의 조건을 만족하는 행만 조인
-- select *
-- from usertbl u
-- join buytbl b
-- on u.userid = b.userid;

select u.addr, nvl(b.groupname,'미분류'), sum(b.amount*b.price) as 구매총액
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.addr, b.groupname
order by sum(b.amount*b.price) desc
;

-- 연령대별, 제품별 구매 통계
select floor((2025-birthyear)/10)*10 as 연령대, b.prodname, count(*) as 구매횟수, sum(b.price*b.amount) as 총구매액
from usertbl u
join buytbl b
on u.userid = b.userid
group by floor((2025-birthyear)/10)*10, b.prodname
order by floor((2025-birthyear)/10)*10, b.prodname;

-- 지역별, 연도별 회원가입 수
select * from usertbl;
select addr, count(*) as 가입인원수
from usertbl
group by addr;

---------------------------------------------
-- rollup : 소계와 합계를 자동으로 계산해주는 함수
-- 총합계
SELECT groupName, SUM(price * amount)
FROM buyTbl
GROUP BY ROLLUP(groupName); -- 제일 마지막 행 : 총 합계

-- cube : 모든 가능한 조합의 소계와 합계를 계산
select groupName, prodname, sum(price*amount)
from buytbl
group by cube(groupname, prodname);
-- prodname null인 곳들 : 해당 groupname의 합계 값
-- null의 null은 groupname이 null인 값들의 합

-- UNION ALL : 쿼리 결과 합치기
--             각 쿼리의 모든 결과를 포함한 합집합 (중복제거 안함)
SELECT groupName, prodName, SUM(price * amount)
FROM buyTbl
WHERE groupName IS NOT NULL
GROUP BY GROUPING SETS((groupName), (prodName), ());

select groupname, null as prodname, sum(price*amount)
from buytbl
where groupname is not null
group by groupname

union all

select null as groupname, prodname, sum(price*amount)
from buytbl
where groupname is not null
group by prodname;

---------------------------------------------
-- 문제 확인
select * from buytbl;
select * from usertbl;
-- 1. buyTbl에서 총 구매액이 1,000 이상인 사용자(userID)만 조회하시오
select userid, sum(price*amount) as "총 구매액"
from buytbl
group by userid
having sum(price*amount) >= 1000;

-- 2. userTbl에서 가입자 수가 2명 이상인 addr만 조회하시오
select addr, count(*) as "가입자 수"
from userTbl
group by addr
having count(*) >= 2;

-- 3. buyTbl에서 평균 구매액이 100 이상인 prodName만 조회하시오
select prodname, avg(price*amount) as "평균 구매액"
from buytbl
group by prodname
having avg(price*amount)>=100;

-- 4. userTbl에서 평균 키가 175cm 이상인 출생년도를 조회하시오
select birthyear, avg(height) as 평균키
from usertbl
group by birthyear
having avg(height)>=175;

-- 5. buyTbl에서 최소 2종류 이상의 제품을 구매한 userID를 조회하시오
select userid , count(distinct prodname) as "제품 구매 갯수"
from buytbl
group by userid
having count(distinct prodname) >=2;

-- 6. userTbl과 buyTbl을 조인하여 구매 총액이 200 이상인 addr만 조회하시오
select u.addr, sum(b.price*b.amount) as "구매 총액"
from usertbl u
join buytbl b
on u.userid = b.userid
group by addr
having sum(b.price*b.amount) >=200;

-- 7. buyTbl에서 구매 횟수가 3회 이상이고 총 구매액이 500 이상인 userID를 조회하시오
select userid, count(*) as "구매 횟수", sum(price*amount) as "총 구매액"
from buytbl
group by userid
having count(*)>=3 and sum(price*amount)>=500;

-- 8. userTbl에서 평균 키가 가장 큰 addr을 조회하는 SQL문을 작성하시오. (서브쿼리와 HAVING 사용)
-- 가장 큰 값을 구하는 서브 쿼리 : 서브 쿼리가 조건절로 들어갈 수도 있음
-- 가장 큰 값을 구하는 쿼리를 짠 뒤 조건절에 넣기!
select addr, avg(height) as 평균키
from usertbl
group by addr
having avg(height)=(
    select max(avg(height))
    from usertbl
    group by addr);

-- 9. buyTbl에서 구매 금액의 평균값보다 더 많은 금액을 사용한 userID를 조회하시오
--    (서브쿼리와 HAVING 사용)
select userid, sum(price*amount) as 사용금액
from buytbl
group by userid
having sum(price*amount)>=(select avg(price*amount) from buytbl);

-- 10. userTbl과 buyTbl을 조인하여
--     같은 addr에 사는 사용자들 중 구매 총액이 지역별 평균 구매액보다 높은 userID를 조회하시오
--     (서브쿼리와 HAVING 사용)
select u.userid, u.addr, sum(b.price*b.amount) as 구매총액
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.userid, u.addr
having sum(b.price*b.amount)>=(     -- 값 하나 비교
    select floor(avg(b2.price*b2.amount)) as 평균 -- 여기도 값 하나만 출력되어야 함
    from usertbl u2
    join buytbl b2
    on u2.userid = b2.userid   
    where u2.addr = u.addr  -- 지역 값과 비교해야하니까 원래 지역과 식의 지역 비교
    group by u2.addr);  -- 원하는 조건 값인 지역별 평균이 되게 지역 정렬

select floor(avg(b.price*b.amount))
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.addr;

---------------------------------------------
-- JOIN : 테이블 합침 (3개도 됨)
SELECT *    -- 사로 다른 이름의 열은 별칭을 붙이지 않아도 괜찮음, 공통 열은 별칭 혹은 테이블 명으로 어느 데이터인지 명시해야함
FROM userTbl u  -- 테이블 1 별칭
JOIN buyTbl b   -- 테이블 2 별칭
ON u.userID = b.userID; -- 테이블간의 연결점. 해당 열을 기준으로 테이블 데이터가 합쳐짐

-- 회원별 총 구매 금액
SELECT u.userID, u.name, SUM(b.price * b.amount) AS 총구매금액
FROM userTbl u
JOIN buyTbl b
ON u.userID = b.userID
GROUP BY u.userID, u.name;

-- 상품을 가장 많이 구매한 회원(수량 기준)
-- row number 사용해서 상위 한 회원 출력
-- FETCH FIRST 1 ROWS ONLY;    -- fetch : 버전이 높으면 해당 함수로 추출 가능
select rownum as RN, name, 총수량
from(
    SELECT u.name, SUM(b.amount) AS 총수량
    FROM userTbl u
    JOIN buyTbl b
    ON u.userID = b.userID
    GROUP BY u.name
    ORDER BY SUM(b.amount) DESC
)
where rownum=1;

-- 특정 물품 구매한 회원 조회 ? 예: “책” 구매자
SELECT DISTINCT u.name
FROM userTbl u
JOIN buyTbl b
ON u.userID = b.userID
WHERE b.prodName = '책';

---------------------------------------------
-- 외부 조인(OUTER JOIN)
-- 조인 조건에 일치하지 않는 행도 포함하여 반환
-- on 조건에서 벗어나도 출력
-- 주로 left, right 자주 씀

-- 이너 조인 : mysql에서는 inner join이라 명시해야함
select *
FROM userTbl u
JOIN buyTbl b
ON u.userID = b.userID;

-- 아우터 조인 : left / right / full 3개로 구분됨
select *
FROM userTbl u    -- left 테이블 : 물건을 구매하지 않은 사용자도 출력
left JOIN buyTbl b     -- right 테이블
ON u.userID = b.userID;

select *
FROM userTbl u    -- left 테이블 : 물건을 구매하지 않은 사용자도 출력
left JOIN buyTbl b     -- right 테이블
ON u.userID = b.userID
where b.userid is null; -- 구매하지 않은 고객만 추출 가능

select *
FROM userTbl u    -- left 테이블
right JOIN buyTbl b     -- right 테이블 : 종속적인 관계에서는 불가
ON u.userID = b.userID;
-- 유저와 구매 목록 관계 : 구매 목록은 유저에 포함됨. on 조건을 벗어나는 데이터가 없음
-- -> 그냥 같은 결과 출력 (정렬 순서만 조금 달라짐 : 정렬하면 완전 같은 테이블)

-- full : 3개 이상 필요, 모든 조건을 만족하지 않는 데이터도 출력
--        전체 출력
select *
from studentTbl s
full outer join examtbl e
on s.studentID = e.studentID;
-- 시험을 하나도 치지 않은 학생, 아무도 시험을 치지 않은 과목 전부 출력

