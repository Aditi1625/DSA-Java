SELECT 
    product_id,
    product_name,
    description
FROM 
    products
WHERE 
    REGEXP_LIKE(
        description, 
        '(^|[^a-zA-Z0-9])SN[0-9]{4}-[0-9]{4}([^a-zA-Z0-9]|$)', 
        'c' -- 'c' specifies case-sensitive matching
    )
ORDER BY 
    product_id ASC;
