package com.beniregev.demos_and_tutorials.examples;

import java.sql.*;

public class JDBCExample {
    private static final int MS_IN_SEC = 1000;
    private static final int MAX_ROWS_TO_RETRIEVE_AT_ONE_TIME = 10000;

    public static void main(String[] args) {
        System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        try {
            //Connection connection = DriverManager.getConnection(
            //        "jdbc:postgresql://localhost:5432/cookbook","postgres","admin");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://hh-pgsql-public.ebi.ac.uk:5432/pfmegrnargs",
                    "reader", "NWDMCE5xdipIjRrp");

            if (connection != null) {
                System.out.println("You made it, take control your database now!");
                Statement statement = connection.createStatement();
                statement.setFetchSize(MAX_ROWS_TO_RETRIEVE_AT_ONE_TIME);

                System.out.println("Reading car records...");
                System.out.printf("%-10.10s  %-10.10s  %-10.10s  %-10.10s%n", "rowCount", "dbid", "created", "last", "upi");
                final long retrieveStart = System.currentTimeMillis();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM xref WHERE timestamp > '2019-01-05'");
                //ResultSet resultSet = preparedStatement.executeQuery();
                final double seconds = (System.currentTimeMillis() - retrieveStart) / MS_IN_SEC;

                long rowCount = 0;
                while (resultSet.next()) {
                    rowCount++;
                    System.out.printf("%-10.10s  %-10.10s  %-10.10s  %-10.10s%n",
                            resultSet.getShort("dbid"),
                            resultSet.getInt("created"),
                            resultSet.getInt("last"),
                            resultSet.getString("upi"));
                }
                resultSet.close();
                System.out.println("Retrieve took " + seconds + " seconds and " +
                        (rowCount > 0 ? rowCount : "no") + " rows retrieved");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }

    }
}
