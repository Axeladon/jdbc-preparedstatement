WITH project_counts_table AS (
	SELECT client.name, COUNT(project.client_id) AS project_count
	FROM client
	JOIN project ON client.id = project.client_id
	GROUP BY client.name
	ORDER BY project_count DESC
)

SELECT name, project_counts_table.project_count
FROM project_counts_table
WHERE project_counts_table.project_count = (
	SELECT MAX(project_counts_table.project_count)
	FROM project_counts_table
)