package com.codecademy2.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.codecademy2.Course;
import com.codecademy2.Difficulty;
import com.codecademy2.Enrollment;
import com.codecademy2.Student;
import com.codecademy2.Webcast;

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

    // STUDENT

    public ObservableList getStudents() {
        try(Connection db = DriverManager.getConnection(url, user, password)) {
            PreparedStatement query = db.prepareStatement("SELECT * FROM Student");
            ResultSet result = query.executeQuery();

            ObservableList<Student> list = FXCollections.observableArrayList();

            while (result.next()) {
                list.add(new Student(result.getString("StudentEmail"), result.getString("Name"), result.getDate("BirthDate").toLocalDate(), result.getString("Gender"), result.getString("Adress"), result.getString("Country"), result.getString("City")));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error in getStudents");
            e.printStackTrace();
        }
        return null;
    }

    public void addStudent(Student student) {
        try(Connection db = DriverManager.getConnection(url, user, password)) {
            PreparedStatement query = db.prepareStatement("INSERT INTO Student VALUES(?, ?, ?, ?, ?, ?, ?)");
            query.setString(1, student.getEmail());
            query.setString(2, student.getName());
            query.setDate(3, java.sql.Date.valueOf(student.getBirthDate()));
            query.setString(4, student.getGender());
            query.setString(5, student.getAdress());
            query.setString(6, student.getCountry());
            query.setString(7, student.getCity());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in addStudent");
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        try(Connection db = DriverManager.getConnection(url, user, password)) {
            PreparedStatement query = db.prepareStatement("UPDATE Student SET Name = ?, BirthDate = ?, Gender = ?, Adress = ?, Country = ?, City = ? WHERE StudentEmail = ?"); 
            query.setString(1, student.getName());
            query.setDate(2, java.sql.Date.valueOf(student.getBirthDate()));
            query.setString(3, student.getGender());
            query.setString(4, student.getAdress());
            query.setString(5, student.getCountry());
            query.setString(6, student.getCity());
            query.setString(7, student.getEmail());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in updateStudent");
            e.printStackTrace(); 
        }
    }

    public void deleteStudent(Student student) {
        try(Connection db = DriverManager.getConnection(url, user, password)) {
            PreparedStatement query = db.prepareStatement("DELETE FROM Student WHERE StudentEmail = ?");
            query.setString(1, student.getEmail());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in deleteStudent");
            e.printStackTrace();
        }
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
