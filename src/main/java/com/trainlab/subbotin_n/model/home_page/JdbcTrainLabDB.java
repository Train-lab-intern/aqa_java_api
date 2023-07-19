package com.trainlab.subbotin_n.model.home_page;

import com.m11n.jdbc.ssh.SshConfiguration;
import com.m11n.jdbc.ssh.SshDriver;
import com.m11n.jdbc.ssh.SshTunnel;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class JdbcTrainLabDB {
    public static void main(String[] args) throws Exception {


//        SshConfiguration sshConfiguration = new SshConfiguration();
//
//        SshDriver sshDriver = new SshDriver();
//
//        SshTunnel sshTunnel = new SshTunnel(sshConfiguration);
//       Connection connection = DriverManager.getConnection(
//               "jdbc:postgresql://tldb-postgresql-fra1-81116-do-user-14346310-0.b.db.ondigitalocean.com:25060/trainlab",
//               "trainlab",
//               "AVNS_yXtS-TsJq6YJmCAe19y");

        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://tldb-postgresql-fra1-81116-do-user-14346310-0.b.db.ondigitalocean.com:25060/trainlab",
                "trainlab",
                "AVNS_yXtS-TsJq6YJmCAe19y");

       Statement statement = connection.createStatement();
       ResultSet results = statement.executeQuery("SELECT * FROM frontend_data");

       while(results.next()) {
           Integer id = results.getInt("front id");
           String text = results.getNString("text");

           System.out.println(results.getRow() + ". " + id + "\t"+ text);
       }
    }

}