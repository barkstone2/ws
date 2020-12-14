
/*
------------���� 2��------------
*/

create USER certifA identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to certifA;

create table member (
    mid varchar2(50) not null primary key,
    passwd varchar2(50) not null,
    name varchar2(50) not null
);

create table product (
    pid number not null primary key,
    p_name varchar2(50) not null,
    p_price number not null,
    p_su number not null
);

create table buy (
    bid number not null primary key,
    mid varchar2(50) not null,
    pid number not null,
    b_price number not null,
    b_su number not null,
    foreign key(mid) references member(mid),
    foreign key(pid) references product(pid)
);

select * from tab;

/*
------------���� 3��------------
*/

create or replace procedure proc01
    (
        p_mid in member.mid%type,
        p_passwd in member.passwd%type,
        p_name in member.name%type
    )
    as
    begin
        insert into member values(p_mid, p_passwd, p_name);
        commit;
    end;

exec proc01(	'lss',	'1122',	'�̼���'	);
exec proc01(	'jcy',	'3344',	'��õ��'	);
exec proc01(	'lsd',	'0909',	'�̻��'	);
exec proc01(	'kcs',	'8877',	'�����'	);
exec proc01(	'jcs',	'6655',	'��ö��'	);

select * from member;

/*
------------���� 4��------------
*/

create or replace procedure proc02
    (
    p_pid in product.pid%type,
    p_pname in product.p_name%type,
    p_pprice in product.p_price%type,
    p_psu in product.p_su%type
    )
    as
    begin
        insert into product values(p_pid, p_pname, p_pprice, p_psu);
        commit;
    end;
        
exec proc02(	'1',	'�����',	'10000',	'10'	);
exec proc02(	'2',	'������',	'15000',	'10'	);
exec proc02(	'3',	'��Ź��',	'9000',	'10'	);
exec proc02(	'5',	'��ǻ��',	'2500',	'10'	);

select * from product;


/*
------------���� 5��------------
*/

create or replace procedure Proc_buy_insert
    (
    p_bid in buy.bid%type,
    p_mid in buy.mid%type,
    p_pid in buy.pid%type,
    p_bprice in buy.b_price%type,
    p_bsu in buy.b_su%type
    )
    as
    begin
        insert into buy values(p_bid, p_mid, p_pid, p_bprice, p_bsu);
        commit;
    end;

create or replace trigger trgBuy
    after insert
    on buy
    for each row
begin
    if inserting then
        update product set p_su = p_su - :new.b_su
        where product.pid = :new.pid;
    end if;
end;

exec Proc_buy_insert(	'1',	'jcs',	'1',	'20000',	'2'	);
exec Proc_buy_insert(	'2',	'kcs',	'2',	'15000',	'1'	);
exec Proc_buy_insert(	'3',	'lsd',	'3',	'27000',	'3'	);
exec Proc_buy_insert(	'5',	'lss',	'5',	'12500',	'5'	);

select * from buy;
select * from product;

/*
------------���� 6��------------
*/

create or replace procedure cursor01
as
    v_mem member%rowtype;
    cursor cursor01
    is
        select mid, passwd, name
        from member;
begin
    dbms_output.put_line('���̵�   ��й�ȣ    �̸�');
    dbms_output.put_line('---------------------------');
    open cursor01;
    loop
        fetch cursor01 into v_mem.mid, v_mem.passwd, v_mem.name;
        exit when cursor01 %notfound;
        dbms_output.put_line(v_mem.mid||'   '||v_mem.passwd||'  '||v_mem.name);
    end loop;
    close cursor01;
end;

set serveroutput on;

execute cursor01;

/*
------------���� 7��------------
*/

create or replace procedure cursor02
as
    v_buy buy%rowtype;
    cursor cursor02
    is
        select bid, mid, pid, b_price, b_su
        from buy;
begin
    dbms_output.put_line('���Ź�ȣ  ȸ�����̵�   ��ǰ���̵�   ���űݾ�    ���ż���');
    dbms_output.put_line('----------------------------------------------------');
    open cursor02;
    loop
        fetch cursor02 into v_buy.bid, v_buy.mid, v_buy.pid, v_buy.b_price, v_buy.b_su;
        exit when cursor02 %notfound;
        dbms_output.put_line(v_buy.bid||'   '||v_buy.mid||'  '||v_buy.pid||'    '||v_buy.b_price||' '||v_buy.b_su);
    end loop;
    close cursor02;
end;

set serveroutput on;

execute cursor02;


/*
------------���� 8��------------
*/

create or replace procedure cursor03
as
    v_product product%rowtype;
    cursor cursor03
    is
        select pid, p_name, p_price, p_su
        from product;
begin
    dbms_output.put_line('��ǰ���̵� ��ǰ�̸�    ��ǰ����    ������');
    dbms_output.put_line('----------------------------------------------------');
    open cursor03;
    loop
        fetch cursor03 into v_product.pid, v_product.p_name, v_product.p_price, v_product.p_su;
        exit when cursor03 %notfound;
        dbms_output.put_line(v_product.pid||'       '||
        v_product.p_name||'     '||v_product.p_price||'       '||v_product.p_su);
    end loop;
    close cursor03;
end;

set serveroutput on;

execute cursor03;


