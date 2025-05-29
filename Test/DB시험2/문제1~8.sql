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

-- tbl_member의 Member_id 에 Primary key 제약 조건 설정하세요(alter 사용)
alter table tbl_member add constraints member_id primary key (member_id);
desc tbl_member;

-- tbl_book의 Book_code에 primary key 제약 조건 설정하세요(alter 사용)
alter table tbl_book add constraints book_code primary key (book_code);
desc tbl_book;

-- tbl_rental의 Book_code 에 Book_Tbl의 Book_code 로 FK 설정하세요(alter 사용), Delete 시 cascade 옵션 적용합니다
alter table tbl_rental
add constraints fk_book_code foreign key (book_code) references tbl_book (book_code)
on delete cascade;
alter table tbl_rental drop constraint fk_book_code;
desc tbl_rental;

-- Rental_tbl 의 Member_id에 Member_tbl의 Member_id로 FK 설정하세요(alter사용), Delete 시 cascade 옵션 적용합니다
alter table tbl_rental
add constraints fk_member_id foreign key (member_id) references tbl_member (member_id)
on delete cascade;
desc tbl_member;

-- 각 테이블에 값 삽입
insert into tbl_member values(111,'aaa','111','일반','대구','010-111-2222');
insert into tbl_member values(222,'bbb','222','VIP','울산','010-111-2222');
insert into tbl_member values(333,'ccc','333','VIP','인천','010-111-2222');
insert into tbl_member values(444,'ddd','444','일반','부산','010-111-2222');
insert into tbl_member values(555,'eee','555','VIP','서울','010-111-2222');
insert into tbl_member values(666,'fff','666','일반','경기','010-111-2222');
select * from tbl_member;

insert into tbl_book values(1010,1,'윤성우','열혈C','오렌지미디어','1');
insert into tbl_book values(1011,1,'남궁성','JAVA의정석','00미디어','1');
insert into tbl_book values(1012,1,'남길동','이것이리눅스다','한빛미디어','1');
insert into tbl_book values(2010,2,'데일카네기','인간관계론','00미디어','1');
insert into tbl_book values(2011,3,'홍길동','미움받을용기','00미디어','1');
select * from tbl_book;

insert into tbl_rental values(1,1010,111);
insert into tbl_rental values(2,1011,222);
insert into tbl_rental values(3,1012,333);
select * from tbl_rental;

-- 제약 조건 사전 확인
select constraint_name, constraint_type, search_condition, r_constraint_name
from user_constraints
where table_name = 'TBL_MEMBER';

select constraint_name, constraint_type, search_condition, r_constraint_name
from user_constraints
where table_name = 'TBL_BOOK';

select constraint_name, constraint_type, search_condition, r_constraint_name
from user_constraints
where table_name = 'TBL_RENTAL';

-- Rental_tbl 의 각 FK열에 Index 를 추가하고 확인
create index fk_book_code on tbl_rental(book_code);
create index fk_member_id on tbl_rental(member_id);
select * from USER_IND_COLUMNS where table_name='tbl_rental';

-- View 테이블 생성 (조인+뷰 사용)
-- 뷰테이블명 : ShowRental_view / JOIN 종류 : Inner Join
-- 책을 대여한 회원에 대한 정보를 표시 / Rental_Id,Member_Name,Book_name 만 표시
create view ShowRental_view
as
    select Rental_Id,Member_Name,Book_name
    from tbl_rental
    join tbl_member
    on tbl_rental.member_id = tbl_member.member_id
    join tbl_book
    on tbl_rental.book_code = tbl_book.book_code;
    
select * from ShowRental_view;
