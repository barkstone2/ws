
create table board (
no number not null primary key,
num number not null,
writer varchar2(50) not null,
subject varchar2(50) not null,
content clob not null,
email varchar2(50),
pw varchar2(50) not null,
refNo number not null,
stepNo number not null,
levelNo number not null,
hit number default 0 not null,
regiDate date default sysdate not null
);

create sequence seq_board
start with 1
increment by 1
minvalue 1;

SELECT REPLACE(content, CHR(13)||CHR(10), '\n') from board;

select no, num, writer, subject,
(SELECT REPLACE(content, CHR(13)||CHR(10), '\n') from board where no=?) as content,
email,pw,refno,stepno,levelno,hit
from board where no=?;

select * from board order by no;
select max(num) from board;
commit;

alter table board add ivc number default 0 not null;

select max(num) from board;
