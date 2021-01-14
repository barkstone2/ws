
drop table board;
create table board(
no number not null,
num number not null,
writer varchar2(50) not null,
subject varchar2(50) not null,
content clob not null,  
email varchar2(50) not null,
passwd varchar2(50) not null,
ref number not null,
re_step number not null,
re_level number not null,
parentNo number default 0 not null,
hit number not null,
regi_date timestamp default current_timestamp,
primary key(no)
);

create sequence seq_board
start with 1
increment by 1
minvalue 1;

select * from board order by no, ref, re_level desc;
delete from board where no='22';
commit;

select * from board;

select count(ROWNUM) from board;
drop sequence seq_board;
drop table board;
commit;


begin
for i in 1 .. 1000 loop
insert into board values
(seq_board.nextval, i, i, i, i, i, i, 1,1,1,default,0,default);
end loop;
end;

begin
for i in 1 .. 1000 loop
insert into board values
(seq_board.nextval, i, 'w'||i, 's'||i, 'c'||i, 'e'||i, 'p'||i, i,1,1,default,0,current_timestamp);
end loop;
commit;
end;

delete from board;
select * from board;

select rownum, A.* from (select * from board) A where rownum <=2 order by no, ref, re_level desc;



create table transactionTBL (
no number not null,
name varchar2(50) not null,
regi_date timestamp default current_timestamp
);

select count(*) from transactiontbl;
select max(rownum) from transactiontbl;
drop table transactiontbl;
rollback;


select rn, A.no, A.ref, A.re_level, A.subject, A.writer, A. regi_date 
from (select rownum as rn, no, ref, re_level, subject, writer, regi_date from board order by no desc) A 
where A.rn >=21 and A.rn <=30 order by no, ref, re_level desc;

select rownum as rn, no, ref, re_level, subject, writer, regi_date from board order by no desc;

select * from 
(select rownum as rn, A.* from 
(select no, ref, re_level, subject, writer, regi_date from board where subject like '%s90%' order by ref desc, re_level asc) A) 
where rn >=1 and rn <=10;


select * from board where subject like '%s90%';
select count(rownum) from board where writer like '%w%';


select a.val1 - b.val2 from 
(select max(re_level) val1 from board where ref=1000) a,
(select re_level val2 from board where no=1) b;

select * from board where ref=1000;


(select count(*) cc from board,(select parentNo from board) a where a.parentNo=no);

select b.*, 
(select count(*) from board b1 where b1.no=
(select parentNo from board))
from board b 
where ref=1000;

select a.*, (select count(*) from (select parentNo from board) b 
where b.parentNo=a.no) childCount from board a where ref=1000 order by ref desc, re_level asc;

select a.*, (select count(*) from board where parentNo=a.no) childCount
from board a order by ref desc, re_level asc;



select * from board where parentNo=1008;

create or replace view rnBoard
as
select rownum rn, A.* 
from (select * from board order by ref desc, re_level asc) A;




select rownum rn, A.* 
from (select * from board order by ref desc, re_level asc) A;

select * from (select b.*, LAG(no) over(order by ref desc, re_level asc),
Lead(no) over(order by  ref desc, re_level asc) from Board b order by ref desc, re_level asc)
where no=1000;

select b.* from rnBoard b where no=1000
or rn=((select rn from rnboard where no=1000)+1)
or rn=((select rn from rnboard where no=1000)-1) 
order by rn asc;




(select rownum, A.* from board A order by ref desc, re_level asc);
select * from board order by ref desc;

select *
from (select ref, 
decode (to_char(re_step),'1','원글','2','첫번째 답글','3','두번째 답글','4','세번째 답글','5','네번째 답글') rs 
from board where ref>995)
pivot(
    count(rs)
    for
    rs in ('원글','첫번째 답글','두번째 답글','세번째 답글','네번째 답글')
)
order by ref desc;

/*
21/01/12 설문조사 테이블
*/

create table survey(
no number not null, --일련번호
question varchar2(4000) not null, -- 질문
select1 varchar2(500) not null, --선택내용1
select2 varchar2(500) not null, --선택내용2
select3 varchar2(500) not null, --선택내용3
select4 varchar2(500) not null, --선택내용4
status char(1) default '0', --서비스여부(0-안함, 1-함)
primary key(no)
);

ALTER TABLE survey modify status varchar(2) default '0';

create table survey_answer(
no number not null,
survey_no number not null,
survey_answer number not null,
primary key(no),
foreign key(survey_no) references survey(no)
);

create sequence seq_survey;
create sequence seq_survey_answer;

select * from survey;
update survey set status='0' where no='2';
commit;
select * from survey_answer;

select a.no, a.question, a.select1, a.select2, a.select3, a.select4, 
(select count(*) FROM survey_answer where survey_answer='1' and survey_no=a.no)AS c1,
(select count(*) from survey_answer where survey_answer='2' and survey_no=a.no)as c2, 
(select count(*) from survey_answer where survey_answer='3' and survey_no=a.no)as c3, 
(select count(*) from survey_answer where survey_answer='4' and survey_no=a.no)as c4 
from survey a order by a.no;



select a.no, a.question, a.select1, a.select2, a.select3, a.select4, b.c1, b.c2, b.c3, b.c4  
from survey a,
(select * from view_ans 
pivot(count(*) for answer in('c1'as c1,'c2'as c2,'c3'as c3,'c4'as c4)) order by survey_no) b 
where b.survey_no=a.no
order by a.no;



select * 
FROM (
select survey_no 
from survey_answer 
pivot(count(*) for survey_answer in('1','2','3','4');


select * from survey_answer 
pivot(count(no) for survey_answer in(1,2,3,4)) order by survey_no;

select survey_no, decode(survey_answer, 1, 'c1',2,'c2',3,'c3',4,'c4') from survey_answer;

select * from view_ans 
pivot(count(*) for answer in('c1'as c1,'c2'as c2,'c3'as c3,'c4'as c4)) order by survey_no;

drop view view_ans;
create or replace view view_ans
as
select survey_no, decode(survey_answer, 1, 'c1',2,'c2',3,'c3',4,'c4')answer from survey_answer;

select * from view_ans;


create or replace view view_ansCount
as
select * from (select survey_no, decode(survey_answer, 1, 'c1',2,'c2',3,'c3',4,'c4')answer from survey_answer) 
pivot(count(*) for answer in('c1'as c1,'c2'as c2,'c3'as c3,'c4'as c4)) order by survey_no;

select * from view_anscount;

select a.no, a.question, a.select1, a.select2, a.select3, a.select4, b.c1, b.c2, b.c3, b.c4  
from survey a, view_anscount b 
where b.survey_no=a.no
order by a.no;

/*
21/01/14 방명록 테이블
*/

drop table guestbook;

create table guestbook(
no number not null,
name nvarchar2(50) not null,
email nvarchar2(50) not null,
passwd nvarchar2(50) not null,
content clob not null,
write_date timestamp default current_timestamp
);

drop sequence seq_gBook;

create sequence seq_gBook
start with 1
increment by 1
nomaxvalue nocache;


/*
21/01/14 이력서 파일 첨부 기능
테이블은 jspinterfaceExam에서 쓰던 것 재활용
*/

create table resume (
no number not null primary key,
pic varchar2(50) not null,
name varchar2(50) not null,
email varchar2(50) not null,
phone varchar2(50) not null,
address varchar2(50) not null,
TOEIC number,
TOEFL number,
japan number,
china number,
gigan1 varchar2(50),
school1 varchar2(50),
jeongong1 varchar2(50),
gigan2 varchar2(50),
school2 varchar2(50),
jeongong2 varchar2(50),
gigan3 varchar2(50),
school3 varchar2(50),
jeongong3 varchar2(50),
gigan4 varchar2(50),
school4 varchar2(50),
jeongong4 varchar2(50),
wdate date default sysdate
);

create sequence seq_resume
start with 1
increment by 1
minvalue 1;


select * from resume;
delete from resume;
commit;