package com.trainlab.model.home_page;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class JdbcPostgreSQLConnect {

    protected static Connection connection;
    protected static Statement statement;
    protected static ResultSet resultSet;
    public static final Map<Double, String> expectedDataFromDb = new HashMap<>();

    public static void getDataFromHomePage() throws Exception {
        connectDataBase();
        statement = connection.createStatement();

        resultSet = statement.executeQuery("SELECT front_id, text FROM frontend_data");

        while (resultSet.next()) {
            expectedDataFromDb.put(resultSet.getDouble("front_id"), resultSet.getString("text"));
        }
    }

    private static void connectDataBase() throws Exception {
        Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        connection = getConnection();
    }

    private static Connection getConnection() throws SQLException, IOException {

        Properties info = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("database.properties"))) {
            info.load(in);
        }

        String url = info.getProperty("url");
        String username = info.getProperty("username");
        String password = info.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }

    public static void closeConnect() throws SQLException {
        connection.close();
    }
}