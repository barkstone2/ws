
drop table member;

create table member (
no number not null unique,
id varchar2(50) not null primary key,
pw varchar2(50) not null,
name varchar2(50) not null,
sid varchar2(50) not null,
phone varchar2(50) not null,
email varchar2(50) not null,
gender varchar2(1) not null check(gender in ('M', 'F')),
age number not null,
wdate date default sysdate not null
);

create sequence seq_member
start with 1
increment by 1
minvalue 1;

select * from member;

/*
mysql

create table member (
no int not null auto_increment unique,
id varchar(50) not null primary key,
pw varchar(50) not null,
name varchar(50) not null,
sid varchar(50) not null,
phone varchar(50) not null,
email varchar(50) not null,
gender enum('M', 'F') not null,
age int not null,
wdate date default now() not null
);
*/



