# Write your MySQL query statement below
SELECT 
    sample_id,
    dna_sequence,
    species,
    -- Condition 1: Starts with ATG
    IF(dna_sequence LIKE 'ATG%', 1, 0) AS has_start,
    -- Condition 2: Ends with TAA, TAG, or TGA
    IF(dna_sequence REGEXP '(TAA|TAG|TGA)$', 1, 0) AS has_stop,
    -- Condition 3: Contains the motif ATAT
    IF(dna_sequence LIKE '%ATAT%', 1, 0) AS has_atat,
    -- Condition 4: Contains at least 3 consecutive Gs (GGG)
    IF(dna_sequence LIKE '%GGG%', 1, 0) AS has_ggg
FROM Samples
ORDER BY sample_id ASC;
