package com.codecademy2.GUI;

import com.codecademy2.DB.DbConnection;
import com.codecademy2.Domain.Enrollment;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EditEnrollmentController {

    public static void display(Enrollment enrollment) {
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setResizable(false);

        Label enrollmentLabel = new Label("Enrollment");
        enrollmentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        DbConnection db = new DbConnection();
        FlowPane root = new FlowPane();
        ChoiceBox<String> studentEmail = new ChoiceBox<>();
        ObservableList<String> studentEmailList = db.getAllStudentEmails();
        studentEmail.getItems().addAll(studentEmailList);
        studentEmail.setValue(enrollment.getStudentEmail());
        studentEmail.getSelectionModel().selectedItemProperty().addListener((Observable, oldValue, newValue) -> {
            studentEmail.setValue(newValue);
        });

        ChoiceBox<String> courseName = new ChoiceBox<>();
        ObservableList<String> courseNameList = db.getAllCourseNames();
        courseName.getItems().addAll(courseNameList);
        courseName.setValue(enrollment.getCourseName());
        courseName.getSelectionModel().selectedItemProperty().addListener((Observable, oldValue, newValue) -> {
            courseName.setValue(newValue);
        });

        Button back = new Button("Back");
        Button save = new Button("Save");
      
        HBox hBox = new HBox();
        hBox.getChildren().addAll(save, back);
        hBox.setSpacing(70);
        back.setPrefSize(50, 30);
        save.setPrefSize(50, 30);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(enrollmentLabel, courseName, studentEmail, hBox);
        
        vBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vBox);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        save.setOnAction(e -> {
            db.updateEnrollment(new Enrollment(studentEmail.getValue().toString(),  courseName.getValue().toString(), enrollment.getEnrollmentDateTime()));
            stage.close();
            EnrollmentController.display();
        });

        back.setOnAction(e -> {
            stage.close();
        });
    }
    
}
