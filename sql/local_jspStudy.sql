create user jspStudy
identified by 1234;

grant connect, resource, dba to jspStudy;

create table member (
no number not null,
id nvarchar2(50) not null,
pw nvarchar2(50) not null,
name nvarchar2(50) not null,
gender nvarchar2(50) not null check(gender in('남자','여자')),
bornYear number not null,
regi_date timestamp default current_timestamp not null,
postcode nvarchar2(50) not null,
bAddr nvarchar2(100) not null,
sAddr nvarchar2(100) not null,
refAddr nvarchar2(100) not null,
primary key(id),
unique(no)
);

alter table member add(postcode nvarchar2(50) default 0 not null);
alter table member add(bAddr nvarchar2(100) default 0 not null);
alter table member add(sAddr nvarchar2(100) default 0 not null);
alter table member add(refAddr nvarchar2(100) default 0 not null);

create sequence seq_member;
select * from member;


create table memo(
no number not null,
id nvarchar2(50) not null,
content clob not null,
regi_date timestamp default current_timestamp not null,
primary key(no)
);

create sequence seq_memo;


select id from member where id='test';

select * from 
(select rownum rn, a.* from 
(select * from member order by no desc) a) where rn between 2 and 4;

select * from memo order by no desc;
commit;
