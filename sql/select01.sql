-- select * from usertbl;
-- ������ �߰�
select * from usertbl;
-- ----------------------
-- where ��
-- �ش� ������ �����ϴ� �� ���
-- �� ������, �� ������ ��� ����
-- ----------------------
select * from usertbl where name='������';
-- ������ + ���迬����
-- �񱳿�����, ��������
select * from usertbl where birthyear >=1970 and height>=182;
select * from usertbl where birthyear >=1970 or height>=182;
-- ���� ���� and ���� : where �� between ~ and ~ ;
select * from usertbl where birthyear >=1970 and birthyear<=1980;
select * from usertbl where birthyear between 1970 and 1980;
-- in : �׷� ����, �� ���� �Ǻ� �� �׷�, �ϳ��� �����ص� ���
select name,height from userTbl where addr in('�泲','����','���');
select * from usertbl where mobile1 in('010','011');
-- like : ���� ���ڿ� �˻�
-- % : ���� ������ ���� ��� ����
-- _ : ����� ��ŭ ������ ��� ����
select name, height from usertbl where name like '%��';
select name, addr, mobile2 from usertbl where name like '_���';
-- null üũ
select name, mobile1, mobile2 from usertbl where mobile2 is null;
select userid, name, mobile1, mobile2 from usertbl where mobile1 is not null;
select * from usertbl where mobile1 is null and mobile2 is null;
-- �ߺ� �� ���� : distinct
select DISTINCT addr from usertbl;
select * from usertbl;
-- ��Ī ���� : alias (as)
-- || ���ڿ� ���ϱ�
select mobile1 || mobile2 as phone from usertbl;

-- ------------------------------
-- ���� Ǯ��
select * from buytbl;
-- 1. amount 5�� �̻� �� ���
select * from buytbl where amount>=5;
-- 2. price 50 �̻� 500 ������ ���� userid, prodname ���
select userid, prodname from buytbl where price between 50 and 500;
-- 3. amount 10 �̻��̰ų� price 100�̻��� �� ���
select * from buytbl where amount>=10 or price>=100;
-- 4. userid�� k�� �����ϴ� �� ��� : ��ҹ��� ����
select * from buytbl where userid like 'K%';
-- 5. �����̰ų� ������ �� ��� : in!!!!
select * from buytbl where groupname in ('����', '����');
-- 6. prodname�� å�̰ų� userid�� w�� ������ �� ���
-- �ڷ��������� ������ ���ڿ� ã�Ⱑ ������� ���� ��,
-- char -> �� ������ trim���� ���� �� ��󳻰ų�
-- �� ���鵵 �����ؼ� ���ڿ� ã��
select * from buytbl where prodname='å' or userid like '__W%';


