select * from tbl_vote_202005;
select * from TBL_MEMBER_202005;
select * from TBL_PARTY_202005;

delete from TBL_MEMBER_202005;

INSERT INTO TBL_MEMBER_202005 (M_NO, M_NAME, P_CODE, P_SCHOOL, M_JUMIN, M_CITY)
VALUES ('1', '김후보', 'P1', '1', '660301199991', '수선화동');

INSERT INTO TBL_MEMBER_202005 (M_NO, M_NAME, P_CODE, P_SCHOOL, M_JUMIN, M_CITY)
VALUES ('2', '이후보', 'P2', '3', '550301199992', '민들래동');

INSERT INTO TBL_MEMBER_202005 (M_NO, M_NAME, P_CODE, P_SCHOOL, M_JUMIN, M_CITY)
VALUES ('3', '박후보', 'P3', '2', '770301199993', '나팔꽃동');

INSERT INTO TBL_MEMBER_202005 (M_NO, M_NAME, P_CODE, P_SCHOOL, M_JUMIN, M_CITY)
VALUES ('4', '조후보', 'P4', '2', '880301199994', '진달래동');

INSERT INTO TBL_MEMBER_202005 (M_NO, M_NAME, P_CODE, P_SCHOOL, M_JUMIN, M_CITY)
VALUES ('5', '최후보', 'P5', '3', '990301199995', '개나리동');

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

