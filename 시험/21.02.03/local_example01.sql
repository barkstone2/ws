

create table memo(
no number not null,
id nvarchar2(50) not null,
content clob not null,
regi_date timestamp default current_timestamp not null,
primary key(no)
);

create sequence seq_memo;