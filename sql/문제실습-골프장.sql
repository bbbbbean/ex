select * from TBL_CLASS_202201;
select * from TBL_MEMBER_202201;
select * from TBL_TEACHER_202201;
commit;

select regist_month, TBL_MEMBER_202201.c_no, c_name, teacher_code, class_area, tuition, grade
from TBL_MEMBER_202201
join TBL_CLASS_202201
on TBL_MEMBER_202201.c_no=TBL_CLASS_202201.c_no;

select *
from TBL_MEMBER_202201
join TBL_CLASS_202201
on TBL_MEMBER_202201.c_no=TBL_CLASS_202201.c_no
join tbl_teacher_202201
on TBL_CLASS_202201.teacher_code = tbl_teacher_202201.teacher_code;

select TBL_CLASS_202201.teacher_code, class_name, teacher_name, sum(tuition)
from TBL_CLASS_202201
join TBL_teacher_202201
on TBL_CLASS_202201.teacher_code = tbl_teacher_202201.teacher_code
group by TBL_CLASS_202201.teacher_code, class_name, teacher_name
order by TBL_CLASS_202201.teacher_code;