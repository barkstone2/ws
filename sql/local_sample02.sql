
drop table test01;

create table member (
id varchar2(50) not null primary key,
pwd varchar2(50) not null,
name varchar2(50) not null,
mobile varchar2(50) not null,
age number not null
);

select * from tab;
desc test01;

select * from test01;

drop table product;

create table product(
pnum number not null primary key,
pname varchar2(50) not null,
pprice number not null,
pjaego number not null,
pcompany varchar2(50) not null
);

create table buy (
ordernum number not null primary key,
pnum number not null,
id varchar2(50) not null,
buynum number not null,
foreign key(pnum) references product(pnum),
foreign key(id) references member(id)
);


insert into member values('hong', '1234', '홍길동', '010-1111-1111', '19');
insert into member values(	'lee',	'1234',	'이성순',	'010-2222-2222',	'21'	);
insert into member values(	'jang',	'1234',	'장천용',	'010-3333-3333',	'32'	);
insert into member values(	'jung',	'1234',	'정원겸',	'010-4444-4444',	'51'	);

select * from member;

commit;

insert into product values(	'1',	'소주',	'1500',	'100',	'진로'	);
insert into product values(	'2',	'맥주',	'2000',	'100',	'하이트'	);
insert into product values(	'3',	'막걸리',	'2500',	'100',	'금정'	);
insert into product values(	'4',	'양주',	'3000',	'100',	'발렌타인'	);
insert into product values(	'5',	'와인',	'5000',	'100',	'1988'	);

commit;

insert into buy values(	'1',	'5',	'lee',	'5'	);
insert into buy values(	'2',	'3',	'hong',	'1'	);
insert into buy values(	'3',	'1',	'jung',	'15'	);
insert into buy values(	'4',	'2',	'jang',	'10'	);
insert into buy values(	'5',	'5',	'hong',	'2'	);

commit;

select m.name, p.pname, b.buynum
from member m
    inner join buy b
    on m.id = b.id
    inner join product p
    on p.pnum = b.pnum
where m.name = '홍길동';


select * from member;

update member set
mobile = '01044444444',
age = '8'
where id = 'jung';
commit;

select * from member;

delete FROm buy
where ordernum = '4';

delete from member;

select * from member;


create table aaa (
no number not null primary key,
name varchar2(50) not null,
addr varchar2(50) not null
);

create sequence seq_aaa start with 1 increment by 1
minvalue 1;

insert into aaa values (seq_aaa.nextval, '홍길동1', '경기1');
insert into aaa values (seq_aaa.nextval, '홍길동2', '경기2');
insert into aaa values (seq_aaa.nextval, '홍길동3', '경기3');
insert into aaa values (seq_aaa.nextval, '홍길동4', '경기4');
insert into aaa values (seq_aaa.nextval, '홍길동5', '경기5');

select * from aaa;

alter table aaa add vend_phone varchar2(20);

alter table aaa modify addr varchar2(100);
alter table aaa rename column addr to address;
alter table aaa drop column vend_phone;

truncate table bbbb;
select * from bbbb;



create table bbbb (
id varchar2(10) primary key,
name varchar2(15) not null,
location varchar2(50)
);

insert into bbbb values('hong1', '홍길동', '서울');
savepoint a;
insert into bbbb values('hong2', '홍길동', '부산');
savepoint b;
insert into bbbb values('hong3', '홍길동', '인천');
select * from bbbb;
rollback to a;
select * from bbbb;


/*
primary key : 중복 X, NN
foreign key
unique : 중복X, null
check
    check(phone like '3429-%') 전화번호가 3429-로 시작해야 된다는 뜻.
    check(gender, 'M', 'F')
*/



create or replace procedure Proc_bbbb
    (
        p_id in bbbb.id%type,
        p_name in bbbb.name%type,
        p_location in bbbb.location%type
    )
    is
    begin
        insert into bbbb values(p_id, P_name, p_location);
        commit;
    end;



execute proc_bbbb('hong','홍길동','대구');
execute proc_bbbb('lee','이성순','서울');

select * from bbbb;
truncate table bbbb;

select * from tab;


-- 서브 쿼리문으로 부서 테이블의 구조와 데이터 복사하기.
create table departments_second
as
    select * from hr.departments;
    
select * from departments_second;


create table ccc
as
    select * from hr.employees e
    where e.department_id = '20';

select * from ccc;

--부서 테이블의 구조만 복사하기
create table dept_third
as
    select department_id, department_name
    from hr.departments
    where 0 = 1;





