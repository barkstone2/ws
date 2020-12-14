
drop table member;

create table member (
no number not null unique,
id varchar2(50) not null primary key,
pw varchar2(50) not null,
name varchar2(50) not null,
phone varchar2(50) not null,
email  varchar2(50) not null,
birth number not null,
jDate date default sysdate,
state number default 0 not null
);

create sequence seq_mem
start with 1
increment by 1
minvalue 1;

alter table member
add state number default 0 not null;
commit;

select * from member where id='hong' and (state=0 or state=1);

select * from member order by no;


alter table member
rename column memberstate to state;
