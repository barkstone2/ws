
create or replace procedure getallcount
(
    total out number
)
as
begin
    select a+b+c+d+e+f+g as total into total
from 
(select count(*) a from countries),
(select count(*) b from departments),
(select count(*) c from employees),
(select count(*) d from job_history),
(select count(*) e from jobs),
(select count(*) f from locations),
(select count(*) g from regions)
;
end;

set serveroutput on;
variable total number;
execute getallcount(:total);
print total;


create or replace function getSalary
(
v_first_name in employees.first_name%type,
v_last_name in employees.last_name%type
)
    return number
as
    v_salary number;
begin
    select salary into v_salary
    from employees 
    where first_name=v_first_name and last_name=v_last_name;
    return v_salary;
end;

variable v_salary number;
execute :v_salary := getSalary('Steven','King');
print v_salary;




create table dept_original as select * from departments where 0=1;
create table dept_copy as select * from departments where 0=1;

create or replace trigger trigger_depart_insert
    after insert
    on dept_original
    for each row
begin
    if inserting then
    insert into dept_copy
    values(:new.department_id, :new.department_name, :new.manager_id,
        :new.location_id);
    end if;
end;

select * from dept_original;
select * from dept_copy;
insert into dept_original values('1','2','3','4');


create table pivotTest
(uName NCHAR(3),
season NCHAR(2),
amount NUMBER(3));

INSERT INTO pivotTest VALUES(	'이성순',	'겨울',	10	);
INSERT INTO pivotTest VALUES(	'장천용',	'여름',	15	);
INSERT INTO pivotTest VALUES(	'이성순',	'가을',	25	);
INSERT INTO pivotTest VALUES(	'이성순',	'봄',	3	);
INSERT INTO pivotTest VALUES(	'이성순',	'봄',	37	);
INSERT INTO pivotTest VALUES(	'장천용',	'겨울',	40	);
INSERT INTO pivotTest VALUES(	'이성순',	'여름',	14	);
INSERT INTO pivotTest VALUES(	'이성순',	'겨울',	22	);
INSERT INTO pivotTest VALUES(	'장천용',	'여름',	64	);
commit;

SELECT * FROM pivotTEST;

select * from pivotTest
pivot(sum(amount) for season in('봄','여름','가을','겨울'));

select * from employees where first_name='Steven' and last_name='King';