

create table member(
no number unique not null,
id varchar2(10) primary key not null,
passwd varchar2(250) not null,
name varchar2(15) not null,
gender varchar2(1) not null check (gender in('M','F')),
bornYear number not null,
regiDate timestamp default current_timestamp not null
);

create sequence seq_member
start with 1
increment by 1
minvalue 1;

select * from member;