package com.trainlab.subbotin_n.model.home_page;

import com.m11n.jdbc.ssh.SshDriver;

import java.sql.Connection;

import java.sql.*;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class JDBCPostgreSQLConnect {

    public static void postgresqlConnect() {
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

    private static Connection getConnection() throws SQLException, IOException{
        Properties info = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("database.properties"))){
            info.load(in);
        }

        return new SshDriver().connect(info.getProperty("url"), info);
    }
}