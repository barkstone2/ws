

create table member(
id nvarchar2(50) not null primary key,
pw nvarchar2(50) not null,
name nvarchar2(50) not null,
addr nvarchar2(50) not null,
bAddr nvarchar2(50) not null,
sAddr nvarchar2(50) not null
);

select * from member;