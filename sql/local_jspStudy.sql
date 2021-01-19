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
primary key(id),
unique(no)
);

create sequence seq_member;

select * from member;