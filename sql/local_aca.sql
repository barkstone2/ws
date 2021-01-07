
drop table board;
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
parentNo number default 0 not null,
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
(seq_board.nextval, i, i, i, i, i, i, 1,1,1,default,0,default);
end loop;
end;

begin
for i in 1 .. 1000 loop
insert into board values
(seq_board.nextval, i, 'w'||i, 's'||i, 'c'||i, 'e'||i, 'p'||i, i,1,1,default,0,current_timestamp);
end loop;
commit;
end;

delete from board;
select * from board;

select rownum, A.* from (select * from board) A where rownum <=2 order by no, ref, re_level desc;



create table transactionTBL (
no number not null,
name varchar2(50) not null,
regi_date timestamp default current_timestamp
);

select count(*) from transactiontbl;
select max(rownum) from transactiontbl;
drop table transactiontbl;
rollback;


select rn, A.no, A.ref, A.re_level, A.subject, A.writer, A. regi_date 
from (select rownum as rn, no, ref, re_level, subject, writer, regi_date from board order by no desc) A 
where A.rn >=21 and A.rn <=30 order by no, ref, re_level desc;

select rownum as rn, no, ref, re_level, subject, writer, regi_date from board order by no desc;

select * from 
(select rownum as rn, A.* from 
(select no, ref, re_level, subject, writer, regi_date from board where subject like '%s90%' order by ref desc, re_level asc) A) 
where rn >=1 and rn <=10;


select * from board where subject like '%s90%';
select count(rownum) from board where writer like '%w%';


select a.val1 - b.val2 from 
(select max(re_level) val1 from board where ref=1000) a,
(select re_level val2 from board where no=1) b;

select * from board where ref=1000;


(select count(*) cc from board,(select parentNo from board) a where a.parentNo=no);

select b.*, 
(select count(*) from board b1 where b1.no=
(select parentNo from board))
from board b 
where ref=1000;

select a.*, (select count(*) from (select parentNo from board) b 
where b.parentNo=a.no) childCount from board a where ref=1000 order by ref desc, re_level asc;

select a.*, (select count(*) from board where parentNo=a.no) childCount
from board a order by ref desc, re_level asc;



select * from board where parentNo=1008;


