
drop table member;

create table member(
no number not null unique,
id varchar2(50) not null primary key,
passwd varchar2(50) not null,
name varchar2(50) not null,
nickname varchar2(50) not null,
email varchar2(50) not null,
phone varchar2(50) not null,
address varchar2(50) not null,
gender varchar2(50) not null check(gender in ('M', 'F')),
--gender enum("M","F") not null,
job varchar2(50) not null,
grade varchar2(50) default 4 not null, -- 1:傈眉包府磊 2:惑前包府磊 3:硅价包府磊 4:老馆雀盔
regi_date date default sysdate not null
);

alter table member add unique(no);

create sequence seq_member
start with 1
increment by 1
minvalue 1;

select * from member;

update member SET grade='2' where id='test2';
commit;

alter table member add ip varchar2(50) default 0 not null;
alter table member add loginFailCounter number default 0;