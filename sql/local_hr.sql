select * from employees;

select first_name, salary, salary+300 as "인상된 급여" from employees;

select first_name, salary, salary*12 +100 as "연간 총수입" from employees order by "연간 총수입" desc;

select first_name, salary from employees where salary > 2000 order by salary desc;

select first_name, department_id from employees where employee_id = 198;

select * from employees;

select first_name, salary from employees where salary not between 2000 and 3000;

select first_name, job_id, hire_date from employees where hire_date between '02/06/07' and '08/02/03';

select first_name, department_id from employees where department_id in(20,30) order by first_name desc;

select first_name, salary, department_id from employees where salary between 2000 and 3000
and department_id in(20,30) order by first_name;

select first_name, hire_date from employees where hire_date like '02/%';

select * from employees;
select first_name from employees where manager_id is null;
select first_name, salary, commission_pct from employees where commission_pct is not null order by salary desc, commission_pct desc;

select upper('korea')from dual;
select lower('KOreA')from dual;

select INITCAP('WELCOME MY SITE!!!') from dual;


select LENGTH('Oracle'), LENGTH('오라클') from dual;
select LENGTHB('Oracle'), LENGTHB('오라클') from dual;
select substr('Welcom to Oracle', -4, 3) from dual;

select first_name from employees where first_name like '%a';
select first_name from employees where substr(first_name, -1, 1) = 'a';


select first_name, hire_date from employees where substr(hire_date, 1, 2) = 05;

select INSTR('WELCOM TO ORACLE','O') from dual;

select LPAD('Oracle', 20, '#') from dual;
select RPAD('Oracle', 20, '#') from dual;

select LTRIM('        oracle') from dual;
select RTRIM('oracle         ') from dual;
select TRIM('       oracle         ') from dual;

select concat('korea', 'fighting') from dual;

select 'korea'||'fighting'||'best' from dual;
select 'korea'||'/'||'fighting'||'/'||'best' from dual;

select -10, abs(-10) from dual;

select 34.5678, floor(34.5678) from dual;
select 34.5678, round(34.5678, -1) from dual;

select trunc(34.5678,2), trunc(34.5678, -1), trunc(34.5678) from dual;
select mod(27, 2), mod(27, 5), mod(27, 7) from dual;

select power(2,3) from dual;
select exp(2) from dual;
select sign(-100) from dual;

select sysdate from dual;
select sysdate-1 어제, sysdate 오늘, sysdate+1 내일 from dual;

select first_name, sysdate, hire_date, round((SYSDATE-HIRE_DATE)-(((sysdate - hire_date)/7)*2)) workday from employees;

select months_between(sysdate, hire_date) from employees;

select first_name, sysdate, hire_date, 
    months_between(sysdate,hire_date),
    trunc(months_between(sysdate,hire_date)),
    floor(months_between(sysdate,hire_date))
    from employees;

select sysdate, next_day(sysdate, '화요일') from dual;

select hire_date, last_day(hire_date) from employees;

select first_name 이름, trunc((sysdate - hire_date)/365) 근속년수 from employees;

select rownum, rowid, employee_id, first_name from employees;

select sysdate-100, sysdate+100 from dual;

-- rownum 행(레코드) 번호
-- rowid 행(레코드)의 주소값

-- 두 날짜 사이의 개월수 계산 함수
select months_between('2019/04/04','2019/04/15') a,
months_between('2019/04/15', '2019/04/04') b,
trunc(abs(months_between('2019/04/04', '2019/04/15'))) c
from dual;

-- 형변환 함수
-- to_char : 날짜형 혹은 숫자형을 문자형으로 변환
-- to_date : 문자형을 날짜형으로 변환
-- to_number : 문자형을 숫자형으로 변환


select to_char(sysdate, 'yyyy-mm-dd am hh24:mi:ss') from dual;
select sysdate, to_char(sysdate, 'yyyy-mm-dd') from dual;

select hire_date, 
to_char(hire_date, 'yyyy/mm/dd day') a,
to_char(hire_date, 'yy/mon/dd dy') b,
to_char(hire_date, 'yyyy-mm-dd hh:mi:ss') c
from employees;

select to_char(1230000), to_char(1230000) + 100 from dual;

select first_name, salary, to_char(salary, 'L999,999') from employees;

select to_char(123456, '000000000') a,
to_char(123456, '999,999,999') b from dual;

-- 형식 : to_date('문자', 'format')

select first_name, hire_date from employees
where hire_date = to_date(20030617, 'yyyymmdd');


select first_name, hire_date from employees
where hire_date = '20030617';

select first_name, hire_date from employees
where hire_date = to_date('20030617', 'yyyymmdd');

select trunc(sysdate - to_date('2008/01/01', 'yyyy-mm-dd')) from dual;

select trunc(sysdate - '2008/01/01') from dual; -- error

select to_date('2015-12-31') from dual;
select to_date('2015-03-31 12:23:03') from dual;
select to_date('2015-03-31 12:23:03', 'yyyy-mm-dd hh:mi:ss') from dual;

-- 형식 : to_number('숫자형태의 문자열')
select 100-10, 100+10, 100*10, 100/10 from dual;
select '100' + 1 from dual;

-- 형변환, 재정의(상속) >> 다형성

select to_number('20,000', '99,999') - to_number('10,000','99,999') result from dual;

select first_name, salary, commission_pct, nvl(commission_pct, 0), salary * 12 + nvl(commission_pct, 0) from employees
order by job_id;

-- 형식 : nvl2(expr1, expr2, expr3)
-- nvl2 함수 : expr1을 검사하여 그 결과가 null이 아니면 expr2를 반환
-- null이면 expr3를 반환

select first_name, salary, commission_pct, nvl2(commission_pct, salary *12 + commission_pct, salary * 12) a,
salary * 12 + nvl(commission_pct, 0) b from employees order by job_id;

--nullif 함수 : 두 표현식을 비교하여 동일한 경우 null
-- 다를 경우 첫 번째 표현식을 반환
-- 형식 nullif(expr1, expr2)

select nullif('A', 'A'), nullif('A', 'B') from dual;

--coalesce 함수 : 인수 중에서 null이 아닌 첫번째 인수를 반환
-- coalesce(expr_1, expr_2, .... expr_n)

select first_name, commission_pct, salary, coalesce(commission_pct, salary, 0) 
from employees order by job_id;

-- decode 함수 : switch case문과 비슷.
-- 형식
/*
decode(표현식1, 조건1, 결과1,
        조건2, 결과 2,
        조건3, 결과 3,
        기본결과 n)
*/

select first_name, department_id,
        decode(department_id,
        10, 'ACCOUNTING',
        20, 'RESEARCH',
        30, 'SALES',
        40, 'OPERATIONS',
        'DEFAULT') AS dname
        from employees
        order by department_id;
        
        
-- case 함수 : if와 동일
/*
case expr
    when 조건1 then 결과1
    when 조건2 then 결과2
    else 결과n
end
*/

select first_name, department_id,
    case
        when department_id = 10 then 'ACCOUNTING'
        when department_id = 20 then 'RESEARCH'
        when department_id = 30 then 'SALES'
        when department_id = 40 then 'OPERATIONS'
        else 'default'
    end as dname
from employees
order by department_id;


select substr(hire_date,1,2) 입사년도, substr(hire_date,4,2) 입사한달
from employees;

select * from employees where substr(hire_date,4,2) = '04';
select * from employees where mod(employee_id, 2) = 0;

select trunc(sysdate - to_date('20/01/01','yy/mm/dd')) 올해지난날 from dual;

select * from employees;

select nvl(manager_id, 0) from employees;

select sum(salary) a,
        avg(salary) b,
        max(salary) c,
        min(salary) d,
        count(*) e,
        count(commission_pct) f
        from employees;
        
        
select max(hire_date), min(hire_date)
from employees;

select sum(commission_pct) as 커미션
from employees;


select count(*) from employees;

select count(job_id) from employees;

select count(distinct job_id) from employees;

-- 집계 함수와 단순 컬럼 error
-- 
select first_name, max(salary) from employees;



select * from employees;

select department_id, sum(salary) from employees
group by department_id;

select first_name from employees
where salary = max(salary);


select max(first_name) keep(dense_rank first order by salary desc) as name, max(salary) as salary
from employees;

select * from employees order by salary desc;


select department_id, first_name, avg(salary)
from employees
group by depatmetn_id;

select department_id, job_id, count(*), sum(salary)
from employees
group by department_id, job_id
order by department_id, job_id;

select department_id, sum(salary)
from employees
group by department_id
having sum(salary) >= 3000
order by department_id;

select job_id, sum(salary) from employees
where job_id != 'IT_PROG'
group by job_id
having sum(salary) >= 5000;


select max(department_id) keep(dense_rank last order by avg(salary)) as department_id, max(avg(salary)) as avgSalary
from employees
group by department_id;

select department_id, avg(salary)
from employees
group by department_id;


select first_name, salary
from employees
where first_name = 'Lex';

select first_name, salary
from employees
where salary > (select salary from employees where first_name = 'Lex');


select first_name, department_id
from employees
where department_id = (select department_id from employees where first_name = 'Lex');

select * from employees;


select first_name, job_id, salary
from employees
where salary = (select min(salary) from employees);


select *
from employees
where department_id = 
(select department_id from employees where upper(first_name) 
= 'STEVEN' and lower(last_name) = 'king');


select department_id, min(salary)
from employees
group by department_id
having min(salary) > (select min(salary) from employees where department_id = '30')
order by min(salary);


select employee_id, first_name, salary
from employees
where salary in (
        select min(salary)
        from employees
        group by department_id
        );

select employee_id, first_name, job_id, salary
from employees
where salary < any(
        select salary
        from employees
        where job_id = 'IT_PROG'
)
and job_id != 'IT_PROG';

/*
>any는 최소값보다 큰 것
<any는 최대값보다 작은 것
=any는 in과 동일

all연산자는 서브쿼리에서 반환하는 모든 값과 비교
>all은 최대값보다 큰것
<all은 최소값보다 작은 것

*/

select * from employees, departments;

select count(*) from employees;
select count(*) from departments;


/*
회원테이블과 부서 테이블 조인
department_id가 공통 커럼
employees 테이블의 department_id와 departments의 department_id를 연결
*/

select department_id, min(salary), min(first_name) keep(DENSE_RANK FIRST ORDER BY salary)
from employees
group by department_id;

select * from employees;


/* 동등조인, inner join, EQUI JOIN
*/
select e.employee_id,
e.first_name,
e.department_id,
d.department_name
from employees e, departments d
where e.department_id = d.department_id
and first_name = 'Lex';


select e.employee_id,
e.first_name,
e.department_id,
d.department_name
from employees e inner join departments d
on e.department_id = d.department_id
where first_name = 'Lex';

-- 테이블명 inner join 테이블명 on 조건
-- 테이블명, 테이블명 where 조건

select e.employee_id,
        e.first_name,
        e.department_id,
        d.department_name,
        j.job_title
from employees e, departments d, jobs j
where e.department_id = d.department_id
        and e.job_id = j.job_id
        and e.first_name = 'Lex';

select e.employee_id,
        e.first_name,
        e.department_id,
        d.department_name,
        j.job_title
from employees e
        inner join departments d 
            on e.department_id = d.department_id
        inner join jobs j 
            on e.job_id = j.job_id
where e.first_name = 'Lex';

select * from employees, departments
where employees.department_id = departments.department_id;

select e.first_name, e.hire_date, e.salary, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

select e.employee_id, e.first_name, d.department_name 
from employees e, departments d
where e.department_id = d.department_id
and e.employee_id = '101';


/*
left outer join
*/
select employees.first_name,
employees.hire_date,
employees.salary,
departments.department_name
from employees, departments
where employees.department_id = departments.department_id(+);
-- null 이 출력되는 테이블에 (+)를 붙인다.

select employees.first_name,
employees.hire_date,
employees.salary,
departments.department_name
from employees left outer join departments
on employees.department_id = departments.department_id;

select employees.first_name,
employees.hire_date,
employees.salary,
departments.department_name
from departments left outer join employees
on employees.department_id = departments.department_id;


select d.department_id,
count(e.salary),
sum(e.salary) as salary_ord
from departments d left outer join employees e
on d.department_id = e.department_id
group by d.department_id;

select d.department_id,
count(e.salary),
sum(e.salary) as salary_ord
from departments d right outer join employees e
on d.department_id(+) = e.department_id
group by d.department_id;

select d.department_id,
count(e.salary),
sum(e.salary) as salary_ord
from departments d inner join employees e
on d.department_id = e.department_id
group by d.department_id;

/*
inner join : 양쪽에 동일하게 존재하는 내용 출력
outer join : left outer join / right outer join
왼쪽을 전부 출력, 오른쪽을 전부 출력(null값 포함)

테이블명 inner join 테이블명 on 조인할 조건
테이블명 left outer join 테이블명 on 조인할 조건
테이블명 right outer join 테이블명 on 조인할 조건
*/

select d.department_name
from employees e inner join departments d 
on e.department_id = d.department_id
where upper(e.first_name) = 'STEVEN'
and upper(e.last_name) = 'KING';



select first_name, department_id,
(select department_name
from departments
where departments.department_id = employees.department_id) department_name
from employees
where first_name = 'Steven' and last_name = 'King';


select e.first_name, d.department_name, l.city
from employees e 
    left outer join departments d
        on e.department_id = d.department_id
    left outer join locations l
        on d.location_id = l.location_id;

select e.first_name, d.department_name, l.city
from employees e 
    inner join departments d
        on e.department_id = d.department_id
    inner join locations l
        on d.location_id = l.location_id;

select e.first_name, d.department_name
from employees e
    left outer join departments d
        on e.department_id = d.department_id
--    inner join locations l
--        on d.location_id = l.location_id
where e.commission_pct is not null;


select e.first_name, e.last_name, d.department_name
from employees e
    left outer join departments d
        on e.department_id = d.department_id
where e.first_name like '%A%';


select *
from locations
where country_id = 'US'
order by location_id asc;


select e.first_name, l.country_id, d.department_name, d.location_id
from employees e
    inner join departments d
    on e.department_id = d.department_id
    inner join locations l
    on d.location_id = l.location_id and l.country_id = 'US'
order by d.location_id;

select e.first_name, l.country_id, d.department_name, d.location_id
from employees e
    inner join departments d
    on e.department_id = d.department_id
    inner join locations l
    on d.location_id = l.location_id
where l.country_id = 'US'
order by d.location_id, d.department_name, e.first_name;


select * from employees;


create or replace view test_view
as select employee_id, first_name, job_id from employees;

select * from test_view;

select * from user_views;

/*
저장프로시저(stored procedure) - 성능이 좋음
*/

create or replace procedure hr.counter
as
    var1 int;
    var2 int;
begin
    select count(*) into var1 from hr.employees;
    select count(*) into var2 from hr.departments;
    DBMS_OUTPUT.PUT_LINE(var1+var2);
end;

set SERVEROUTPUT ON;
EXECUTE hr.counter;

EXECUTE hr.counter;
EXECUTE hr.counter;
EXECUTE hr.counter;

create or replace procedure sp_salary
as
    v_salary employees.salary%type;
begin
    select salary into v_salary
    from employees
    where first_name = 'Steven' and last_name = 'King';
    dbms_output.put_line('Steven의 급여는 ' || v_salary || '입니다.');
end;


set serveroutput on;
execute sp_salary;


create or replace procedure sp_salary_ename
(
    v_first_name in employees.first_name%type,
    v_last_name in employees.last_name%type
)
as
    v_salary employees.salary%type;
begin
    select salary into v_salary
    from employees
    where first_name = v_first_name and last_name = v_last_name;
    DBMS_OUTPUT.put_line(v_first_name||' '||v_last_name||'의 급여는 '||v_salary||' 입니다.');
end;

set serveroutput on;

execute sp_salary_ename('Steven', 'King');




create or replace procedure sp_salary_ename2
(
    v_first_name in employees.first_name%type,
    v_last_name in employees.last_name%type,
    v_salary out employees.salary%type
)
as
begin
    select salary into v_salary
    from employees
    where first_name = v_first_name and last_name = v_last_name;
end;

set serveroutput on;
variable v_salary varchar2(14);
execute sp_salary_ename2('Steven', 'King', :v_salary);
print v_salary;


/*
Cursor : select문의 실행결과는 메모리에 저장.
이 메모리 공간을 커서라고 하낟.
Fetch : 커서에서 원하는 결과값을 추출하는 것.

Cursor의 사용이유 :
select의 결과가 하나의 행인 경우는 into절을 이용해서 변수에 저장가능.
그러나 복수행일 경우 into 절 사용 X
복수행의 결과를 행단위로 처리하기 위해 사용하는 것이 커서다.
*/

create or replace procedure cursor_c2
as
    v_dept departments%rowtype;
    cursor c2
    is
        select department_id, department_name, location_id
        from departments;
begin
    dbms_output.put_line('부서번호  부서명     지역명');
    dbms_output.put_line('-------------------------------------');
    open c2;
    loop
        fetch c2 into v_dept.department_id, v_dept.department_name, v_dept.location_id;
        exit when c2 %notfound;
        dbms_output.put_line(v_dept.department_id||'    '||v_dept.department_name||'    '||v_dept.location_id);
    end loop;   
    close c2;
end;
        
set serveroutput on;

execute cursor_c2();


create or replace procedure cursor_c3
as
    v_emp employees%rowtype;
    cursor c3
    is
        select employee_id, first_name, last_name
        from employees;
begin
    dbms_output.put_line('사원번호  이름      성');
    dbms_output.put_line('-------------------------------------');
    open c3;
    loop
        fetch c3 into v_emp.employee_id, v_emp.first_name, v_emp.last_name;
        exit when c3 %notfound;
        dbms_output.put_line(v_emp.employee_id||'    '||v_emp.first_name||'    '||v_emp.last_name);
    end loop;   
    close c3;
end;

set serveroutput on;

execute cursor_c3();

/*
* 트리거 (Trigger) : 부착
*/

create table dept_original
as
    select * from departments where 0 = 1;

select * from tab;

create table dept_copy
as
    select * from departments where 0=1;
    
select * from tab;

create or replace trigger trigger_sample1
    after insert
    on dept_original
    for each row
begin
    if inserting then
        dbms_output.put_line('Insert Trigger 발생');
        insert into dept_copy
        values(:new.department_id, :new.department_name, :new.manager_id,
        :new.location_id);
    end if;
end;

select * from dept_copy;
select * from dept_original;

insert into dept_original
values(10, 'ACCOUNTING', 3, 5);

insert into dept_original
values(20, 'IT', 5, 10);



create or replace trigger trigger_sample2
    after delete
    on dept_original
    for each row
begin
    dbms_output.put_line('Delete Trigger 발생');
    delete from dept_copy
    where dept_copy.department_id = :old.department_id;
end;


select * from dept_original;

insert into dept_original
values(30, 'Test', 10, 20);

select * from dept_copy;


delete from dept_original
where department_id = 30;

/*
:old 임시 테이블이다. 삭제가 수행되기 전에 데이터가 저장되어 있는 테이블
테이블에서 데이터를 삭 제한다.
테이블 삭제하기.
delete dept_original where department_id = 10;

테이블에서 삭제한 데이터가 백업용 테이블에서도 삭제되어 있음을 확인가능
select * from dept_copy;
select * from dept_original;
*/

/*
21/01/08
함수, 변수
함수는 하나의 값만을 반환
*/

create or replace function fn_salary_ename
(
    v_first_name in employees.first_name%type, 
    v_last_name in employees.last_name%type
)
    return number
as
    v_salary number(7,2);
begin
    select salary into v_salary
    from employees
    where first_name=v_first_name and last_name=v_last_name;
    return v_salary;
end;

variable v_salary2 number;
execute :v_salary2 := fn_salary_ename('Steven','King');
print v_salary2;


select * from employees;

select first_name, last_name, fn_salary_ename(first_name, last_name) sal
from employees;

/*테이블 복사*/
create table tbl01
as select * from departments;

/*테이블 틀만 복사(제약조건 복사 X)*/
create table tbl02
as select * from departments where 0=1;

create table pTBL(
uName nchar(3),
season nchar(2),
amount number(3)
);

select * from pTBL
pivot(sum(amount) for season in('봄','여름','가을','겨울'));

commit;