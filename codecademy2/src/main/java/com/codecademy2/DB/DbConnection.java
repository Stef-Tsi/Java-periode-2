package com.codecademy2.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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

    public void getAllCertificates() {
        try (Connection db = DriverManager.getConnection(url, user, password)) {
            PreparedStatement query = db.prepareStatement("SELECT * FROM Certificate;");
            ResultSet result = query.executeQuery();
            while (result.next()) {
                System.out.printf(result.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\n Done");
        }

    }


}
