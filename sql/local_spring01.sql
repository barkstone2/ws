
create table member(
id varchar2(50) not null primary key,
pw varchar2(50) not null,
name varchar2(50) not null,
email varchar2(50),
regDate date default sysdate
);
