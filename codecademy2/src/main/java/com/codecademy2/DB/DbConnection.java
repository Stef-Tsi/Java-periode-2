package com.codecademy2.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codecademy2.Student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DbConnection {
    private String url;
    private String user;
    private String password;

    public DbConnection() {
        this.url = "jdbc:sqlserver://aei-sql2.avans.nl:1443;databaseName=LuukIsTheBest;";
        this.user = "LuukB";
        this.password = "Welkom!123";
    }

    public boolean makeConnection() {
        try (Connection db = DriverManager.getConnection(url, user, password)) {
                                                            //SUSER_SNAME() returns the current user
            PreparedStatement query = db.prepareStatement("SELECT SUSER_SNAME();");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                System.out.printf(result.getString(1));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ObservableList getStudents() {
        try(Connection db = DriverManager.getConnection(url, user, password)) {
            PreparedStatement query = db.prepareStatement("SELECT * FROM Student");
            ResultSet result = query.executeQuery();

            ObservableList<Student> list = FXCollections.observableArrayList();

            while (result.next()) {
                list.add(new Student(result.getString("StudentEmail"), result.getString("Name"), result.getString("BirthDate"), result.getString("Gender"), result.getString("Adress"), result.getString("Country"), result.getString("City")));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error in getStudents");
            e.printStackTrace();
        }
        return null;
    }

    public void close() {
        try {
            DriverManager.getConnection(url, user, password).close();
        } catch (SQLException e) {
            System.out.println("Error in close");
            e.printStackTrace();
        }
    }

}
