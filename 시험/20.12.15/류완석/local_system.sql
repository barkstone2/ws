

create user srv_pg_impl
identified by 1234
default tablespace users
temporary tablespace temp;

grant connect, resource, dba to srv_pg_impl;