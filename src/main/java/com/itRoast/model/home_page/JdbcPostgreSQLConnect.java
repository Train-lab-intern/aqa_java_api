package com.itRoast.model.home_page;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class JdbcPostgreSQLConnect {

    protected static Connection connection;
    protected static Statement statement;
    protected static ResultSet resultSet;

    public static Map<String, String> getDataFromDataBase() throws Exception {
        connectDataBase();
        statement = connection.createStatement();

        resultSet = statement.executeQuery("SELECT front_id, text FROM frontend_data");

        Map<String, String> dataFromDataBase = new HashMap<>();

        while (resultSet.next()) {
            dataFromDataBase.put(resultSet.getString("front_id"), resultSet.getString("text"));
        }

        closeConnect();

        dataFromDataBase = sortByKeys(dataFromDataBase);
        return dataFromDataBase;
    }

    private static void connectDataBase() {

        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            connection = getConnection();
            System.out.println("Connection to Store DB succesfull!");

        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    private static Connection getConnection() throws SQLException {

        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = System.getProperty("url");
        String username = System.getProperty("username");
        String password = System.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }

    private static <K, V> Map<K, V> sortByKeys(Map<K, V> unsortedMap)
    {
        return new TreeMap<>(unsortedMap);
    }

    private static void closeConnect() throws SQLException {
        connection.close();
    }
}