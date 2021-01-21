

create table member(
id varchar2(50) not null,
passwd varchar2(50) not null,
changeDate date default sysdate not null,
primary key(id)
);

insert into member values
('hong', '1234', to_date('2020-01-01 13:00:00', 'YYYY-MM-DD HH24:MI:SS'));

insert into member values
('kim', '0987', to_date('2020-07-01 13:00:00', 'YYYY-MM-DD HH24:MI:SS'));

commit;

select * from member where id='hong' and passwd='1234';
select id, passwd, changeDate from member where id='hong' and passwd='1234';
select * from member where id='hong';