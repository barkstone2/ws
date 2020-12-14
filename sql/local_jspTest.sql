
drop sequence seq_boss;

create sequence seq_boss
start with 1
increment by 1
minvalue 1;

drop table boss;

create table boss (
no number not null primary key,
banjang varchar2(50) not null,
bubanjang varchar2(50) not null,
boss varchar2(50) not null
);

create sequence seq_classChief
start with 1
increment by 1
minvalue 1;

drop table classChief;

create table classChief (
no number not null primary key,
class1 varchar2(50) not null,
class2 varchar2(50) not null,
class3 varchar2(50) not null,
class4 varchar2(50) not null,
class5 varchar2(50) not null
);

select * from classChief;


create sequence seq_com11st
start with 1
increment by 1
minvalue 1;



create table com11st (
no number not null primary key,
qChoice varchar2(50) not null,
name varchar2(50) not null,
phone varchar2(50) not null,
email varchar2(50) not null,
subj varchar2(50) not null,
content varchar2(200) not null
);


select * from com11st;

drop table joinTBL01;

create table joinTBL01(
id	varchar2(50)	not null	primary key,
pw	varchar2(50)	not null	,
name	varchar2(50)	not null	,
phone	varchar2(50)	not null	,
email	varchar2(50)	not null	,
birth	number	not null	
);

delete joinTBL01;
commit;

select * from joinTBL01;
commit;
rollback;



select * from joinTBL01;










