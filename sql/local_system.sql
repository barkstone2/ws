/*
-- SQL �з�
DDL(���Ǿ�) : create, drop, alter
DML(���۾�) : select, update, insert, delete
DCL(�����) : grant, revoke, deny
*/

-- ��Ű�� ����
CREATE USER exam01 IDENTIFIED BY 1234
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

-- ����� ���� �ο�
GRANT connect, resource, dba TO exam01;

-- ����� ���� ��� ����
select * from all_users;

-- ���� ȸ��
REVOKE dba FROM exam01;

-- ����� ���� ����
drop user exam01 cascade;

-- ��� ���� Ǯ��
alter user hr account unlock identified by 1234;

-- ����� ��й�ȣ ����
alter user system identified by "1111";


create tablespace sample02
datafile 'c:/sqldata/sample02.dbf' size 50m
autoextend on
next 10m
maxsize unlimited;

CREATE USER sample02
IDENTIFIED BY 1234
DEFAULT TABLESPACE sample02;

GRANT connect, resource, dba TO sample02;

select * from all_users;



create tablespace test
datafile 'c:/sqldata/test.dbf' size 50m
autoextend on
next 10m
maxsize unlimited;

create user test
identified by 1234
default tablespace test;

grant connect, resource, dba to test;



create user jspTest
identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to jspTest;



create user member
identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to member;

create user jspSample
identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to jspSample;

create user jspSample2
identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to jspSample2;


create user jspMvc1
identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to jspMvc1;



select * from tab;

create user jspExam
identified by 1234
default tablespace users
temporary tablespace temp;



create user jspInterface
identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to jspInterface;

