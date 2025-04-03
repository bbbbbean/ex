create table tbl_user(
    userid varchar2(100) primary key,
    password varchar2(100) not null,
    role varchar2(100) not null
);

desc tbl_user;
select*from tbl_user;

commit;