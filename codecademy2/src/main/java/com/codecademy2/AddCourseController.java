package com.codecademy2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddCourseController {
    public static void display(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        
        Scene scene = new Scene(root);
        Label course = new Label("Course");
        course.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        

        TextField courseName = new TextField();
        TextField courseTopic = new TextField();
        TextField courseIntroText = new TextField();
        TextField courseTag = new TextField();
        ChoiceBox difficulty = new ChoiceBox();

        courseIntroText.setPrefSize(500, 100);
        
        difficulty.getItems().addAll("Beginner", "Advanced", "Expert");

        courseName.setPromptText("Course name");
        courseTopic.setPromptText("Course topic");
        courseIntroText.setPromptText("Course Intro Text");
       
        Button back = new Button("Back");
        Button save = new Button("Save");
      
        HBox hBox = new HBox();
        hBox.getChildren().addAll(save, back);
        hBox.setSpacing(70);
        back.setPrefSize(50, 30);
        save.setPrefSize(50, 30);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(course, courseName,courseTopic, courseIntroText, difficulty, hBox);
        
        vBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vBox);

        back.setOnAction(e -> {
            stage.close();
        });

        

        stage.setScene(scene);
        stage.show();
    }
}
