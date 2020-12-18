
drop table member;

create table member (
no number not null unique,
id varchar2(50) not null primary key,
pw varchar2(50) not null,
name varchar2(50) not null,
phone varchar2(50) not null,
job varchar2(50) not null
);

create sequence seq_member
start with 1
increment by 1
minvalue 1;

/*
mysql

create table member (
no int not null unique auto_increment,
id varchar(50) not null primary key,
pw varchar(50) not null,
name varchar(50) not null,
phone varchar(50) not null,
job varchar(50) not null
);

*/