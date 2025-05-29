---------------------------------------------
-- ���� (�⺻ ��������)
-- order by
-- order by ���Ŀ� desc

-- ��¥�� �������� ����
select name, mdate from usertbl order by mdate; -- ��������
select name, mdate from usertbl order by name;
select name, mdate from usertbl order by mdate desc; -- ��������
select name, height from usertbl order by height desc, name desc; -- Ű �������� ���� �� �̸� �������� ����(���� Ű �ȿ����� ����)

-- ���� ���� - ���� �ȿ� ���� ���� ()�ȿ� ���� ���
-- �׳� run������ ������ ���� ���� ��ȣ�� ���α׷��� ���Ƿ� �����ִ� �ε��� (mysql������ ���� ����)
-- -> ���� ���� �ƴ϶� �̿� �Ұ�
-- rownum�� �̿��ϸ� �� ��ȣ�� ��µ� : �̰� ���� ������ ����� �̿� ����
-- ���� �ȿ� ������ �־� �̿��ϴ� ���·� ��� (���� Ȯ��)
select rownum as RN, usertbl.* from usertbl;
-- ���� ) 
select * from
(select rownum as RN, usertbl.* from usertbl) where RN=2;

-- ����⵵ ���� ����� ��
select birthyear, count(*) as �ο���
from usertbl
group by birthyear
order by birthyear; -- �������� ����
---------------------------------------------
-- GROUP BY ��
-- Ư�� �׷캰 ��ġ�� Ȯ��
-- SELECT ������ GROUP BY�� ��õ� �÷��� ���� �Լ��� ��밡��

-- �⺻ ����
-- SELECT �÷�1, �÷�2, ... �����Լ�(�÷�)
-- FROM ���̺�
-- [WHERE ���ǽ�]
-- GROUP BY �÷�1, �÷�2, ...
-- [ORDER BY �÷� [ASC|DESC]];
-- [] : �������� ǥ��

select * from buytbl;

-- �� userid�� ���� * ����
select userid,price, amount from buytbl;
-- group by �� ���� ���� ó���� �������
select userid, sum(price*amount) as �����Ѿ� -- �����Ǵ� ���� ������ ������ ����
from buytbl
group by userid; -- ����� ���� ����

--
select userid, count(*) as ����Ƚ�� -- count Ƚ�� 
from buytbl
group by userid;

-- ������ ����� �� ���
select * from usertbl;
select addr, count(*) as ����ڼ�
from usertbl
group by addr;

-- ��ǰ �׷캰 �Ǹ� �ݾ� �հ�
select * from buytbl;
select groupname, sum(price*amount) as �Ǹž�
from buytbl
where groupname is not null
group by groupname; -- where�� �ڿ� ����

---------------------------------------------
-- ���� Ȯ��
select * from usertbl;
select * from buytbl;

-- 1. userTbl���� ����(addr)�� ����� ���� ���Ͻÿ�
select addr, count (*) as ����ڼ�
from usertbl
group by addr;

-- 2. buyTbl���� userID�� �� ���ž��� ���Ͻÿ�. �� ���ž��� price*amount�� ��
select userid, sum(price*amount) as �ѱ��ž�
from buytbl
group by userid;

-- 3. buyTbl���� groupName�� �Ǹ� ������ �հ踦 ���Ͻÿ�. NULL ���� '�̺з�'�� ǥ���Ͻÿ�
-- coalesce?? null�� üũ �Լ�, null�� üũ �� null �κп� ���� �� ���� ����
--select coalesce(groupname,'�̺з�') as ��ǰ�׷�, sum(amount) as ��ü�Ǹż���
-- nvl?? nullvalue
--select nvl(groupname,'�̺з�') as ��ǰ�׷�, sum(amount) as ��ü�Ǹż���
-- case ~ is null then??
select
    -- case ó�� (end�� ����)
    case when groupname is null then '�̺з�'
    else groupname
    end
    as ��ǰ�׷�, sum(amount) as ��ü�Ǹż���
from buytbl
group by groupname;

-- 4. userTbl���� birthYear�� ��� height�� ���Ͻÿ�
select birthyear, avg(height) as ���Ű
from usertbl
group by birthyear;

-- 5. buyTbl���� prodName�� ���� Ƚ���� �� ���ž��� �����Ͻÿ�. ���� Ƚ���� ���� ������ ����
select prodname,count(amount) as "���� Ƚ��",sum(price*amount) as "�� ���ž�"
from buytbl
GROUP by prodname
order by "���� Ƚ��" desc;

-- 6. userTbl���� mobile1 �� ������ ���� ���ϵ�, NULL ���� '���Է�'���� ǥ���Ͻÿ�
select nvl(mobile1,'���Է�') as ��Ż�, count(*) as �����ڼ�
from usertbl
group by mobile1;

-- 7. userTbl�� buyTbl�� �����Ͽ� ����(addr)�� �� ���ž��� ���Ͻÿ�.
select u.addr, sum(b.price*b.amount) as "�� ���ž�"
from usertbl u
join buytbl b
on u.usertbl = b.buytbl
group by u.addr;

-- 8. buyTbl���� ����ں� ������ ��ǰ�� ���� ���� ���Ͻÿ�
-- select userid,count(prodname) as ��������ǰ������ -- �ܼ� ī��Ʈ, ��ǰ ���� �� ī��Ʈ �Ϸ��� �ߺ��� ���� �� ī��Ʈ -> distinct
select userid,count(distinct prodname) as "������ ��ǰ ������"
-- select userid, groupname,count(groupname) from buytbl group by userid, groupname;
from buytbl
group by userid;

-- 9. userTbl���� ���� ������(mDate�� ���� �κ�) ������ ���� �����Ͻÿ�
-- ����ȯ ��Ʈ ����
select substr(mdate,1,2),count(*)
from usertbl
group by substr(mdate,1,2);

-- 10. buyTbl�� userTbl�� �����Ͽ� ���ɴ뺰(10��, 20��, ...) ���� �Ѿ��� ����Ͻÿ�. ������ 2023�� �������� ����Ͻÿ�.
SELECT FLOOR((2025 - u.birthYear) / 10) * 10 AS ���ɴ�, 
       SUM(b.price * b.amount) AS �����Ѿ�
FROM userTbl u
JOIN buyTbl b
ON u.userID = b.userID
GROUP BY FLOOR((2025 - u.birthYear) / 10) * 10
ORDER BY ���ɴ�;
-- floor : �Ҽ��� ���ϸ� ������ �Լ�


---------------------------------------------
-- having�� : GROUP BY�� �׷�ȭ�� ����� ������ ������ �� ���
-- group by�� ���̺� ���ı��� ���� ���Ŀ� having ���� ����

-- HAVING vs WHERE
--   WHERE  : �׷�ȭ�ϱ� ���� ���� ���� ���͸�
--   HAVING : �׷�ȭ�� �Ŀ� �׷��� ���͸�

-- ���� �ݾ� �հ谡 1000 �̻��� ����� ��ȸ
SELECT userID, SUM(price * amount) AS �ѱ��ž�
FROM buyTbl
GROUP BY userID
HAVING SUM(price * amount) >= 1000;

-- ��� Ű�� 175 �̻��� ���� ��ȸ
select addr, avg(height) as ���Ű
from usertbl
group by addr
having avg(height)>= 175;

-- �� ���� Ƚ���� 3ȸ �̻��̰� �� ���ž��� 100 �̻��� �����
select * from buytbl;
select userid, count(*) as ����Ƚ��, sum(price*amount) as ���ž�
from buytbl
group by userid
having count(*)>=3 and sum(price*amount)>=100;

-- ����� ������, ��ǰ �׷캰 ���ž� �հ�
-- �̳� ���� �⺻ ���� : on������ ������ �����ϴ� �ุ ����
-- select *
-- from usertbl u
-- join buytbl b
-- on u.userid = b.userid;

select u.addr, nvl(b.groupname,'�̺з�'), sum(b.amount*b.price) as �����Ѿ�
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.addr, b.groupname
order by sum(b.amount*b.price) desc
;

-- ���ɴ뺰, ��ǰ�� ���� ���
select floor((2025-birthyear)/10)*10 as ���ɴ�, b.prodname, count(*) as ����Ƚ��, sum(b.price*b.amount) as �ѱ��ž�
from usertbl u
join buytbl b
on u.userid = b.userid
group by floor((2025-birthyear)/10)*10, b.prodname
order by floor((2025-birthyear)/10)*10, b.prodname;

-- ������, ������ ȸ������ ��
select * from usertbl;
select addr, count(*) as �����ο���
from usertbl
group by addr;

---------------------------------------------
-- rollup : �Ұ�� �հ踦 �ڵ����� ������ִ� �Լ�
-- ���հ�
SELECT groupName, SUM(price * amount)
FROM buyTbl
GROUP BY ROLLUP(groupName); -- ���� ������ �� : �� �հ�

-- cube : ��� ������ ������ �Ұ�� �հ踦 ���
select groupName, prodname, sum(price*amount)
from buytbl
group by cube(groupname, prodname);
-- prodname null�� ���� : �ش� groupname�� �հ� ��
-- null�� null�� groupname�� null�� ������ ��

-- UNION ALL : ���� ��� ��ġ��
--             �� ������ ��� ����� ������ ������ (�ߺ����� ����)
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
-- ���� Ȯ��
select * from buytbl;
select * from usertbl;
-- 1. buyTbl���� �� ���ž��� 1,000 �̻��� �����(userID)�� ��ȸ�Ͻÿ�
select userid, sum(price*amount) as "�� ���ž�"
from buytbl
group by userid
having sum(price*amount) >= 1000;

-- 2. userTbl���� ������ ���� 2�� �̻��� addr�� ��ȸ�Ͻÿ�
select addr, count(*) as "������ ��"
from userTbl
group by addr
having count(*) >= 2;

-- 3. buyTbl���� ��� ���ž��� 100 �̻��� prodName�� ��ȸ�Ͻÿ�
select prodname, avg(price*amount) as "��� ���ž�"
from buytbl
group by prodname
having avg(price*amount)>=100;

-- 4. userTbl���� ��� Ű�� 175cm �̻��� ����⵵�� ��ȸ�Ͻÿ�
select birthyear, avg(height) as ���Ű
from usertbl
group by birthyear
having avg(height)>=175;

-- 5. buyTbl���� �ּ� 2���� �̻��� ��ǰ�� ������ userID�� ��ȸ�Ͻÿ�
select userid , count(distinct prodname) as "��ǰ ���� ����"
from buytbl
group by userid
having count(distinct prodname) >=2;

-- 6. userTbl�� buyTbl�� �����Ͽ� ���� �Ѿ��� 200 �̻��� addr�� ��ȸ�Ͻÿ�
select u.addr, sum(b.price*b.amount) as "���� �Ѿ�"
from usertbl u
join buytbl b
on u.userid = b.userid
group by addr
having sum(b.price*b.amount) >=200;

-- 7. buyTbl���� ���� Ƚ���� 3ȸ �̻��̰� �� ���ž��� 500 �̻��� userID�� ��ȸ�Ͻÿ�
select userid, count(*) as "���� Ƚ��", sum(price*amount) as "�� ���ž�"
from buytbl
group by userid
having count(*)>=3 and sum(price*amount)>=500;

-- 8. userTbl���� ��� Ű�� ���� ū addr�� ��ȸ�ϴ� SQL���� �ۼ��Ͻÿ�. (���������� HAVING ���)
-- ���� ū ���� ���ϴ� ���� ���� : ���� ������ �������� �� ���� ����
-- ���� ū ���� ���ϴ� ������ § �� �������� �ֱ�!
select addr, avg(height) as ���Ű
from usertbl
group by addr
having avg(height)=(
    select max(avg(height))
    from usertbl
    group by addr);

-- 9. buyTbl���� ���� �ݾ��� ��հ����� �� ���� �ݾ��� ����� userID�� ��ȸ�Ͻÿ�
--    (���������� HAVING ���)
select userid, sum(price*amount) as ���ݾ�
from buytbl
group by userid
having sum(price*amount)>=(select avg(price*amount) from buytbl);

-- 10. userTbl�� buyTbl�� �����Ͽ�
--     ���� addr�� ��� ����ڵ� �� ���� �Ѿ��� ������ ��� ���ž׺��� ���� userID�� ��ȸ�Ͻÿ�
--     (���������� HAVING ���)
select u.userid, u.addr, sum(b.price*b.amount) as �����Ѿ�
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.userid, u.addr
having sum(b.price*b.amount)>=(     -- �� �ϳ� ��
    select floor(avg(b2.price*b2.amount)) as ��� -- ���⵵ �� �ϳ��� ��µǾ�� ��
    from usertbl u2
    join buytbl b2
    on u2.userid = b2.userid   
    where u2.addr = u.addr  -- ���� ���� ���ؾ��ϴϱ� ���� ������ ���� ���� ��
    group by u2.addr);  -- ���ϴ� ���� ���� ������ ����� �ǰ� ���� ����

select floor(avg(b.price*b.amount))
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.addr;

---------------------------------------------
-- JOIN : ���̺� ��ħ (3���� ��)
SELECT *    -- ��� �ٸ� �̸��� ���� ��Ī�� ������ �ʾƵ� ������, ���� ���� ��Ī Ȥ�� ���̺� ������ ��� ���������� ����ؾ���
FROM userTbl u  -- ���̺� 1 ��Ī
JOIN buyTbl b   -- ���̺� 2 ��Ī
ON u.userID = b.userID; -- ���̺��� ������. �ش� ���� �������� ���̺� �����Ͱ� ������

-- ȸ���� �� ���� �ݾ�
SELECT u.userID, u.name, SUM(b.price * b.amount) AS �ѱ��űݾ�
FROM userTbl u
JOIN buyTbl b
ON u.userID = b.userID
GROUP BY u.userID, u.name;

-- ��ǰ�� ���� ���� ������ ȸ��(���� ����)
-- row number ����ؼ� ���� �� ȸ�� ���
-- FETCH FIRST 1 ROWS ONLY;    -- fetch : ������ ������ �ش� �Լ��� ���� ����
select rownum as RN, name, �Ѽ���
from(
    SELECT u.name, SUM(b.amount) AS �Ѽ���
    FROM userTbl u
    JOIN buyTbl b
    ON u.userID = b.userID
    GROUP BY u.name
    ORDER BY SUM(b.amount) DESC
)
where rownum=1;

-- Ư�� ��ǰ ������ ȸ�� ��ȸ ? ��: ��å�� ������
SELECT DISTINCT u.name
FROM userTbl u
JOIN buyTbl b
ON u.userID = b.userID
WHERE b.prodName = 'å';

---------------------------------------------
-- �ܺ� ����(OUTER JOIN)
-- ���� ���ǿ� ��ġ���� �ʴ� �൵ �����Ͽ� ��ȯ
-- on ���ǿ��� ����� ���
-- �ַ� left, right ���� ��

-- �̳� ���� : mysql������ inner join�̶� ����ؾ���
select *
FROM userTbl u
JOIN buyTbl b
ON u.userID = b.userID;

-- �ƿ��� ���� : left / right / full 3���� ���е�
select *
FROM userTbl u    -- left ���̺� : ������ �������� ���� ����ڵ� ���
left JOIN buyTbl b     -- right ���̺�
ON u.userID = b.userID;

select *
FROM userTbl u    -- left ���̺� : ������ �������� ���� ����ڵ� ���
left JOIN buyTbl b     -- right ���̺�
ON u.userID = b.userID
where b.userid is null; -- �������� ���� ���� ���� ����

select *
FROM userTbl u    -- left ���̺�
right JOIN buyTbl b     -- right ���̺� : �������� ���迡���� �Ұ�
ON u.userID = b.userID;
-- ������ ���� ��� ���� : ���� ����� ������ ���Ե�. on ������ ����� �����Ͱ� ����
-- -> �׳� ���� ��� ��� (���� ������ ���� �޶��� : �����ϸ� ���� ���� ���̺�)

-- full : 3�� �̻� �ʿ�, ��� ������ �������� �ʴ� �����͵� ���
--        ��ü ���
select *
from studentTbl s
full outer join examtbl e
on s.studentID = e.studentID;
-- ������ �ϳ��� ġ�� ���� �л�, �ƹ��� ������ ġ�� ���� ���� ���� ���

