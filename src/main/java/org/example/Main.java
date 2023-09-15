package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database-test", "root", "Maicoldevelhope12.");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM `table-sql`");

            ArrayList<String> surnames = new ArrayList<>();

            while (resultSet.next()) {
                String studentId = resultSet.getString("student_id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");

                String resultRow = "Student ID: " + studentId + ", Last Name: " + lastName + ", First Name: " + firstName;
                System.out.println(resultRow);
                surnames.add(lastName);
            }

            resultSet.close();
            statement.close();
            connection.close();

            System.out.println("Elenco dei cognomi:");
            for (String lastname : surnames) {
                System.out.println(lastname);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}