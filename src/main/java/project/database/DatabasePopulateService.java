package project.database;

import project.pojo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {
    public static void main(String[] args) {
        populateWorker();
        populateClient();
        populateProject();
        populateProjectWorker();
    }

    public static void populateWorker() {
        String sqlQuery = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";

        List<WorkerPojo> workerList = new ArrayList<>();
        workerList.add(new WorkerPojo("John Doe", Date.valueOf("1990-03-15"), Level.TRAINEE, 700));
        workerList.add(new WorkerPojo("Jane Smith", Date.valueOf("1985-08-22"), Level.JUNIOR, 1200));
        workerList.add(new WorkerPojo("Alex Johnson", Date.valueOf("1988-05-10"), Level.SENIOR, 5500));
        workerList.add(new WorkerPojo("Emily Davis", Date.valueOf("1992-11-30"), Level.TRAINEE, 800));
        workerList.add(new WorkerPojo("Michael Brown", Date.valueOf("1982-04-05"), Level.MIDDLE, 2900));
        workerList.add(new WorkerPojo("Olivia Taylor", Date.valueOf("1995-07-18"), Level.MIDDLE, 3000));
        workerList.add(new WorkerPojo("Ethan Miller", Date.valueOf("1989-09-25"), Level.SENIOR, 6000));
        workerList.add(new WorkerPojo("Chloe Wilson", Date.valueOf("1993-01-12"), Level.SENIOR, 5800));
        workerList.add(new WorkerPojo("Mason Harris", Date.valueOf("1987-06-08"), Level.JUNIOR, 1600));
        workerList.add(new WorkerPojo("Ava Robinson", Date.valueOf("1994-02-28"), Level.MIDDLE, 4000));

        try (
                Connection connection = Database.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            for (WorkerPojo worker : workerList) {
                preparedStatement.setString(1, worker.getName());
                preparedStatement.setDate(2, worker.getDate());
                preparedStatement.setString(3, worker.getLevel());
                preparedStatement.setInt(4, worker.getSalary());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void populateClient() {
        String sqlQuery = "INSERT INTO client (name) VALUES (?)";

        List<ClientPojo> clientList = new ArrayList<>();
        clientList.add(new ClientPojo("Alice Johnson"));
        clientList.add(new ClientPojo("Bob Smith"));
        clientList.add(new ClientPojo("Claire Davis"));
        clientList.add(new ClientPojo("David Miller"));
        clientList.add(new ClientPojo("Emma Wilson"));
        try (
                Connection connection = Database.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            for (ClientPojo client : clientList) {
                preparedStatement.setString(1, client.getName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void populateProject() {
        String sqlQuery = "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)";

        List<ProjectPojo> projectList = new ArrayList<>();
        projectList.add(new ProjectPojo(1, Date.valueOf("2023-07-01"), Date.valueOf("2023-10-01")));
        projectList.add(new ProjectPojo(2, Date.valueOf("2022-07-01"), Date.valueOf("2023-01-01")));
        projectList.add(new ProjectPojo(3, Date.valueOf("2022-11-01"), Date.valueOf("2023-04-01")));
        projectList.add(new ProjectPojo(4, Date.valueOf("2021-11-01"), Date.valueOf("2022-09-01")));
        projectList.add(new ProjectPojo(1, Date.valueOf("2022-04-01"), Date.valueOf("2022-08-01")));
        projectList.add(new ProjectPojo(1, Date.valueOf("2023-06-01"), Date.valueOf("2023-11-01")));
        projectList.add(new ProjectPojo(2, Date.valueOf("2022-08-01"), Date.valueOf("2023-01-01")));
        projectList.add(new ProjectPojo(5, Date.valueOf("2023-02-01"), Date.valueOf("2023-05-01")));
        projectList.add(new ProjectPojo(4, Date.valueOf("2021-11-01"), Date.valueOf("2022-07-01")));
        projectList.add(new ProjectPojo(5, Date.valueOf("2022-06-01"), Date.valueOf("2023-01-01")));

        try (
                Connection connection = Database.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            for (ProjectPojo project : projectList) {
                preparedStatement.setInt(1, project.getClientId());
                preparedStatement.setDate(2, project.getStartDate());
                preparedStatement.setDate(3, project.getFinishDate());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void populateProjectWorker() {
        String sqlQuery = "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)";

        List<ProjectWorkerPojo> projectWorkerList = new ArrayList<>();
        projectWorkerList.add(new ProjectWorkerPojo(1, 1));
        projectWorkerList.add(new ProjectWorkerPojo(1, 2));
        projectWorkerList.add(new ProjectWorkerPojo(1, 3));
        projectWorkerList.add(new ProjectWorkerPojo(1, 4));
        projectWorkerList.add(new ProjectWorkerPojo(1, 5));
        projectWorkerList.add(new ProjectWorkerPojo(2, 8));
        projectWorkerList.add(new ProjectWorkerPojo(3, 7));
        projectWorkerList.add(new ProjectWorkerPojo(3, 9));
        projectWorkerList.add(new ProjectWorkerPojo(4, 10));
        projectWorkerList.add(new ProjectWorkerPojo(5, 10));
        projectWorkerList.add(new ProjectWorkerPojo(6, 9));
        projectWorkerList.add(new ProjectWorkerPojo(6, 5));
        projectWorkerList.add(new ProjectWorkerPojo(7, 3));
        projectWorkerList.add(new ProjectWorkerPojo(8, 4));
        projectWorkerList.add(new ProjectWorkerPojo(9, 4));
        projectWorkerList.add(new ProjectWorkerPojo(10, 5));

        try (
                Connection connection = Database.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        ) {
            for (ProjectWorkerPojo projectWorker : projectWorkerList) {
                preparedStatement.setInt(1, projectWorker.getProject_id());
                preparedStatement.setInt(2, projectWorker.getWorker_id());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}