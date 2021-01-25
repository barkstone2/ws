create user jspStudy
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
(select count(*) from survey_answer where a.no=no) survey_counter from survey a order by no desc) a) 
where rn between 1 and 15 and question like '%테스트%';
