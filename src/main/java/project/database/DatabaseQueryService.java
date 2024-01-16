package project.database;

import project.model.LongestProject;
import project.model.MaxProjectCountClient;
import project.model.MaxSalaryWorker;
import project.model.YoungestEldestWorkers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService implements QueryReader {
    public List<MaxProjectCountClient> findMaxProjectsClient() {
        String query = new DatabaseQueryService().readQueryFromFile("sql/find_max_projects_client.sql");
        List<MaxProjectCountClient> listMaxProjectCountClients = new ArrayList<>();

        try (
                Connection connection = Database.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                listMaxProjectCountClients.add(new MaxProjectCountClient(
                        resultSet.getString("name"),
                        resultSet.getInt("project_count")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMaxProjectCountClients;
    }

    public List<LongestProject> findLongestProject() {
        String query = new DatabaseQueryService().readQueryFromFile("sql/find_longest_project.sql");
        List<LongestProject> listLongestProject = new ArrayList<>();

        try (
                Connection connection = Database.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                listLongestProject.add(new LongestProject(
                        resultSet.getInt("id"),
                        resultSet.getInt("month_count")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listLongestProject;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String query = new DatabaseQueryService().readQueryFromFile("sql/find_max_salary_worker.sql");
        List<MaxSalaryWorker> listMaxSalaryWorker = new ArrayList<>();

        try (
                Connection connection = Database.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                listMaxSalaryWorker.add(new MaxSalaryWorker(
                        resultSet.getString("name"),
                        resultSet.getInt("salary")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMaxSalaryWorker;
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        String query = new DatabaseQueryService().readQueryFromFile("sql/find_youngest_eldest_workers.sql");
        List<YoungestEldestWorkers> listYoungestEldestWorkers = new ArrayList<>();

        try (
                Connection connection = Database.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            while (resultSet.next()) {
                listYoungestEldestWorkers.add(new YoungestEldestWorkers(
                        resultSet.getString("type"),
                        resultSet.getString("name"),
                        resultSet.getDate("birthday")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listYoungestEldestWorkers;
    }


}
