# Write your MySQL query statement below
select Department , Employee , Salary from(
    select e.departmentId , e.salary as Salary , e.name as Employee , d.name as Department , max(salary) over(partition by e.departmentId) as ms  
    from Employee e join Department d on e.departmentId = d.id
) t
where Salary = ms;