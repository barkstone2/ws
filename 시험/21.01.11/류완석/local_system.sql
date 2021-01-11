
create user mystudy
identified by 1234;

grant connect, resource, dba to mystudy;

revoke connect, resource, dba from mystudy;