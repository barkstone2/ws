

create table product(
p_id varchar2(10) not null primary key,
p_name varchar2(30) not null,
p_price number not null,
v_id varchar2(10) not null,
FOREIGN key(v_id) REFERENCES vendor(v_id)
);

create table vendor(
v_id varchar2(10) not null primary key,
v_name varchar2(30) not null,
v_mobile varchar2(50) not null
);

insert into vendor (v_id, v_name, v_mobile)
values('S01','삼성','1500-0101');
insert into vendor (v_id, v_name, v_mobile)
values('L02','LG','1500-0102');
insert into vendor (v_id, v_name, v_mobile)
values('H03','현대','1500-0103');
commit;
select * from vendor;


insert into product (p_id, p_name, p_price, v_id) values('P01','노트북',1000,'S01');
insert into product (p_id, p_name, p_price, v_id) values('P02','공기청정기',2000,'S01');
insert into product (p_id, p_name, p_price, v_id) values('P03','청소기',2000,'L02');
insert into product (p_id, p_name, p_price, v_id) values('P04','에어콘',2500,'L02');
insert into product (p_id, p_name, p_price, v_id) values('P05','그랜저',5000,'H03');
select * from product;


update vendor set v_name='엘지' where v_name='LG';
commit;
select * from vendor;

delete from product where p_name='그랜저';
commit;
select * from product;


select * from product a
where p_price>=2000 and v_id='L02';

select * from product;

delete from product where p_name='공기청정기';
select * from product;
rollback;
select * from product;

create index idx_pname on vendor(v_name);

select * from product;
select * from vendor;

select sum(p_price) as pt from product p where (select v.v_id from vendor v)=p.v_id;

create or replace view v_test as
select v.v_name, v.v_mobile, p.p_name, p.p_price 
from vendor v, product p
where v.v_id=p.v_id;

select * from v_test;


select * from vendor;
select * from product;


select v.v_name, v.v_mobile, 
nvl((select sum(p.p_price) 
        from product p 
        where p.v_id=v.v_id 
        group by p.v_id),0) as priceTotal
from vendor v;


select v.v_name, v.v_mobile, p.p_name, p.p_price
from vendor v
join product p
on v.v_id=p.v_id;


