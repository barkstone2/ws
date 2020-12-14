

create table student (
sid varchar2(50) not null primary key,
sname varchar2(50) not null,
sphone varchar2(50) not null,
pname varchar2(50) not null,
pphone varchar2(50) not null,
addr varchar2(50) not null,
hakyun varchar2(50) not null
);


create table score (
no number not null primary key,
hakyun varchar2(50) not null,
testType varchar2(50) not null,
kor number not null,
eng number not null,
mat number not null,
sci number not null,
tot number not null,
avg number not null,
sid varchar2(50) not null,
foreign key(sid) REFERENCES student(sid) on delete cascade
);

create sequence seq_score
start with 1
increment by 1
minvalue 1;


