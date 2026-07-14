# Write your MySQL query statement below
WITH LatestPriceChange AS(
    SELECT
    product_id,
    new_price,
    RANK()OVER( PARTITION BY product_id ORDER BY change_date DESC)as rnk
    FROM
    Products
    WHERE
    change_date<='2019-08-16'
)
SELECT 
p.product_id,
COALESCE(l.new_price,10)AS price
FROM
(SELECT DISTINCT product_id FROM Products)p
LEFT JOIN
LatestPriceChange l ON p.product_id=l.product_id AND l.rnk=1;