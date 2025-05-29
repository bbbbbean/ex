---------------------------------------------
-- ���� ���� : �������� �׽�Ʈ�� ���� ���̰� ������ ���� ���
-- �� ���̺��� ��� ���� ���� ��ȯ, ���� ����X, ��� : �� ���̺� �� ���� ���� ��ŭ�� �� ����
SELECT *
--SELECT u.name AS ȸ����, b.prodName AS ��ǰ��
FROM userTbl u
CROSS JOIN buyTbl b;
---------------------------------------------
-- ��ü ���� : ������ ������ ���� �� ���, �ڱ� �ڽŰ� ����

-- userTbl ������ ����⵵�� ���� ȸ������ ¦ ����� (�ڱ� �ڽ��� ����)
--SELECT *
SELECT A.name AS ȸ��A, B.name AS ȸ��B, A.birthYear
FROM userTbl A  -- join�� ���� ���̺�
JOIN userTbl B  -- from�� ���� ���̺�
ON A.birthYear = B.birthYear -- ����⵵�� �������� ����
WHERE A.userID <> B.userID; -- <> : not equle

-- userTbl�� ������(���) ID�� �ִٰ� ����
-- ����: userTbl�� managerID �÷��� �߰��� : userSelfTestTbl
-- SELF JOIN ���� ����� ������ ����
select * from userSelfTestTbl;
--SELECT *
SELECT E.name AS ������, M.name AS �����ڸ�
FROM userSelfTestTbl E
JOIN userSelfTestTbl M
ON E.managerID = M.userID;

-- managerID : ���ڰ� �������� ��å ����
select * from emptbl;
SELECT *
FROM empTbl E
LEFT JOIN empTbl M
ON E.managerID = M.empID;

-- �� ������ �� ����� �̸� ���
SELECT E.empName AS ����, M.empName AS ���
FROM empTbl E
LEFT JOIN empTbl M
ON E.managerID = M.empID;

-- �� ���������� 1�� �̻��� ��� ���
SELECT M.empName AS ���, COUNT(*) AS ���ϼ�
FROM empTbl E   -- ����
JOIN empTbl M   -- ���
ON E.managerID = M.empID
--where M.empName = '���ǥ'
GROUP BY M.empName
order by COUNT(*) desc;

-- �� Ư�� ���(�̺���)�� ��� ���� ���
SELECT M.empName AS ���, E.empName as ����
FROM empTbl E
JOIN empTbl M
ON E.managerID = M.empID;
--WHERE M.empName = '�̺���';

---------------------------------------------
-- inner join ���� 
select * from usertbl;
select * from buytbl;
select *
from usertbl u
join buytbl b
on u.userid = b.userid;
-- �� ��� ȸ���� �̸��� ������ ��ǰ��, �ܰ�, ���� ��ȸ (�������� ���� ȸ�� ����)
-- �̸�, ��ǰ��, �ܰ�, ���� ���
select name, prodname, price, amount
from usertbl u
join buytbl b
on u.userid = b.userid;

-- �� ȸ���� �� ���� �ݾ�(�ܰ� �� ������ ��) ���
-- �̸�, �ѱ��űݾ� ���. �ݾ� ���� �� ����
select name, sum(price*amount) as ���űݾ�
from usertbl u
join buytbl b
on u.userid = b.userid
group by name
order by sum(price*amount) desc;

-- �� 'å'�� ������ ȸ�� �̸� �ߺ� ���� ��ȸ
select distinct name
from usertbl u
join buytbl b
on u.userid = b.userid
where prodname = 'å';

-- �� 2010�� ���� ������ ȸ���� ������ ��ǰ ���� ��ȸ
-- �̸�, ������, ��ǰ�� ���
select name, mdate as ������, prodname
from usertbl u
join buytbl b
on u.userid = b.userid
--WHERE u.mDate >= TO_DATE('2010-01-01');
where substr(mdate,1,2)>=10;

-- �� ��ǰ�� ���� ���� ������ ȸ��(���� ����) 1�� ���
-- �̸�, �Ѽ��� ���
select rownum as RN, name, �Ѽ���
from(
    select name, sum(amount) as �Ѽ���
    from usertbl u
    join buytbl b
    on u.userid = b.userid
    group by name, rownum
    order by sum(amount) desc
)
where rownum = 1;

-- �� Ű�� 175 �̻��� ȸ�� �� ������ ��ǰ�� �ִ� ��� �̸�, ��ǰ�� ���
select name, prodname
from usertbl u
join buytbl b
on u.userid = b.userid
where height >= 175;

-- �� ��ǰ �з�(groupName)���� �� �����(�ܰ�������) ���
select nvl(groupname,'�̺з�'), sum(price*amount) as �����
from usertbl u
join buytbl b
on u.userid = b.userid
--where groupname is not null
group by groupname;

-- �� ���� ������ ��� ȸ���� ������ ��ǰ��� ���� ���
select name, prodname, amount, addr
from usertbl u
join buytbl b
on u.userid = b.userid
where addr = '����'
order by name, amount desc;

-- �� ��ǰ�� ���� ȸ�� ��(�ߺ� ����) ���
-- �ߺ� ȸ���� ����� �ϴϱ� ȸ���� �ߺ��� ���ִ� Ű �ֱ�
-- ���Ǹ����� �̸� �� ��Ƹ���
select prodname, count(distinct name) as "���� ȸ�� ��"
from usertbl u
join buytbl b
on u.userid = b.userid
group by prodname
order by count(*) desc, prodname;

-- �� ȸ���� ��� ���� �ܰ�(�Ҽ��� 2�ڸ� �ݿø�) ���
-- price*amount : �Һ� �ܰ� / price ����� ���� �ܰ�
select name, round(avg(price),2)
from usertbl u
join buytbl b
on u.userid = b.userid
group by name;

---------------------------------------------
-- outer join ����
-- LEFT JOIN
-- �� ��� ȸ���� �̸��� ���� ����(���� ��� NULL�� ǥ��)
-- �̸�, ��ǰ��, ���� ���
select name, prodname, price
from usertbl u
left outer join buytbl b
on u.userid = b.userid
order by name;

-- �� ���� �̷��� ���� ȸ���� ��ȸ (���� �� �� ��� ã��)
-- �̸�, ID ���
select name, u.userid
from usertbl u
left outer join buytbl b
on u.userid = b.userid
where amount is null;

-- �� ������ ȸ�� �̸��� ���� ���� (���� ������ NULL)
-- ����, �̸�, ���� ���
select name, sum(amount) as "���� ����", addr
from usertbl u
left outer join buytbl b
on u.userid = b.userid
group by name, addr
order by addr, name;

-- �� ȸ���� �� ���� �ݾ� (������ 0���� ǥ��)
-- �̸�, �ѱݾ� ���
select name, nvl(sum(price*amount),0) as �ѱݾ�
from usertbl u
left outer join buytbl b
on u.userid = b.userid
group by name
order by nvl(sum(price*amount),0) desc;

-- �� Ű�� 170 �̻��� ȸ���� ���� ���� (���� ������ NULL)
-- �̸�, Ű, ��ǰ�� ���
select name, height, prodname
from usertbl u
left outer join buytbl b
on u.userid = b.userid
where height >= 170
order by name, height desc;

-- RIGHT JOIN
-- �� ���� ���̺� �������� ȸ�� �̸��� ���� ��ǰ ���
-- �̸�, ��ǰ�� ���

select name, prodname
from usertbl u
right outer join buytbl b
on u.userid = b.userid;

-- ���� �ܼ� ��� ����.. �ش�Ǵ� ���� ����,,

-- FULL OUTER JOIN - studentTbl + examTbl ���
select * from studentTbl;
select * from examTbl;
select * from studentTbl s join examTbl e on s.studentid = e.studentid;
select * from studentTbl s full outer join examTbl e on s.studentid = e.studentid;
-- �� ��� �л��� ���� ���� ��� (���� ���ų� �л� ���� �� ����)
-- �̸�, ����, ���� ���
select name, subject, score
from studentTbl s
full outer join examTbl e
on s.studentid = e.studentid;

-- �� ������ �������� ���� �л� ��ȸ
-- �л� �̸� ���
select name
from studentTbl s
full outer join examTbl e
on s.studentid = e.studentid
where score is null;

-- �� �������� �ʴ� �л�ID�� ������ ���� ��� ��ȸ
-- ����ID, ����, ���� ���
select s.studentid, subject, score
from studentTbl s
full outer join examTbl e
on s.studentid = e.studentid
where s.studentid is null;

-- �� �л� + ���� ���� �Ѳ����� ��� (���� ���� NULL)
-- �л�ID, �̸�, ����, ���� ���
select s.studentid, name, subject, score
from studentTbl s
full outer join examTbl e
on s.studentid = e.studentid;

-- �� �л� �̸��� ���� ����/���� �Բ� ��� (���� ������ NULL)
-- �̸�, ����, ���� ���
select name, subject, score
from studentTbl s
full outer join examTbl e
on s.studentid = e.studentid;

---------------------------------------------
-- NATURAL JOIN
-- �� ���̺��� ������ �̸��� ���� ��� �÷��� ���� �ڵ����� ���� ���� ����
-- �߰����� ������ �������� �ʾƵ� �Ǹ�, ���� �÷��� ���� ���� ��� ��� ���� �������� ���
-- �ߺ� �÷��� �ڵ����� ��ħ(ǥ�� ��Ÿ���� ����)
-- mysql�� ��� �׳� join���� �˾Ƽ� �ٿ���(on������ �ʿ� ����)
select *
from usertbl u
natural join buytbl b;

---------------------------------------------
-- USING ���� �̿��� ����
-- ��Ī �ν� X
-- on ���� ��� ���, �������� �÷� ����ȭ, �̳� ���� ����
select *
from usertbl
join buytbl
using(userid); 













