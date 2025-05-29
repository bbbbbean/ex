select * from tbl_user;

-- tbl_order ���̺�
CREATE TABLE tbl_order (
  product_id  VARCHAR2(100) PRIMARY KEY,   -- ��ǰ ID
  userid    VARCHAR2(100) NOT NULL,     -- ����� ID (FK)
  product_name VARCHAR2(200) NOT NULL,     -- ��ǰ��
  category   VARCHAR2(100) NOT NULL,     -- ǰ��
  price     NUMBER(10, 2) NOT NULL,     -- ��ǰ ����
  quantity   NUMBER(5) NOT NULL,       -- �ֹ� ����
  order_date  DATE DEFAULT SYSDATE,      -- �ֹ� ��¥
  CONSTRAINT fk_order_user FOREIGN KEY (userid) -- ���� ����
    REFERENCES tbl_user(userid) -- �⺻ Ű���� �ִ� ���̺�
    ON DELETE CASCADE -- �⺻ Ű���� �����Ǹ� �ܷ�Ű�� ��� ����
);
desc tbl_order;


-- aaa�� �ֹ�
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P021', 'aaa', '�޸��� �漮', '��Ȱ��ǰ', 15000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P022', 'aaa', '������Ʈ ���� �Ȱ�', '�׼�����', 22000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));


-- bbb�� �ֹ�
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P023', 'bbb', '����Ʈ ��ġ ������', '���ڱ��', 17000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P024', 'bbb', 'USB ��ǳ��', '��Ȱ��ǰ', 13000, 2, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P025', 'bbb', '���̹� ����', '���ڱ��', 59000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));


-- ccc�� �ֹ�
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P026', 'ccc', '������ĵ���� �����', '���ڱ��', 198000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P027', 'ccc', 'CŸ�� ���', '���ڱ��', 35000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P028', 'ccc', '���콺 �ո� ��ȣ��', '�׼�����', 9000, 2, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P029', 'ccc', '����Ʈ ü�߰�', '���ڱ��', 42000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P030', 'ccc', '���� ����̹� ��Ʈ', '��Ȱ��ǰ', 68000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));


-- aaa�� �ֹ�
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P031', 'aaa', '���� ���� �е�', '���ڱ��', 28000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P032', 'aaa', '����ũ Ŭ�� ��ǳ��', '��Ȱ��ǰ', 17000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));


-- bbb�� �ֹ�
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P033', 'bbb', '��Ʈ�� ��ġ��', '�繫��ǰ', 39000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P034', 'bbb', '�ٱ�� ���� ��Ʈ', '�繫��ǰ', 11000, 2, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P035', 'bbb', 'USB LED ����', '���ڱ��', 8000, 3, TO_DATE('2025-04-08', 'YYYY-MM-DD'));


-- ccc�� �ֹ�
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P036', 'ccc', '���̹� ü��', '����', 210000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P037', 'ccc', 'PC ����Ŀ', '���ڱ��', 47000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P038', 'ccc', 'ȭ��Ʈ����', '�繫��ǰ', 32000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P039', 'ccc', '���� �ļ��', '�繫��ǰ', 99000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P040', 'ccc', '������ ���', '�繫��ǰ', 58000, 2, TO_DATE('2025-04-08', 'YYYY-MM-DD'));


-- aaa�� �ֹ�
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P041', 'aaa', '����Ʈ ����', '���ڱ��', 37000, 1, TO_DATE('2025-04-01', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P042', 'aaa', '��Ƽ�� ������', '��Ȱ��ǰ', 22000, 1, TO_DATE('2025-04-03', 'YYYY-MM-DD'));


-- bbb�� �ֹ�
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P043', 'bbb', '���̹� ���콺', '���ڱ��', 52000, 1, TO_DATE('2025-04-02', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P044', 'bbb', '���̽� Ű����', '���ڱ��', 46000, 1, TO_DATE('2025-04-04', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P045', 'bbb', '��Ʈ�� Ŭ���� ��Ʈ', '��Ȱ��ǰ', 9500, 2, TO_DATE('2025-04-05', 'YYYY-MM-DD'));


-- ccc�� �ֹ�
INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P046', 'ccc', '��� ������', '���ڱ��', 19000, 1, TO_DATE('2025-04-06', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P047', 'ccc', '�̴� ����������', '���ڱ��', 129000, 1, TO_DATE('2025-04-07', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P048', 'ccc', '����� ��ħ��', '�繫��ǰ', 27000, 1, TO_DATE('2025-04-08', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P049', 'ccc', '���� ���ڻ���', '���ڱ��', 87000, 1, TO_DATE('2025-04-09', 'YYYY-MM-DD'));

INSERT INTO tbl_order (product_id, userid, product_name, category, price, quantity, order_date)
VALUES ('P050', 'ccc', '����� û�� ŰƮ', '��Ȱ��ǰ', 12000, 2, TO_DATE('2025-04-10', 'YYYY-MM-DD'));

commit;

alter table tbl_user add addr varchar2(100);
select * from tbl_user;
update tbl_user set addr='�뱸' where userid='aaa';
update tbl_user set addr='�뱸' where userid='ccc';
update tbl_user set addr='��õ' where userid='bbb';
update tbl_user set addr='���' where userid='ddd';
update tbl_user set addr='����' where userid='eee';

select * from tbl_order;

select category, sum(price*quantity)
from tbl_order
group by category
having sum(price*quantity)>=50000
order by sum(price*quantity) desc;

select order_date,round(avg(price*quantity),2)  -- ����� 2�ڸ��� ������ ǥ��
from tbl_order
group by order_date;

select *
from tbl_user
join tbl_order
on tbl_user.userid=tbl_order.userid;

-- �������� ���� ��
select tbl_user.userid, addr, quantity
from tbl_user
left outer join tbl_order
on tbl_user.userid=tbl_order.userid
where tbl_order.userid is null;

-- ������ �� > ������ ���� �Ѿ�
select addr, order_date, sum(price*quantity)
from tbl_user
join tbl_order
on tbl_user.userid=tbl_order.userid
group by addr, order_date
order by addr, sum(price*quantity) desc;
