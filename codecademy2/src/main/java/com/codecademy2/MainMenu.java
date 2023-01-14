package com.codecademy2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import com.codecademy2.DB.DbConnection;

/**
 * JavaFX App
 */
public class MainMenu extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        Button student = new Button("Student");
        Button course = new Button("Course");
        Button enrollment = new Button("Enrollment");
        Button webcast = new Button("Webcast");
        Button exit = new Button("Exit");
        student.setPrefSize(80, 40);
        course.setPrefSize(80, 40);
        enrollment.setPrefSize(80, 40);
        webcast.setPrefSize(80, 40);
        exit.setPrefSize(50, 20);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(student, course, enrollment, webcast, exit);
        vBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().add(vBox);
        scene = new Scene(root);
        
        student.setOnAction(e -> {
           StudentController.display(); 
           stage.close();
        });

        course.setOnAction(e -> {
            CourseController.display();
            stage.close();
        });

        enrollment.setOnAction(e -> {
            EnrollmentController.display();
            stage.close();
        });

        webcast.setOnAction(e -> {
            WebcastController.display();
            stage.close();
        });

        exit.setOnAction(e -> {
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
  
    }
    public static void display(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        Button student = new Button("Student");
        Button course = new Button("Course");
        Button enrollment = new Button("Enrollment");
        Button webcast = new Button("Webcast");
        Button exit = new Button("Exit");
        student.setPrefSize(80, 40);
        course.setPrefSize(80, 40);
        enrollment.setPrefSize(80, 40);
        webcast.setPrefSize(80, 40);
        exit.setPrefSize(50, 20);
        VBox vBox = new VBox();
        vBox.getChildren().addAll(student, course, enrollment, webcast, exit);
        vBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().add(vBox);
        scene = new Scene(root);
        
        student.setOnAction(e -> {
           StudentController.display(); 
           stage.close();
        });

        course.setOnAction(e -> {
            CourseController.display();
            stage.close();
        });

        enrollment.setOnAction(e -> {
            EnrollmentController.display();
            stage.close();
        });

        webcast.setOnAction(e -> {
            WebcastController.display();
            stage.close();
        });

        exit.setOnAction(e -> {
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}