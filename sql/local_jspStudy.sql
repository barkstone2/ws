user jspStudy
identified by 1234;

grant connect, resource, dba to jspStudy;

create table member (
no number not null,
id nvarchar2(50) not null,
pw nvarchar2(50) not null,
name nvarchar2(50) not null,
gender nvarchar2(50) not null check(gender in('남자','여자')),
bornYear number not null,
regi_date timestamp default current_timestamp not null,
postcode nvarchar2(50) not null,
bAddr nvarchar2(100) not null,
sAddr nvarchar2(100) not null,
refAddr nvarchar2(100) not null,
primary key(id),
unique(no)
);

alter table member add(postcode nvarchar2(50) default 0 not null);
alter table member add(bAddr nvarchar2(100) default 0 not null);
alter table member add(sAddr nvarchar2(100) default 0 not null);
alter table member add(refAddr nvarchar2(100) default 0 not null);

create sequence seq_member;
select * from member;


create table memo(
no number not null,
id nvarchar2(50) not null,
content clob not null,
regi_date timestamp default current_timestamp not null,
primary key(no)
);

create sequence seq_memo;


select id from member where id='test';

select * from 
(select rownum rn, a.* from 
(select * from member order by no desc) a) where rn between 2 and 4;

select count(*) from memo where no > 0;
commit;

create table guestbook(
no number not null,
name nvarchar2(50) not null,
email nvarchar2(50) not null,
passwd nvarchar2(50) not null,
content clob not null,
regi_date date default sysdate,
primary key(no)
);

create sequence seq_guestbook;

select * from guestbook;


create table survey(
no number not null,
question varchar2(4000) not null,
ans1 nvarchar2(500) not null,
ans2 nvarchar2(500) not null,
ans3 nvarchar2(500) not null,
ans4 nvarchar2(500) not null,
status nchar(1) default '1' check(status in('0','1'))  not null,
start_date timestamp default current_timestamp not null,
end_date timestamp default current_timestamp not null,
regi_date timestamp default current_timestamp not null,
primary key(no)
);

create sequence seq_survey;


create table survey_answer(
answer_no number not null primary key,
no number not null references survey(no),
answer number not null,
regi_date timestamp default current_timestamp not null
);

create sequence seq_answer;


select * from survey;
select a.no, a.question, a.ans1, a.ans2, a.ans3, a.ans4, a.status, a.start_date, a.end_date, a.regi_date, 
(select count(*) from survey_answer where a.no=no) survey_counter
from survey a order by no desc;

select * from survey_answer;

select * from survey where start_date>='21/01/24' and end_date <='21/03/25';
select * from survey;
select * from 
(select rownum rn, a.* 
from (select a.no, a.question, a.ans1, a.ans2, a.ans3, a.ans4, a.status, a.start_date, a.end_date, a.regi_date, 
(select count(*) from survey_answer where a.no=no) survey_counter from survey a where order by no desc) a) 
where rn between 1 and 15 and question like '%테스트%';


select rownum , a.* 
from (select a.no, a.question, a.ans1, a.ans2, a.ans3, a.ans4, a.status, a.start_date, a.end_date, a.regi_date, 
(select count(*) from survey_answer where a.no=no) survey_counter from survey a order by no desc) a 
where question like '%테스트%' and rownum between 1 and 10;


select count(*) from survey where current_timestamp between start_date and end_date;

select rownum rn, a.* 
from (select a.no, a.question, a.ans1, a.ans2, a.ans3, a.ans4, a.status, a.start_date, a.end_date, a.regi_date, 
(select count(*) from survey_answer where a.no=no) survey_counter 
from survey a) a where no > 0 and start_date>=to_timestamp('2021-01-24 00:00:00.0') 
and end_date<=to_timestamp('2021-01-28 23:59:59.9') order by no desc

select * from survey where end_date<=to_timestamp('2021-01-28 23:59:59.9');
select * from survey order by end_date desc, regi_date desc;

select * from survey_answer;

select rownum rn, a.* 
from (select a.no, a.question, a.ans1, a.ans2, a.ans3, a.ans4, a.status, a.start_date, a.end_date, a.regi_date, 
(select count(*) from survey_answer where a.no=no) survey_counter 
from survey a) a where a.no=16

select count(*) from survey_answer where no=16 group by answer;
select * from survey_answer where no=16


select rownum rn, b.*, c.* 
from (select a.no, a.question, a.ans1, a.ans2, a.ans3, a.ans4, a.status, a.start_date, a.end_date, a.regi_date, 
(select count(*) from survey_answer where a.no=no) survey_counter, 
from survey a) b, v_ansCount as c where c.no=b.no


select rownum rn, tb.*
from 
(select a.no, a.question, a.ans1, a.ans2, a.ans3, a.ans4, a.status, a.start_date, a.end_date, a.regi_date, 
(select count(*) from survey_answer where no=a.no) survey_counter, b.ans1c, b.ans2c, b.ans3c, b.ans4c 
from survey a, v_ansCount b where a.no=b.no(+)) tb where tb.no=16

select count(*) from survey_answer where no=1
select * from survey_answer;

select a.*, b.ans1c from survey a, v_ansCount b where a.no=b.no(+);
select ans1c from v_ansCount where no=16;

select * from v_ansCount where no=16;
create or replace view v_ansCount as
select * 
from (
select answer, no 
from survey_answer
)
pivot(
count(*)
for answer in(1 as ans1c, 2 as ans2c, 3 as ans3c ,4 as ans4c)
);


select rownum rn, a.* 
from (select a.no, a.question, a.ans1, a.ans2, a.ans3, a.ans4, a.status, a.start_date, a.end_date, a.regi_date, 
(select count(*) from survey_answer where a.no=no) survey_counter 
from survey a) a

select * from survey_answer;

ALTER TABLE survey_answer ADD CONSTRAINT answer CHECK(answer in(1,2,3,4));



select * from survey where status=0 or current_timestamp > end_date;
select * from survey_answer;

drop table board;
create table board(
bNo number not null,
bSubject nvarchar2(200) not null,
bWriter nvarchar2(200) not null,
bContent clob not null,
bRegiDate timestamp default current_timestamp not null,
bSecretChk number default 0 not null check(bSecretChk in(0,1)),
bPasswd nvarchar2(100) not null,
bGroupNo number not null,
bStepNo number default 0 not null,
bParentNo number default 0
);

create sequence seq_board;



create or replace view view_maxGroupNo as
select nvl(max(bGroupNo),0)+1 bGroupNo from board;

select * from view_maxGroupNo;
    

create table board_reply(
rNo number not null,
bNo number not null,
rWriter nvarchar2(200) not null,
rContent nvarchar2(200) not null,
rRegiDate timestamp default current_timestamp not null,
rGroupNo number not null,
rStepNo number default 0 check(rStepNo in(0,1)) not null 
);


select * from board;

