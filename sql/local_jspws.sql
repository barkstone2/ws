
create table member (
no number not null unique,
id varchar2(50) primary key not null,
pw varchar2(50) not null,
name varchar2(50) not null,
nickname varchar2(50) not null,
phone varchar2(50) not null,
email varchar2(50) not null,
addr varchar2(50) not null,
gender varchar2(50) not null check(gender in('M','F')),
job varchar2(50) not null,
grade varchar2(50) not null,
rdate date default sysdate not null,
ip varchar2(50) not null,
loginfailcounter number default 0 not null
);

create sequence seq_member
start with 1
increment by 1
minvalue 1;

update member set grade='1' where id='admin1';
commit;

select * from member;
