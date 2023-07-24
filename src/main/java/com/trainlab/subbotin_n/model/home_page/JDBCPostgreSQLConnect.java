package com.trainlab.subbotin_n.model.home_page;

import io.github.emotionbug.jdbc.sshj.AbstractSshJDriver;
import io.github.emotionbug.jdbc.sshj.SshJDriver;

import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class JDBCPostgreSQLConnect {

    public void connectDbTrainLab() {
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = getConnection()){
                System.out.println("Connection to TrainLab DB succesfull!!!");
            }
        }
        catch(Exception ex){
            System.out.println("Connection failed...");
            System.out.println(ex);
        }
    }

    public Connection getConnection() throws SQLException, IOException{
        AbstractSshJDriver driver = new SshJDriver();
        Properties info = new Properties();

        try(InputStream in = Files.newInputStream(Paths.get("database.properties"))){
            info.load(in);
        }

//        String url = props.getProperty("url");
//        String username = props.getProperty("username");
//        String password = props.getProperty("password");

//        String str = "jdbc:postgresql://tldb-postgresql-fra1-81116-do-user-14346310-0.b.db.ondigitalocean.com:25060/trainlab?serverTimezone=Europe/Moscow&useSSL=false";




        return driver.connect("", info);
    }
}