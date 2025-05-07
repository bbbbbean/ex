-- Oracle-compatible SQL script (converted from MySQL Forward Engineering)

-- Member_Tbl
CREATE TABLE Member_Tbl (
  Member_id NUMBER PRIMARY KEY,
  Member_name VARCHAR2(45),
  Member_identity VARCHAR2(45),
  Member_grade VARCHAR2(45),
  Member_addr VARCHAR2(45),
  Member_phone VARCHAR2(45)
);

-- Classification_Tbl
CREATE TABLE Classification_Tbl (
  Classification_Id NUMBER PRIMARY KEY,
  Classification_name VARCHAR2(45)
);

-- Book_Tbl
CREATE TABLE Book_Tbl (
  Book_code NUMBER PRIMARY KEY,
  Classification_Id NUMBER NOT NULL,
  book_author VARCHAR2(45),
  book_name VARCHAR2(45),
  publisher VARCHAR2(45),
  isreserve NUMBER(1),
  CONSTRAINT fk_Book_Classification FOREIGN KEY (Classification_Id)
    REFERENCES Classification_Tbl (Classification_Id)
);

-- Rental_Tbl
CREATE TABLE Rental_Tbl (
  Rental_id NUMBER PRIMARY KEY,
  Book_code NUMBER NOT NULL,
  Member_id NUMBER NOT NULL,
  CONSTRAINT fk_Rental_Member FOREIGN KEY (Member_id)
    REFERENCES Member_Tbl (Member_id),
  CONSTRAINT fk_Rental_Book FOREIGN KEY (Book_code)
    REFERENCES Book_Tbl (Book_code)
);

-- Reserve_Tbl
CREATE TABLE Reserve_Tbl (
  Rental_id NUMBER NOT NULL,
  Member_Id NUMBER NOT NULL,
  Reserve_order VARCHAR2(45) NOT NULL,
  PRIMARY KEY (Rental_id, Member_Id),
  CONSTRAINT fk_Reserve_Member FOREIGN KEY (Member_Id)
    REFERENCES Member_Tbl (Member_id),
  CONSTRAINT fk_Reserve_Rental FOREIGN KEY (Rental_id)
    REFERENCES Rental_Tbl (Rental_id)
);

-- Appendix_Tbl
CREATE TABLE Appendix_Tbl (
  Appendix_id NUMBER PRIMARY KEY,
  Book_code NUMBER NOT NULL,
  Appendix_name VARCHAR2(45),
  CONSTRAINT fk_Appendix_Book FOREIGN KEY (Book_code)
    REFERENCES Book_Tbl (Book_code)
);
select*from Member_Tbl;

insert into Member_Tbl values(12345678,'��','1','2','3','4444');
insert into Member_Tbl values(11111111,'��','5','6','7','8888');
insert into Member_Tbl values(22222222,'��','9','0','1','2222');
insert into Member_Tbl values(11223344,'�豤','1','2','3','4444');
insert into Member_Tbl values(55667788,'�̱�','5','6','7','8888');
insert into Member_Tbl values(99001122,'�ڱ�','9','0','1','2222');
insert into Member_Tbl values(55555555,'�豤��','1','2','3','4444');
insert into Member_Tbl values(66666666,'�̱���','5','6','7','8888');
insert into Member_Tbl values(77777777,'�ڱ���','9','0','1','2222');

insert into Classification_Tbl values(12345678,'a');
insert into Book_Tbl values(11111112,12345678,'a','a','a',1);
insert into Book_Tbl values(11111113,12345678,'a','a','a',1);
insert into Book_Tbl values(11111114,12345678,'a','a','a',1);
insert into Book_Tbl values(11111115,12345678,'a','a','a',1);
insert into Book_Tbl values(11111116,12345678,'a','a','a',1);
insert into Book_Tbl values(11111117,12345678,'a','a','a',1);

insert into Reserve_Tbl values(11111111,12345678,1234);

insert into Rental_Tbl(Rental_id,Book_code,Member_id)values(12345678,11111112,12345678);
insert into Rental_Tbl(Rental_id,Book_code,Member_id)values(11111111,11111113,12345678);
insert into Rental_Tbl(Rental_id,Book_code,Member_id)values(22222222,11111114,12345678);



select*from Rental_Tbl;

SELECT * FROM Member_Tbl;
SELECT * FROM Classification_Tbl;
SELECT * FROM Book_Tbl;
SELECT * FROM Rental_Tbl;
SELECT * FROM Reserve_Tbl;
SELECT * FROM Appendix_Tbl;

select * from Member_Tbl where member_id='12345678';

select*from Rental_Tbl;

delete from Member_Tbl;
delete from Classification_Tbl;
delete from Book_Tbl;
delete from Rental_Tbl;
delete from Reserve_Tbl;
delete from Appendix_Tbl;

commit;


-- ���� �м� �ڵ�
-- Ʈ���̽� ���� �ĺ��� ���� : ���� ���ϸ� �ش� �ĺ��ڰ� �߰��Ǿ� ����
ALTER SESSION SET tracefile_identifier = '_bookUser_';
-- ���� ����
ALTER SESSION SET sql_trace = TRUE;
-- � ������ ���� ���� �Ұ���
-- �������� ������ ������ �ٸ� 12�� ���� ���� ���� : ���ε� ���� + ��� �̺�Ʈ
ALTER SESSION SET EVENTS '10046 trace name context forever, level 12';
-- �Ʒ� �ڵ� ó�� ��� Ȯ�� ����
select * from usertbl where emeber_id='12345678';
-- ���� �ߴ�, ��
ALTER SESSION SET sql_trace = FALSE;
-- ���� Ȯ��
-- Ʈ���̽� ���� ��� Ȯ�� ����
-- �̰� �־�� `C:\ORACLEXE\APP\ORACLE\diag\rdbms\xe\xe\trace\xe_ora_3276__TEST2_.trc` �̷� ��ΰ� ����
SELECT VALUE FROM v$diag_info;