---------------------------------------------
-- 교차 조인 : 여러가지 테스트를 위한 더미값 생성을 위해 사용
-- 두 테이블의 모든 행의 조합 반환, 조인 조건X, 결과 : 두 테이블 행 수를 곱한 만큼의 행 생성
SELECT *
--SELECT u.name AS 회원명, b.prodName AS 상품명
FROM userTbl u
CROSS JOIN buyTbl b;
---------------------------------------------
-- 자체 조인 : 계층형 구조를 만들 때 사용, 자기 자신과 조인

-- userTbl 내에서 출생년도가 같은 회원끼리 짝 지어보기 (자기 자신은 제외)
--SELECT *
SELECT A.name AS 회원A, B.name AS 회원B, A.birthYear
FROM userTbl A  -- join과 같은 테이블
JOIN userTbl B  -- from과 같은 테이블
ON A.birthYear = B.birthYear -- 출생년도를 기준으로 묶음
WHERE A.userID <> B.userID; -- <> : not equle

-- userTbl에 관리자(상사) ID가 있다고 가정
-- 가정: userTbl에 managerID 컬럼이 추가됨 : userSelfTestTbl
-- SELF JOIN 으로 사원과 관리자 연결
select * from userSelfTestTbl;
--SELECT *
SELECT E.name AS 직원명, M.name AS 관리자명
FROM userSelfTestTbl E
JOIN userSelfTestTbl M
ON E.managerID = M.userID;

-- managerID : 숫자가 높을수록 직책 낮음
select * from emptbl;
SELECT *
FROM empTbl E
LEFT JOIN empTbl M
ON E.managerID = M.empID;

-- ① 직원과 그 상사의 이름 출력
SELECT E.empName AS 직원, M.empName AS 상사
FROM empTbl E
LEFT JOIN empTbl M
ON E.managerID = M.empID;

-- ② 부하직원이 1명 이상인 상사 목록
SELECT M.empName AS 상사, COUNT(*) AS 부하수
FROM empTbl E   -- 직원
JOIN empTbl M   -- 상사
ON E.managerID = M.empID
--where M.empName = '김대표'
GROUP BY M.empName
order by COUNT(*) desc;

-- ③ 특정 상사(이부장)의 모든 직원 출력
SELECT M.empName AS 상사, E.empName as 직원
FROM empTbl E
JOIN empTbl M
ON E.managerID = M.empID;
--WHERE M.empName = '이부장';

---------------------------------------------
-- inner join 문제 
select * from usertbl;
select * from buytbl;
select *
from usertbl u
join buytbl b
on u.userid = b.userid;
-- ① 모든 회원의 이름과 구매한 상품명, 단가, 수량 조회 (구매하지 않은 회원 제외)
-- 이름, 상품명, 단가, 수량 출력
select name, prodname, price, amount
from usertbl u
join buytbl b
on u.userid = b.userid;

-- ② 회원별 총 구매 금액(단가 × 수량의 합) 출력
-- 이름, 총구매금액 출력. 금액 높은 순 정렬
select name, sum(price*amount) as 구매금액
from usertbl u
join buytbl b
on u.userid = b.userid
group by name
order by sum(price*amount) desc;

-- ③ '책'을 구매한 회원 이름 중복 없이 조회
select distinct name
from usertbl u
join buytbl b
on u.userid = b.userid
where prodname = '책';

-- ④ 2010년 이후 가입한 회원이 구매한 상품 내역 조회
-- 이름, 가입일, 상품명 출력
select name, mdate as 가입일, prodname
from usertbl u
join buytbl b
on u.userid = b.userid
--WHERE u.mDate >= TO_DATE('2010-01-01');
where substr(mdate,1,2)>=10;

-- ⑤ 상품을 가장 많이 구매한 회원(수량 기준) 1명만 출력
-- 이름, 총수량 출력
select rownum as RN, name, 총수량
from(
    select name, sum(amount) as 총수량
    from usertbl u
    join buytbl b
    on u.userid = b.userid
    group by name, rownum
    order by sum(amount) desc
)
where rownum = 1;

-- ⑥ 키가 175 이상인 회원 중 구매한 상품이 있는 경우 이름, 상품명 출력
select name, prodname
from usertbl u
join buytbl b
on u.userid = b.userid
where height >= 175;

-- ⑦ 상품 분류(groupName)별로 총 매출액(단가×수량) 출력
select nvl(groupname,'미분류'), sum(price*amount) as 매출액
from usertbl u
join buytbl b
on u.userid = b.userid
--where groupname is not null
group by groupname;

-- ⑧ 서울 지역에 사는 회원이 구매한 상품명과 수량 출력
select name, prodname, amount, addr
from usertbl u
join buytbl b
on u.userid = b.userid
where addr = '서울'
order by name, amount desc;

-- ⑨ 물품별 구매 회원 수(중복 없이) 출력
-- 중복 회원이 없어야 하니까 회원에 중복값 없애는 키 넣기
-- 물건마다의 이름 수 헤아리기
select prodname, count(distinct name) as "구매 회원 수"
from usertbl u
join buytbl b
on u.userid = b.userid
group by prodname
order by count(*) desc, prodname;

-- ⑩ 회원별 평균 구매 단가(소수점 2자리 반올림) 출력
-- price*amount : 소비 단가 / price 평균이 구매 단가
select name, round(avg(price),2)
from usertbl u
join buytbl b
on u.userid = b.userid
group by name;

---------------------------------------------
-- outer join 문제
-- LEFT JOIN
-- ① 모든 회원의 이름과 구매 내역(없는 경우 NULL로 표시)
-- 이름, 상품명, 가격 출력
select name, prodname, price
from usertbl u
left outer join buytbl b
on u.userid = b.userid
order by name;

-- ② 구매 이력이 없는 회원만 조회 (구매 안 한 사람 찾기)
-- 이름, ID 출력
select name, u.userid
from usertbl u
left outer join buytbl b
on u.userid = b.userid
where amount is null;

-- ③ 지역별 회원 이름과 구매 수량 (구매 없으면 NULL)
-- 지역, 이름, 수량 출력
select name, sum(amount) as "구매 수량", addr
from usertbl u
left outer join buytbl b
on u.userid = b.userid
group by name, addr
order by addr, name;

-- ④ 회원별 총 구매 금액 (없으면 0으로 표시)
-- 이름, 총금액 출력
select name, nvl(sum(price*amount),0) as 총금액
from usertbl u
left outer join buytbl b
on u.userid = b.userid
group by name
order by nvl(sum(price*amount),0) desc;

-- ⑤ 키가 170 이상인 회원의 구매 정보 (구매 없으면 NULL)
-- 이름, 키, 상품명 출력
select name, height, prodname
from usertbl u
left outer join buytbl b
on u.userid = b.userid
where height >= 170
order by name, height desc;

-- RIGHT JOIN
-- ① 구매 테이블 기준으로 회원 이름과 구매 상품 출력
-- 이름, 상품명 출력

select name, prodname
from usertbl u
right outer join buytbl b
on u.userid = b.userid;

-- 전부 단순 출력 문제.. 해당되는 값이 없음,,

-- FULL OUTER JOIN - studentTbl + examTbl 사용
select * from studentTbl;
select * from examTbl;
select * from studentTbl s join examTbl e on s.studentid = e.studentid;
select * from studentTbl s full outer join examTbl e on s.studentid = e.studentid;
-- ① 모든 학생과 시험 정보 출력 (시험 없거나 학생 없을 수 있음)
-- 이름, 과목, 점수 출력
select name, subject, score
from studentTbl s
full outer join examTbl e
on s.studentid = e.studentid;

-- ② 시험을 응시하지 않은 학생 조회
-- 학생 이름 출력
select name
from studentTbl s
full outer join examTbl e
on s.studentid = e.studentid
where score is null;

-- ③ 존재하지 않는 학생ID로 응시한 시험 기록 조회
-- 시험ID, 과목, 점수 출력
select s.studentid, subject, score
from studentTbl s
full outer join examTbl e
on s.studentid = e.studentid
where s.studentid is null;

-- ④ 학생 + 시험 정보 한꺼번에 출력 (누락 정보 NULL)
-- 학생ID, 이름, 과목, 점수 출력
select s.studentid, name, subject, score
from studentTbl s
full outer join examTbl e
on s.studentid = e.studentid;

-- ⑤ 학생 이름과 시험 과목/점수 함께 출력 (시험 없으면 NULL)
-- 이름, 과목, 점수 출력
select name, subject, score
from studentTbl s
full outer join examTbl e
on s.studentid = e.studentid;

---------------------------------------------
-- NATURAL JOIN
-- 두 테이블에서 동일한 이름을 가진 모든 컬럼에 대해 자동으로 동등 조인 수행
-- 추가적인 조건을 지정하지 않아도 되며, 공통 컬럼이 여러 개일 경우 모두 조인 조건으로 사용
-- 중복 컬럼은 자동으로 합침(표에 나타나지 않음)
-- mysql의 경우 그냥 join사용시 알아서 붙여줌(on조건절 필요 없음)
select *
from usertbl u
natural join buytbl b;

---------------------------------------------
-- USING 절을 이용한 조인
-- 별칭 인식 X
-- on 조건 대신 사용, 조건절의 컬럼 단일화, 이너 조인 형태
select *
from usertbl
join buytbl
using(userid); 













