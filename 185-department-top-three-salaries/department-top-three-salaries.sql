# Write your MySQL query statement below

select Department , Employee , Salary from (
    select * , dense_rank() over(partition by Department order by Salary desc) as rn from(
        select d.name as Department , e.name as Employee , salary as Salary
        from Employee e join Department d on e.departmentId = d.id
    ) t
) x
where rn <= 3;


