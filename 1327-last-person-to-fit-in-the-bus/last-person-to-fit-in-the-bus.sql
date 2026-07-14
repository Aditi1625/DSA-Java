# Write your MySQL query statement below
WITH RunningWeights AS(
    SELECT
    person_name,
    turn,
    SUM(weight)OVER (ORDER BY turn ASC)AS total_weight
    FROm
    Queue
)
SELECT 
person_name
FROM
RunningWeights
WHERE
total_weight<=1000
ORDER BY
turn DESC
LIMIT 1;