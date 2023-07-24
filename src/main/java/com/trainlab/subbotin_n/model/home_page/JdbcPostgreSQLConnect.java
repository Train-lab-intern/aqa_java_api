package com.trainlab.subbotin_n.model.home_page;

import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class JdbcPostgreSQLConnect {

    public void connectDataBase() {
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()){
                System.out.println("Connection to TrainLab DB succesfull!!!");

                Statement statement = conn.createStatement();

                ResultSet resultSet = statement.executeQuery("SELECT * FROM frontend_data");

                while (resultSet.next()) {
                    double id = resultSet.getDouble("front_id");
                    String text = resultSet.getString("text");
                    System.out.println(id + " - " + text);
                }
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    private Connection getConnection() throws SQLException, IOException{

        Properties info = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("database.properties"))){
            info.load(in);
        }

        String url = info.getProperty("url");
        String username = info.getProperty("username");
        String password = info.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}