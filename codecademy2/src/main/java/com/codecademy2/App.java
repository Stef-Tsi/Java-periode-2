package com.codecademy2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.codecademy2.DB.DbConnection;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Codecademy");

        DbConnection db = new DbConnection();
        if (db.makeConnection()) {
            System.out.println(" Connection made");
        } else {
            System.out.println(" Connection failed");
        }

        stage.setScene(scene);
        stage.show();
  
    }

    public static void main(String[] args) {
        launch();
    }

}