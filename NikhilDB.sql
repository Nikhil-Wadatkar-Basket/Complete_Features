select * from emp;
select * from dept;



select * from employee;
select * from department;
select * from employee_details_tab;
select * from Identity_Details;

update employee set email = 'dhanu' where  id in(1,2,3,4,5);
select e.id, e.name from Employee e where e.job_id like 'AC_ACCOUNT';

select department_id, count(*) from employee group by department_id;
select id, name, salary from employee where id=1;


desc employee;
