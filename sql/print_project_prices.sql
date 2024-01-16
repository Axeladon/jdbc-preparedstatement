WITH month_duration AS (
	SELECT 
		id, 
		EXTRACT(MONTH FROM AGE(finish_date, start_date)) AS month_count
	FROM project
)

SELECT 
	project_id, 
	SUM(worker.salary * month_duration.month_count) AS price
FROM project_worker
JOIN worker ON project_worker.worker_id = worker.id 
JOIN month_duration ON project_worker.project_id = month_duration.id
GROUP BY project_worker.project_id
ORDER BY price DESC