---------------------------------------------
-- ���� �� ���� ����(Single Row Subquery)
-- ���ȣ���� Ű�� ū ����� ��ȸ
SELECT userID, name, height 
FROM userTbl
WHERE height > (SELECT height FROM userTbl WHERE name = '���ȣ');

---------------------------------------------
-- ���� �� ��������
-- ���� ������ ���� ����� ���� �� ��ȯ
-- ���� �� �� ������ ���: IN, ANY, ALL, EXISTS

-- in : ��Ȯ�� �� ��ȯ
SELECT userID, name, addr, height
FROM userTbl
WHERE height IN (SELECT height FROM userTbl WHERE addr = '�泲');

-- any : � �͵� ������� ����, or ������ ����
SELECT userID, name, addr, height
FROM userTbl
WHERE height >= any (SELECT height FROM userTbl WHERE addr = '�泲');
-- �泲�� ��� ������� Ű���� ũ�� ����

-- all : ���� �������Ѿ� ��, and ������ ����
SELECT userID, name, addr, height
FROM userTbl
WHERE height >= all (SELECT height FROM userTbl WHERE addr = '�泲');

-- �ּҺ��� ���� Ű�� ū ����� ��ȸ
SELECT userID, name, addr, height
FROM userTbl
WHERE (addr, height) IN (SELECT addr, MAX(height) FROM userTbl GROUP BY addr);
SELECT addr, MAX(height) FROM userTbl GROUP BY addr;

---------------------------------------------
-- ��Į�� ���� ���� : return ���� 1��
-- �Ѱ��� ���� ������ ���

-- �� ������� ���� �Ѿ� ���
-- ���� ���� �� ���� ����
SELECT u.userID, name, 
       (SELECT SUM(price*amount) FROM buyTbl b WHERE b.userID = u.userID) AS "�ѱ��ž�"
FROM userTbl u
join buytbl b
on u.userID = b.userID
group by u.userid,name;
-- ���� �ϳ��� ��ȯ
SELECT SUM(price*amount)
FROM buyTbl b
join usertbl u
on u.userID = b.userID
WHERE b.userID = u.userID;

---------------------------------------------
-- �������� ���� Ȯ��
select * from buytbl;
select * from usertbl;
-- 1. ���� ������ �����ϴ� ȸ�� ��, ��ü ��� Ű���� ū ȸ���� �̸��� Ű�� ��ȸ�Ͻÿ�
select name, addr, height,(select avg(height) from usertbl b where a.addr=b.addr group by addr) as ���Ű
from usertbl a
where height >= (select avg(height) from usertbl b where a.addr=b.addr group by addr)
group by name, addr, height
order by height desc, name;

select addr, avg(height)
from usertbl b
group by addr;

-- 2. ��ǰ�� �� ���̶� ������ ���� �ִ� ȸ���� �̸��� �ּҸ� ��ȸ�Ͻÿ�
--    (��, buyTbl�� userID ����)
select distinct name, addr
from usertbl u
join buytbl b
on u.userid = b.userid
where prodname is not null;

-- 3. �����ڡ� �з� ��ǰ �� ���� ��� ��ǰ�� ������ ȸ���� �̸��� ��ǰ��, ������ ��ȸ�Ͻÿ�.
select * from buytbl;
select name, prodname, price
from usertbl u
join buytbl b
on u.userid = b.userid
where price = (
    select max(price)
    from buytbl
    where groupname = '����');
-- ���� ��� ��ǰ ã��
select max(price)
from buytbl
where groupname = '����';

-- 4. �� ȸ���� ������ �� �ݾ�(price �� amount)�� ��պ��� �� ���� ������ ȸ���� �̸��� �� ���� �ݾ��� ��ȸ�Ͻÿ�.
-- group �Լ� �Ұ� ������ �׷��Լ��� ������ �÷��� �ۼ��ϸ� ��
select name, sum(price*amount) as �ѱݾ�
from usertbl u
join buytbl b
on u.userid = b.userid
where price*amount >= (select avg(price*amount) from buytbl)
group by name;

select avg(price*amount)
from buytbl;

-- 5. �� ���� ������ ������ �� ���� ȸ���� �̸��� �������� ��ȸ�Ͻÿ�
select name, mdate
from usertbl u
left join buytbl b
on u.userid = b.userid
where amount is null;

-- 6. û������ ������ ȸ����� ���� ������ ��� �ٸ� ȸ������ �̸��� ������ ��ȸ�Ͻÿ�
--    (��, û������ ������ ����� ����)
select distinct name, addr
from usertbl u
left join buytbl b
on u.userid = b.userid
where u.addr = (
    select u1.addr
    from usertbl u1
    join buytbl b1
    on u1.userid = b1.userid
    where prodname = 'û����' and u.addr=u1.addr
);
-- û���� �������� ���� ��ȸ
select addr
from usertbl u
join buytbl b
on u.userid = b.userid
where prodname = 'û����';

-- 7. �� ȸ���� userID�� �� ȸ���� ������ ���� ��� ��ǰ�� �̸��� ������ ��ȸ�Ͻÿ�
select u.userid,(select prodname from buytbl where price = max(price)),max(price) as �ְ�
from usertbl u
join buytbl b
on u.userid = b.userid
group by u.userid;
-- ��� ������ �̸� ��ȯ
select prodname
from buytbl a
where price=(select max(price) from buytbl b group by prodname);

select max(price) from buytbl group by prodname;

-- 