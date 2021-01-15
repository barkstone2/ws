drop table memo;
create table memo(
no number not null,
writer nvarchar2(50) not null,
content clob not null,
regi_date timestamp default current_timestamp
);
alter table memo add primary key(no);
create sequence seq_memo;

select * from memo;