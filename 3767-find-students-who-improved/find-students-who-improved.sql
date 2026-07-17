# Write your MySQL query statement below
WITH RankedScores AS (
    SELECT 
        student_id,
        subject,
        score,
        -- Get the score from the earliest exam date for this student/subject
        FIRST_VALUE(score) OVER(
            PARTITION BY student_id, subject 
            ORDER BY exam_date ASC
        ) AS first_score,
        -- Get the score from the latest exam date for this student/subject
        FIRST_VALUE(score) OVER(
            PARTITION BY student_id, subject 
            ORDER BY exam_date DESC
        ) AS latest_score,
        -- Count how many exams they have taken in this subject
        COUNT(exam_date) OVER(
            PARTITION BY student_id, subject
        ) AS exam_count
    FROM Scores
)
SELECT DISTINCT 
    student_id,
    subject,
    first_score,
    latest_score
FROM RankedScores
WHERE exam_count >= 2 
  AND latest_score > first_score
ORDER BY student_id ASC, subject ASC;
