/*
oracle DB create. 
*/
create user jspInterfaceImplExam
identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to jspInterfaceImplExam;


create table resume (
no number not null primary key,
pic varchar2(50) not null,
name varchar2(50) not null,
email varchar2(50) not null,
phone varchar2(50) not null,
address varchar2(50) not null,
TOEIC number,
TOEFL number,
japan number,
china number,
gigan1 varchar2(50),
school1 varchar2(50),
jeongong1 varcahr2(50),
gigan2 varchar2(50),
school2 varchar2(50),
jeongong2 varcahr2(50),
gigan3 varchar2(50),
school3 varchar2(50),
jeongong3 varcahr2(50),
gigan4 varchar2(50),
school4 varchar2(50),
jeongong4 varcahr2(50),
wdate date default sysdate
);




/*
mySQL DB create. 
*/

create database jspInterfaceImplExam;
grant all privileges on jspInterfaceImplExam.* to jspInterfaceImplExam@localhost identified by '1234';
exit;

mysql -u jspInterfaceImplExam -p;
1234;

use jspInterfaceImplExam;
