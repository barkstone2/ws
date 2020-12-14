
drop table memberdb;

create table memberDB(
id varchar2(50) not null primary key,
pw varchar2(50) not null,
name varchar2(50) not null,
gender varchar2(50) not null,
birth number not null,
phone varchar2(50) not null,
email varchar2(50) not null unique,
addr varchar2(50) not null,
jDate date default sysdate not null,
invalidCheck number default 0 not null
);

select * from memberdb;
commit;