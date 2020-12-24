/*
systme 계정에서 실행함
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

/****************************************************************/


create table member (
id varchar2(50) primary key not null,
pwd varchar2(50) not null,
name varchar2(50) not null,
phone varchar2(50) not null,
job varchar2(50) not null
);

/*
create table member (
id varchar(50) primary key not null,
pwd varchar(50) not null,
name varchar(50) not null,
phone varchar(50) not null,
job varchar(50) not null
);
*/

