/*
-- SQL 분류
DDL(정의어) : create, drop, alter
DML(조작어) : select, update, insert, delete
DCL(제어어) : grant, revoke, deny
*/

-- 스키마 생성
CREATE USER exam01 IDENTIFIED BY 1234
DEFAULT TABLESPACE USERS
TEMPORARY TABLESPACE TEMP;

-- 사용자 권한 부여
GRANT connect, resource, dba TO exam01;

-- 사용자 계정 목록 보기
select * from all_users;

-- 권한 회수
REVOKE dba FROM exam01;

-- 사용자 계정 삭제
drop user exam01 cascade;

-- 잠긴 계정 풀기
alter user hr account unlock identified by 1234;

-- 사용자 비밀번호 변경
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


create user jspInterfaceImpl02
identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to jspInterfaceImpl02;


create user jspInterfaceImplExam
identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to jspInterfaceImplExam;


/*
create database jspInterfaceImplExam;
grant all privileges on jspInterfaceImplExam.* to jspInterfaceImplExam@localhost identified by '1234';
exit;

mysql -u jspInterfaceImplExam -p;
1234;

use jspInterfaceImplExam;
*/


create user test1222
identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to test1222;

/*
create database test1222;
grant all privileges on test1222.* to test1222@localhost identified by '1234';
exit;

mysql -u test1222 -p;
1234;

use test1222;
*/

create user javaIoTExam
identified by 1234;

grant connect, resource, dba to javaIoTExam;


create user jspModel1
identified by 1234;

grant connect, resource, dba to jspModel1;


create user jspws
identified by 1234;

grant connect, resource, dba to jspws;



create user jspSQLExam
identified by 1234;

grant connect, resource, dba to jspSQLExam;


create user includeEx02
identified by 1234;

grant connect, resource, dba to includeEx02;

/*
2021/01/04
*/

create user aca
identified by 1234;

grant connect, resource, dba to aca;

create user model2
identified by 1234;

grant connect, resource, dba to model2;





