
/*
ȸ���� ���θ�
ȸ���� ���Ű���
member -- ȸ��
    memberId varchar2(50) NN, PK
    memberPw varchar2(50) NN
    memberName varchar2(50) NN
    memberPhone varchar2(50) NN
    memberAddr varchar2(50) NN
    memberDate date NN, default sysdate
    
product -- ��ǰ
    productId varchar2(50) NN, PK
    productName varchar2(50) NN
    productPrice number NN
    productCompany varchar2(50) NN -- ������
    productMadeFrom varchar2(50) NN -- ������
    
buy -- ����
    buyCode varchar2(50) NN PK -- �ֹ���ȣ
    memberId varchar2(50) FK NN
    productID varchar2(50) FK NN
    buyPrice number NN -- �ܰ�
    buyCount number NN -- ���Ű���
    buyTotal number NN -- �ѱ��ž�
    buyDate date NN default sysdate-- ��������
     
stock -- ���
    stockCode varchar2(50) NN PK -- �Ϸù�ȣ
    productId varchar2(50) FK NN
    stockCount number NN -- ����
    stockCycle date NN -- �������
    stockIndate date NN default sysdate -- �԰���
    stockLocation varchar2(50) NN -- �����ġ
*/
drop table member CASCADE CONSTRAINTS;
drop table product CASCADE CONSTRAINTS;
drop table buy cascade CONSTRAINTS;
drop table stock cascade CONSTRAINTS;

create table member (
    memberId varchar2(50) Not Null primary key,
    memberPw varchar2(50) Not Null,
    memberName varchar2(50) Not Null,
    memberPhone varchar2(50) Not Null,
    memberAddr varchar2(50) Not Null,
    memberDate date default sysdate not null
);


create table product (
    productId varchar2(50) primary key not null,
    productName varchar2(50) not null,
    productPrice number not null,
    productCompany varchar2(50) not null, -- ������
    productMadeFrom varchar2(50) not null, -- ������
    productcount number not null -- ����
);

alter table product add productcount number not null;

create table buy (
    buyCode varchar2(50) primary key not null, -- �ֹ���ȣ
    memberId varchar2(50) not null,
    productID varchar2(50) not null,
    buyPrice number not null, -- �ܰ�
    buyCount number not null, -- ���Ű���
    buyTotal number not null, -- �ѱ��ž�
    buyDate date default sysdate not null, -- ��������
    foreign key(memberid) references member(memberid),
    foreign key(productid) references product(productid)
);


create table stock (
    stockCode varchar2(50) not null primary key, -- �Ϸù�ȣ
    productId varchar2(50) not null,
    stockCount number not null, -- ����
    stockCycle date not null, -- �������
    stockIndate date default sysdate not null, -- �԰���
    stockLocation varchar2(50) not null, -- �����ġ
    foreign key(productid) references product(productid)
);


insert into member values('hong2', '1234','ȫ�浿', '010-1111-1111', '����',default);

select * from member;

drop procedure proc_memberadd;

create or replace PROCEDURE proc_memberAdd
    (
        p_id in member.memberid%type,
        p_pw in member.memberpw%type,
        p_name in member.membername%type,
        p_phone in member.memberphone%type,
        p_addr in member.memberaddr%type   
    )
    is
    begin
        insert into member
        values(p_id, p_pw, p_name, p_phone, p_addr, default);
        commit;
    end;



delete from member;
select * from member;

exec proc_memberadd('hong', '1234','ȫ�浿', '010-1111-1111', '����');
exec proc_memberadd(	'lee',	'5678',	'�̼���',	'010-2222-2222',	'�뱸'	);
exec proc_memberadd(	'jang',	'9012',	'��õ��',	'010-3333-3333',	'���'	);
exec proc_memberadd(	'jung',	'3456',	'�����',	'010-4444-4444',	'��õ'	);
exec proc_memberadd(	'kwak',	'7890',	'��ö��',	'010-5555-5555',	'�λ�'	);

insert into member values('hong', '1234','ȫ�浿', '010-1111-1111', '����', default);
insert into member values(	'lee',	'5678',	'�̼���',	'010-2222-2222',	'�뱸'	,default	);
insert into member values(	'jang',	'9012',	'��õ��',	'010-3333-3333',	'���'	,default	);
insert into member values(	'jung',	'3456',	'�����',	'010-4444-4444',	'��õ'	,default	);
insert into member values(	'kwak',	'7890',	'��ö��',	'010-5555-5555',	'�λ�'	,default	);
commit;


drop procedure proc_productadd;


create or replace PROCEDURE proc_productAdd
    (
        p_id in product.productid%type,
        p_name in product.productname%type,
        p_price in product.productprice%type,
        p_company in product.productcompany%type,
        p_from in product.productmadefrom%type,
        p_count in product.productcount%type
    )
    is
    begin
        insert into product
        values(p_id, p_name, p_price, p_company, p_from, p_count);
        commit;
    end;
delete from buy;
delete from product;

exec proc_productadd(	'P001',	'����',	'2000',	'����ȸ��',	'UK'	,100);
exec proc_productadd(	'P002',	'����',	'1500',	'����ȸ��',	'KR'	,100);
exec proc_productadd(	'P003',	'����',	'100000',	'����ȸ��',	'AU'	,100);
exec proc_productadd(	'P004',	'���ɸ�',	'1000',	'���ɸ�ȸ��',	'FR'	,100);
exec proc_productadd(	'P005',	'����',	'50000',	'����ȸ��',	'UK'	,100);

select * from product;
delete from product;

select productid from product;

drop trigger buy_trigger2;

create or replace trigger buy_trigger2
    after insert
    on buy
    for each row
begin
    if inserting then
        update stock set stockcount = stockcount - :new.buycount
        where stock.productid = :new.productid;
        
    end if;
end;



select * from product;



create or replace trigger buy_trigger
    after insert
    on buy
    for each row
begin
    if inserting then
        dbms_output.put_line('buy Trigger �߻�');
        update product SET productcount = productcount - :new.buycount
        where productid = :new.productid;        
    end if;
end;    


select * from member;
select * from product;
select * from buy;

exec proc_buyadd(	'0001',	'hong',	'P001',	'2000',	'8'	);
exec proc_buyadd(	'0002',	'lee',	'P002',	'1500',	'35'	);
exec proc_buyadd(	'0003',	'jang',	'P003',	'100000',	'3'	);
exec proc_buyadd(	'0004',	'hong',	'P001',	'1800',	'20'	);

select * from buy;

delete from buy;
delete from product;
delete from stock;
drop procedure proc_buyadd;


create or replace PROCEDURE proc_buyAdd
    (
        p_buycode in buy.buycode%type,
        p_memberid in buy.memberid%type,
        p_productid in buy.productID%type,
        p_buyprice in buy.buyPrice%type,
        p_buycount in buy.buyCount%type      
    )
    is
    begin
        insert into buy
        values(p_buycode, p_memberid, p_productid, p_buyprice, p_buycount, p_buyprice*p_buycount, default);
        commit;
    end;

create or replace PROCEDURE proc_stockAdd
    (
        p_stockCode in stock.stockCode%type,
        p_productid in stock.productID%type,
        p_stockCount in stock.stockCount%type,
        p_stockCycle in stock.stockCycle%type,           
        p_stockLocation in stock.stockLocation%type
    )
    is
    begin
        insert into stock
        values(p_stockCode, p_productid, p_stockCount, p_stockCycle, default,p_stockLocation);
        commit;
    end;


create sequence stockNo
increment by 1
start with 1
minvalue 1
maxvalue 1000
nocycle;


delete from stock;

exec proc_stockadd(	stockno.nextval,	'P001',	'100',	sysdate,	'�뱸'	);
exec proc_stockadd(	stockno.nextval,	'P002',	'100',	sysdate,	'����'	);
exec proc_stockadd(	stockno.nextval,	'P003',	'100',	sysdate,	'�뱸'	);
exec proc_stockadd(	stockno.nextval,	'P004',	'100',	sysdate,	'����'	);

select * from stock;



