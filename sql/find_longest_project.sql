WITH project_duration AS (
	SELECT
		id, 
		start_date, 
		finish_date, 
		DATEDIFF('MONTH', start_date, finish_date) AS month_count
	FROM project
	ORDER BY month_count DESC
)
  
SELECT id, month_count
FROM project_duration
WHERE month_count = (SELECT MAX(month_count) FROM project_duration)
ORDER BY month_count