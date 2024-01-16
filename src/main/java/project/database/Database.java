package project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database {
    private static Database instance;

    private Database() {

    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        final String url = "jdbc:h2:./test";
        final String login = "";
        final String password = "";

        Connection connection;
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}