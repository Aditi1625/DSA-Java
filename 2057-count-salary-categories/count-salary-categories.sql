# Write your MySQL query statement below
-- Category 1: Low Salary
SELECT 
    'Low Salary' AS category,
    COUNT(account_id) AS accounts_count
FROM 
    Accounts
WHERE 
    income < 20000

UNION ALL

-- Category 2: Average Salary
SELECT 
    'Average Salary' AS category,
    COUNT(account_id) AS accounts_count
FROM 
    Accounts
WHERE 
    income >= 20000 AND income <= 50000

UNION ALL

-- Category 3: High Salary
SELECT 
    'High Salary' AS category,
    COUNT(account_id) AS accounts_count
FROM 
    Accounts
WHERE 
    income > 50000;
