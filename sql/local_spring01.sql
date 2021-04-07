
create table member(
id varchar2(50) not null primary key,
pw varchar2(50) not null,
name varchar2(50) not null,
email varchar2(50),
regDate date default sysdate
);

select * from member;

create sequence seq_exam;


create table exam(
no number not null primary key,
name varchar2(50) not null,
jumin varchar2(100) not null,
gender varchar2(50) not null,
age number not null,
regDate timestamp default current_timestamp
);

select * from exam;
