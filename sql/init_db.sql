CREATE TABLE worker (
	id SERIAL 		PRIMARY KEY,
	name VARCHAR(1000) 	NOT NULL CHECK (LENGTH(name) >= 2),
	birthday DATE 		CHECK (EXTRACT(YEAR FROM birthday) >= 1900),
	level VARCHAR(7) 	NOT NULL CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior')),
	salary INT 		NOT NULL CHECK (salary >= 200 AND salary <= 100000)
);

CREATE TABLE client (
	id SERIAL 		PRIMARY KEY,
	name VARCHAR(1000) 	NOT NULL CHECK (LENGTH(name) >= 2)
);

CREATE TABLE project (
	id SERIAL 		PRIMARY KEY,
	client_id INT,
	start_date DATE,
	finish_date DATE
);

CREATE TABLE project_worker (
	project_id INT,
	worker_id INT,
	PRIMARY KEY (project_id, worker_id)
);