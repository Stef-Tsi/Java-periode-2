package com.codecademy2.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DbConnection {

    public void makeConnection() {
        String url = "jdbc:sqlserver://aei-sql2.avans.nl:1443;databaseName=LuukIsTheBest;";
        String user = "LuukB";
        String password = "Welkom!123";
        try (Connection db = DriverManager.getConnection(url, user, password)) {
                                                            //SUSER_SNAME() returns the current user
            PreparedStatement query = db.prepareStatement("SELECT SUSER_SNAME();");
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
