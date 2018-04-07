package com.jamesgalang;

import javax.xml.transform.Result;
import java.sql.*;

public class Main {

    public static void main(String[] args) {

//        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:testjava.db");
//            Statement statement = conn.createStatement();
//            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:testjava.db");
//                        conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts " +
                    " (name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Joe', 38574624, 'joe@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('Jane', 4564554645, 'jane@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) " +
//                    "VALUES('John', 957865, 'john@email.com')");

//            statement.execute("SELECT * FROM contacts");
//            ResultSet results = statement.getResultSet();

            ResultSet results = statement.executeQuery("SELECT * FROM contacts");
            while(results.next()) {
                System.out.println(results.getString("name") + " " +
                                   results.getInt("phone") + " " +
                                   results.getString("email"));
            }

            results.close();

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
