-- select * from usertbl;
-- 조건절 추가
select * from usertbl;
-- ----------------------
-- where 절
-- 해당 조건을 충족하는 행 출력
-- 비교 연산자, 논리 연산자 사용 가능
-- ----------------------
select * from usertbl where name='조용필';
-- 조건절 + 관계연산자
-- 비교연산자, 논리연산자
select * from usertbl where birthyear >=1970 and height>=182;
select * from usertbl where birthyear >=1970 or height>=182;
-- 같은 행의 and 연산 : where 행 between ~ and ~ ;
select * from usertbl where birthyear >=1970 and birthyear<=1980;
select * from usertbl where birthyear between 1970 and 1980;
-- in : 그룹 지정, 값 만족 판별 후 그룹, 하나만 만족해도 출력
select name,height from userTbl where addr in('경남','전남','경북');
select * from usertbl where mobile1 in('010','011');
-- like : 포함 문자열 검색
-- % : 길이 제한이 없는 모든 문자
-- _ : 언더바 만큼 길이의 모든 문자
select name, height from usertbl where name like '%수';
select name, addr, mobile2 from usertbl where name like '_재범';
-- null 체크
select name, mobile1, mobile2 from usertbl where mobile2 is null;
select userid, name, mobile1, mobile2 from usertbl where mobile1 is not null;
select * from usertbl where mobile1 is null and mobile2 is null;
-- 중복 행 제거 : distinct
select DISTINCT addr from usertbl;
select * from usertbl;
-- 별칭 지정 : alias (as)
-- || 문자열 더하기
select mobile1 || mobile2 as phone from usertbl;

-- ------------------------------
-- 문제 풀기
select * from buytbl;
-- 1. amount 5개 이상 행 출력
select * from buytbl where amount>=5;
-- 2. price 50 이상 500 이하인 행의 userid, prodname 출력
select userid, prodname from buytbl where price between 50 and 500;
-- 3. amount 10 이상이거나 price 100이상인 행 출력
select * from buytbl where amount>=10 or price>=100;
-- 4. userid가 k로 시작하는 행 출력 : 대소문자 가림
select * from buytbl where userid like 'K%';
-- 5. 서적이거나 전자인 행 출력 : in!!!!
select * from buytbl where groupname in ('서적', '전자');
-- 6. prodname이 책이거나 userid가 w로 끝나는 행 출력
-- 자료형때문에 마지막 문자열 찾기가 실행되지 않은 것,
-- char -> 뒤 공백을 trim으로 삭제 후 골라내거나
-- 뒤 공백도 포함해서 문자열 찾기
select * from buytbl where prodname='책' or userid like '__W%';


