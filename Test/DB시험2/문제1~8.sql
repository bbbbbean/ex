create table tbl_member(
    Member_id int,
    Member_name varchar(45),
    Member_identity varchar(45),
    Member_grade varchar(45),
    Member_addr varchar(45),
    Member_phone varchar(45)
);
create table tbl_rental(
    Rental_id int,
    Book_code int,
    Member_id int
);
create table tbl_book(
    Book_code int,
    classification_Id int,
    book_author varchar(45),
    book_name varchar(45),
    publisher varchar(45),
    isrental char(1)
);

-- tbl_member�� Member_id �� Primary key ���� ���� �����ϼ���(alter ���)
alter table tbl_member add constraints member_id primary key (member_id);
desc tbl_member;

-- tbl_book�� Book_code�� primary key ���� ���� �����ϼ���(alter ���)
alter table tbl_book add constraints book_code primary key (book_code);
desc tbl_book;

-- tbl_rental�� Book_code �� Book_Tbl�� Book_code �� FK �����ϼ���(alter ���), Delete �� cascade �ɼ� �����մϴ�
alter table tbl_rental
add constraints fk_book_code foreign key (book_code) references tbl_book (book_code)
on delete cascade;
alter table tbl_rental drop constraint fk_book_code;
desc tbl_rental;

-- Rental_tbl �� Member_id�� Member_tbl�� Member_id�� FK �����ϼ���(alter���), Delete �� cascade �ɼ� �����մϴ�
alter table tbl_rental
add constraints fk_member_id foreign key (member_id) references tbl_member (member_id)
on delete cascade;
desc tbl_member;

-- �� ���̺� �� ����
insert into tbl_member values(111,'aaa','111','�Ϲ�','�뱸','010-111-2222');
insert into tbl_member values(222,'bbb','222','VIP','���','010-111-2222');
insert into tbl_member values(333,'ccc','333','VIP','��õ','010-111-2222');
insert into tbl_member values(444,'ddd','444','�Ϲ�','�λ�','010-111-2222');
insert into tbl_member values(555,'eee','555','VIP','����','010-111-2222');
insert into tbl_member values(666,'fff','666','�Ϲ�','���','010-111-2222');
select * from tbl_member;

insert into tbl_book values(1010,1,'������','����C','�������̵��','1');
insert into tbl_book values(1011,1,'���ü�','JAVA������','00�̵��','1');
insert into tbl_book values(1012,1,'���浿','�̰��̸�������','�Ѻ��̵��','1');
insert into tbl_book values(2010,2,'����ī�ױ�','�ΰ������','00�̵��','1');
insert into tbl_book values(2011,3,'ȫ�浿','�̿�������','00�̵��','1');
select * from tbl_book;

insert into tbl_rental values(1,1010,111);
insert into tbl_rental values(2,1011,222);
insert into tbl_rental values(3,1012,333);
select * from tbl_rental;

-- ���� ���� ���� Ȯ��
select constraint_name, constraint_type, search_condition, r_constraint_name
from user_constraints
where table_name = 'TBL_MEMBER';

select constraint_name, constraint_type, search_condition, r_constraint_name
from user_constraints
where table_name = 'TBL_BOOK';

select constraint_name, constraint_type, search_condition, r_constraint_name
from user_constraints
where table_name = 'TBL_RENTAL';

-- Rental_tbl �� �� FK���� Index �� �߰��ϰ� Ȯ��
create index fk_book_code on tbl_rental(book_code);
create index fk_member_id on tbl_rental(member_id);
select * from USER_IND_COLUMNS where table_name='tbl_rental';

-- View ���̺� ���� (����+�� ���)
-- �����̺�� : ShowRental_view / JOIN ���� : Inner Join
-- å�� �뿩�� ȸ���� ���� ������ ǥ�� / Rental_Id,Member_Name,Book_name �� ǥ��
create view ShowRental_view
as
    select Rental_Id,Member_Name,Book_name
    from tbl_rental
    join tbl_member
    on tbl_rental.member_id = tbl_member.member_id
    join tbl_book
    on tbl_rental.book_code = tbl_book.book_code;
    
select * from ShowRental_view;
