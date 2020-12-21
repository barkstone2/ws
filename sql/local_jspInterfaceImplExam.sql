

create table resume (
no number not null primary key,
pic varchar2(50) not null,
name varchar2(50) not null,
email varchar2(50) not null,
phone varchar2(50) not null,
address varchar2(50) not null,
TOEIC number,
TOEFL number,
japan number,
china number,
gigan1 varchar2(50),
school1 varchar2(50),
jeongong1 varchar2(50),
gigan2 varchar2(50),
school2 varchar2(50),
jeongong2 varchar2(50),
gigan3 varchar2(50),
school3 varchar2(50),
jeongong3 varchar2(50),
gigan4 varchar2(50),
school4 varchar2(50),
jeongong4 varchar2(50),
wdate date default sysdate
);

create sequence seq_resume
start with 1
increment by 1
minvalue 1;

/*
mysql

create table resume (
no int not null auto_increment primary key,
pic varchar(50) not null,
name varchar(50) not null,
email varchar(50) not null,
phone varchar(50) not null,
address varchar(50) not null,
TOEIC int,
TOEFL int,
japan int,
china int,
gigan1 varchar(50),
school1 varchar(50),
jeongong1 varchar(50),
gigan2 varchar(50),
school2 varchar(50),
jeongong2 varchar(50),
gigan3 varchar(50),
school3 varchar(50),
jeongong3 varchar(50),
gigan4 varchar(50),
school4 varchar(50),
jeongong4 varchar(50),
wdate date default now()
);
*/


select * from resume;
update resume set pic='2.jpg' where no='2';
commit;
