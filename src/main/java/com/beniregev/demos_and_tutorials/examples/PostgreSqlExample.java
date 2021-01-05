package com.beniregev.demos_and_tutorials.examples;

import java.sql.*;
import java.util.Properties;

public class PostgreSqlExample {
    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/cookbook";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "admin");
            props.setProperty("ssl", "false");
            Connection conn = DriverManager.getConnection(url, props);
            System.out.println("Connected to PostgreSQL database!");

            Statement statement = conn.createStatement();
            System.out.println("Reading users records...");
//            System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                System.out.printf("%-30.30s  %-30.30s  %-30.30s%n",
                        resultSet.getString("name"),
                        resultSet.getString("fname"),
                        resultSet.getString("lname"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }

        //  TODO - Benny - uncomment and make this work
//        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")) {
//
//            System.out.println("Java JDBC PostgreSQL Example");
//            // When this class first attempts to establish a connection, it automatically loads any JDBC 4.0 drivers found within
//            // the class path. Note that your application must manually load any JDBC drivers prior to version 4.0.
////          Class.forName("org.postgresql.Driver");
//            System.out.println("Connected to PostgreSQL database!");
//
//            Statement statement = connection.createStatement();
//            System.out.println("Reading car records...");
//            System.out.printf("%-30.30s  %-30.30s%n", "Model", "Price");
//            //ResultSet resultSet = statement.executeQuery("SELECT * FROM public.cars");
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM xref where timestamp > '2019-01-05'");
//            while (resultSet.next()) {
//                System.out.printf("%-30.30s  %-30.30s%n", resultSet.getString("model"), resultSet.getString("price"));
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Connection failure.");
//            e.printStackTrace();
//        }
    }
}
