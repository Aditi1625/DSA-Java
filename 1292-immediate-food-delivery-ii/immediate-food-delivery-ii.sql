# Write your MySQL query statement below
WITH FirstOrders AS(
    SELECT 
    customer_id,
    order_date,
    customer_pref_delivery_date,
    ROW_NUMBER()OVER(PARTITION BY customer_id ORDER BY order_date ASC)as rn
    FROM
    Delivery

)
SELECT
ROUND(
    SUM(CASE WHEN order_date=customer_pref_delivery_date THEN 1 ELSE 0 END)*100.0/
    COUNT(*),
    2
)AS immediate_percentage
FROM
FirstOrders
WHERE
rn=1;