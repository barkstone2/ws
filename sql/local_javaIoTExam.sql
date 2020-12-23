
drop table wallpad;

create table wallpad(
aptId varchar2(50) not null,
security  varchar2(50) not null,
light  varchar2(50) not null,
airconditioner  varchar2(50) not null,
television  varchar2(50) not null,
cucu varchar2(50) not null,
regiDate timestamp default current_timestamp
);

alter table wallpad add primary key(aptId);

select * from wallpad;