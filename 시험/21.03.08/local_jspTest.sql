
create table board(
no number primary key not null,
name NVARCHAR2(100) not null,
TITLE NVARCHAR2(100) not null,
CONTENT NVARCHAR2(1000) not null,
PWD NVARCHAR2(100) not null,
REGDATE timestamp default current_timestamp not null
);

create sequence seq_board;