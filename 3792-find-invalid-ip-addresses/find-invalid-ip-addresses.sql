WITH RECURSIVE SplitOctets AS (
    -- Anchor member: Get the first octet and the remainder of the string
    SELECT 
        log_id,
        ip,
        1 AS octet_index,
        SUBSTRING_INDEX(ip, '.', 1) AS octet_value,
        SUBSTRING(ip, LOCATE('.', ip) + 1) AS remainder
    FROM logs
    
    UNION ALL
    
    -- Recursive member: Extract subsequent octets
    SELECT 
        log_id,
        ip,
        octet_index + 1,
        IF(LOCATE('.', remainder) > 0, SUBSTRING_INDEX(remainder, '.', 1), remainder),
        IF(LOCATE('.', remainder) > 0, SUBSTRING(remainder, LOCATE('.', remainder) + 1), '')
    FROM SplitOctets
    WHERE remainder <> '' OR (remainder = '' AND octet_index < 4)
),
InvalidLogs AS (
    SELECT DISTINCT log_id, ip
    FROM SplitOctets
    WHERE 
        -- Rule 3: Must have exactly 4 octets
        (octet_index > 4 OR (remainder = '' AND octet_index < 4))
        
        -- Rule 1: Contains numbers greater than 255, less than 0, or is empty/non-numeric
        OR octet_value REGEXP '^[^0-9]+$' 
        OR CAST(octet_value AS SIGNED) > 255 
        OR CAST(octet_value AS SIGNED) < 0
        
        -- Rule 2: Has leading zeros in any octet (length > 1 and starts with 0)
        OR (LENGTH(octet_value) > 1 AND octet_value LIKE '0%')
)
SELECT 
    ip, 
    COUNT(*) AS invalid_count
FROM InvalidLogs
GROUP BY ip
ORDER BY invalid_count DESC, ip DESC;
