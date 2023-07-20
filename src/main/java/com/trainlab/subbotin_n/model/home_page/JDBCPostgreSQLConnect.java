package com.trainlab.subbotin_n.model.home_page;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;
import java.io.*;

public class JDBCPostgreSQLConnect {

    public static void main(String[] args) {

        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()){

                System.out.println("Connection to Store DB succesfull!");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");

            System.out.println(ex);
        }
    }

    public static Connection getConnection() throws SQLException, IOException{

        try {
            System.getProperties().load(ClassLoader.getSystemResourceAsStream("database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = System.getProperty("url");
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"url\"");
        }

        String username = System.getProperty("username");
        if (username == null || username.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"username\"");
        }

        String password = System.getProperty("password");
        if (password == null || password.isEmpty()) {
            throw new RuntimeException("В файле \"config.properties\" отсутствует значение \"password\"");
        }

        return DriverManager.getConnection(url, username, password);
    }
}