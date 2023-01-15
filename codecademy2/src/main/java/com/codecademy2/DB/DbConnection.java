package com.codecademy2.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.codecademy2.Course;
import com.codecademy2.Difficulty;
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

    // COURSE
    public ObservableList getCourses() {
        try(Connection db = DriverManager.getConnection(url, user, password)) {
            PreparedStatement query = db.prepareStatement("SELECT * FROM Course");
            ResultSet result = query.executeQuery();

            ObservableList<Course> list = FXCollections.observableArrayList();

            while (result.next()) {
                Difficulty difficulty;
                if (result.getString("CourseDifficulty") == "Beginner" || result.getString("CourseDifficulty") == "BEGINNER") {
                    difficulty = Difficulty.BEGINNER;
                } else if (result.getString("CourseDifficulty") == "Intermediate" || result.getString("CourseDifficulty") == "INTERMEDIATE") {
                    difficulty = Difficulty.ADVANCED;
                } else {
                    difficulty = Difficulty.EXPERT;
                }
                list.add(new Course(result.getString("CourseName"), result.getInt("ModuleId"), result.getString("CourseTopic"), result.getString("CourseIntroText"), result.getString("CourseTag"), difficulty));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error in getStudents");
            e.printStackTrace();
        }
        return null;
    }

    public void addCourse(Course course) {
        try(Connection db = DriverManager.getConnection(url, user, password)) {
            PreparedStatement query = db.prepareStatement("INSERT INTO Course VALUES(?, ?, ?, ?, ?, ?)");
            query.setString(1, course.getCourseName());
            query.setInt(2, course.getModuleId());
            query.setString(3, course.getCourseTopic());
            query.setString(4, course.getCourseIntroText());
            query.setString(5, course.getCourseTag());
            query.setString(6, course.getDifficulty().toString());
            query.executeUpdate();
            System.out.println("Course added");
        } catch (SQLException e) {
            System.out.println("Error in addCourse");
            e.printStackTrace();
        }
    }

    public void deleteCourse(Course course) {
        try(Connection db = DriverManager.getConnection(url, user, password)) {
            PreparedStatement query = db.prepareStatement("DELETE FROM Course WHERE CourseName = ?");
            query.setString(1, course.getCourseName());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in deleteCourse");
            e.printStackTrace();
        }
    }

    public void updateCourse(Course course) {
        try(Connection db = DriverManager.getConnection(url, user, password)) {
            PreparedStatement query = db.prepareStatement("UPDATE Course SET ModuleId = ?, CourseTopic = ?, CourseIntroText = ?, CourseTag = ?, CourseDifficulty = ? WHERE CourseName = ?"); 
            query.setInt(1, course.getModuleId());
            query.setString(2, course.getCourseTopic());
            query.setString(3, course.getCourseIntroText());
            query.setString(4, course.getCourseTag());
            query.setString(5, course.getDifficulty().toString());
            query.setString(6, course.getCourseName());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in updateCourse");
            e.printStackTrace(); 
        }
    }

    // MODULE
    public ObservableList getModuleIds() {
        try(Connection db = DriverManager.getConnection(url, user, password)) {
            PreparedStatement query = db.prepareStatement("SELECT ModuleId FROM Module");
            ResultSet result = query.executeQuery();

            ObservableList<String> list = FXCollections.observableArrayList();

            while (result.next()) {
                list.add(result.getString("ModuleId"));
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error in getModuleIds");
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
    
