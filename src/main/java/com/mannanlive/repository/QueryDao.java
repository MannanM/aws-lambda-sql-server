package com.mannanlive.repository;

import com.mannanlive.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDao<T> {
    private static final String SERVER_NAME = "your-server.ap-southeast-2.rds.amazonaws.com";
    private static final int SERVER_PORT = 1433;
    private static final String DATABASE_NAME = "your-db";
    private static final String DATABASE_USER = "your-username";
    private static final String DATABASE_PASSWORD = "your-password";
    private static final String DATABASE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public T executeSingleton(Query<T> query) {
        List<T> execute = execute(query);
        if (execute.isEmpty()) {
            return null;
        }
        return execute.get(0);
    }

    public List<T> execute(Query<T> query) {
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://" + SERVER_NAME + ":" + SERVER_PORT + ";databaseName=" + DATABASE_NAME;

        // Declare the JDBC objects.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish the connection.
            Class.forName(DATABASE_DRIVER);
            connection = DriverManager.getConnection(connectionUrl, DATABASE_USER, DATABASE_PASSWORD);

            // Create and execute an SQL statement that returns a set of data and then display it.
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query.getQuery());
            return query.translate(resultSet);
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            safeClose(resultSet);
            safeClose(statement);
            safeClose(connection);
        }
        return new ArrayList<>();
    }

    private void safeClose(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception ignored) {
            }
        }
    }
}