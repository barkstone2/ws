
drop table board;

create table board (
no number not null primary key,
num number not null,
writer varchar2(50) not null,
subject varchar2(50) not null,
content clob not null,
email varchar2(50) not null,
pw varchar2(50) not null,
refNo number not null,
stepNo number not null,
levelNo number not null,
hit number not null,
regiDate date default sysdate not null
);
--계층형 게시판(답변형)

create sequence seq_board
start with 1
increment by 1
minvalue 1;

select max(num) from board;
insert into board values(seq_board.nextval, select max(num) from board,'hong','h','h','h@h','1234',num,0,0,0,default);
select * from board;

select rownum, writer from board where no=1;
