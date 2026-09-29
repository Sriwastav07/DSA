# Write your MySQL query statement below
-- select d.name as Department, e.name as Employee, e.salary as Salary from Employee e
-- join Department d
-- on e.departmentId = d.id
-- where (
--     select count(distinct e2.salary) from Employee e2
--     where e2.departmentId = e.departmentId
--     and
--     e2.salary > e.salary
-- ) < 3;

select Department, Employee, Salary from (
    select d.name as Department, e.name as Employee, e.salary as Salary, dense_rank() over(partition by e.departmentId order by e.salary desc) as tr from Employee e
    join Department d
    on e.departmentId = d.id
) as nt where tr <= 3;