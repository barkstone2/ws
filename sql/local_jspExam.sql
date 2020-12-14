

create table student (
sid varchar2(50) not null primary key,
sname varchar2(50) not null,
sphone varchar2(50) not null,
pname varchar2(50) not null,
pphone varchar2(50) not null,
addr varchar2(50) not null,
hakyun varchar2(50) not null
);

drop table score;
create table score (
no number not null primary key,
hakyun varchar2(50) not null,
testType varchar2(50) not null,
kor number not null,
eng number not null,
mat number not null,
sci number not null,
his number not null,
tot number not null,
avg number not null,
sid varchar2(50) not null,
foreign key(sid) REFERENCES student(sid) on delete cascade
);

create sequence seq_score
start with 1
increment by 1
minvalue 1;

select * from score;
commit;

delete student where sid='hong4';
commit;

create table product (
pno number not null primary key,
pName varchar2(50) not null,
pPrice number not null,
salePrice number not null
);

create sequence seq_product
start with 1
increment by 1
minvalue 1;

select * from product;

alter table product modify(salePrice number not null);

