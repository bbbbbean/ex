select * from tbl_vote_202005;
select * from TBL_MEMBER_202005;
select * from TBL_PARTY_202005;

delete from TBL_MEMBER_202005;

INSERT INTO TBL_MEMBER_202005 (M_NO, M_NAME, P_CODE, P_SCHOOL, M_JUMIN, M_CITY)
VALUES ('1', '���ĺ�', 'P1', '1', '660301199991', '����ȭ��');

INSERT INTO TBL_MEMBER_202005 (M_NO, M_NAME, P_CODE, P_SCHOOL, M_JUMIN, M_CITY)
VALUES ('2', '���ĺ�', 'P2', '3', '550301199992', '�ε鷡��');

INSERT INTO TBL_MEMBER_202005 (M_NO, M_NAME, P_CODE, P_SCHOOL, M_JUMIN, M_CITY)
VALUES ('3', '���ĺ�', 'P3', '2', '770301199993', '���Ȳɵ�');

INSERT INTO TBL_MEMBER_202005 (M_NO, M_NAME, P_CODE, P_SCHOOL, M_JUMIN, M_CITY)
VALUES ('4', '���ĺ�', 'P4', '2', '880301199994', '���޷���');

INSERT INTO TBL_MEMBER_202005 (M_NO, M_NAME, P_CODE, P_SCHOOL, M_JUMIN, M_CITY)
VALUES ('5', '���ĺ�', 'P5', '3', '990301199995', '��������');

commit;

select m_no, m_name, p_name,p_school,m_jumin,M_city,p_tel1,p_tel2,p_tel3
from tbl_member_202005
join tbl_party_202005
on tbl_member_202005.p_code=tbl_party_202005.p_code;

select v_name,v_jumin,m_no,v_time,v_confirm
from tbl_vote_202005;

select tbl_member_202005.m_no, m_name, count(tbl_member_202005.m_no)
from tbl_member_202005
join tbl_vote_202005
on tbl_member_202005.m_no = tbl_vote_202005.m_no
where v_confirm = 'Y'
group by tbl_member_202005.m_no, m_name
order by count(tbl_member_202005.m_no) desc;

select * from tbl_vote_202005;
delete from tbl_vote_202005 where v_jumin=2001013333333;
commit;

