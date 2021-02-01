
create table member(
no number not null unique,
id nvarchar2(100) not null primary key,
pw nvarchar2(100) not null,
name nvarchar2(100) not null,
gender nvarchar2(2) not null check(gender in('남자','여자')),
bornYear number not null,
postCode nvarchar2(50) not null,
bAddr nvarchar2(100) not null,
sAddr nvarchar2(100) not null,
rAddr nvarchar2(100) not null
);

create sequence seq_member;

alter table member add(regiDate timestamp default current_timestamp);

