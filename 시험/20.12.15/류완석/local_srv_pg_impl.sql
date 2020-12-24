
create table member (
id varchar2(50) not null,
pwd varchar2(50) not null,
name varchar2(50) not null,
phone varchar2(50) not null,
job varchar2(50) not null
);

select * from member;

create table product(
no number not null primary key,
cate varchar2(50) not null,
pname varchar2(50) not null,
price number not null
);

create sequence seq_product
start with 1
increment by 1
minvalue 1;

select * from product;


create table sj(
name varchar2(50) not null,
sname varchar2(50) not null,
mun_1 number not null,
mun_2 number not null,
mun_3 number not null,
mun_4 number not null,
mun_5 number not null,
mun_ox_1 varchar2(5) not null,
mun_ox_2 varchar2(5) not null,
mun_ox_3 varchar2(5) not null,
mun_ox_4 varchar2(5) not null,
mun_ox_5 varchar2(5) not null,
jumsu number not null
);

