

create table board(
no number not null,
num number not null,
writer varchar2(50) not null,
subject varchar2(50) not null,
content clob not null,  
email varchar2(50) not null,
passwd varchar2(50) not null,
ref number not null,
re_step number not null,
re_level number not null,
hit number not null,
regi_date timestamp default current_timestamp,
primary key(no)
);

create sequence seq_board
start with 1
increment by 1
minvalue 1;

select * from board order by no, ref, re_level desc;
delete from board where no='22';
commit;

select * from board;

select count(ROWNUM) from board;
drop sequence seq_board;
drop table board;
commit;


begin
for i in 1 .. 1000 loop
insert into board values
(seq_board.nextval, i, i, i, i, i, i, 1,1,1,0,default);
end loop;
end;

begin
for i in 1 .. 1000 loop
insert into board values
(seq_board.nextval, i, 'w'||i, 's'||i, 'c'||i, 'e'||i, 'p'||i, i,1,1,0,current_timestamp);
end loop;
commit;
end;

delete from board;
select * from board;

select rownum, A.* from (select * from board) A where rownum <=2 order by no, ref, re_level desc;


