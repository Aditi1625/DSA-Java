# Write your MySQL query statement below
-- Rule 1: Employees who belong to multiple departments (select the primary one)
SELECT 
    employee_id, 
    department_id
FROM 
    Employee
WHERE 
    primary_flag = 'Y'

UNION

-- Rule 2: Employees who belong to exactly one department
SELECT 
    employee_id, 
    department_id
FROM 
    Employee
GROUP BY 
    employee_id
HAVING 
    COUNT(department_id) = 1;
