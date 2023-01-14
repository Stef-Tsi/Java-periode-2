package com.codecademy2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CourseController {
    public static void display(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setResizable(false);

        BorderPane root = new BorderPane();
        
       
        Button back = new Button("Back");
        Button module = new Button("modules");
        Button addCourse = new Button("Add course");

        back.setPrefSize(80, 30);
        module.setPrefSize(80, 40);
        addCourse.setPrefSize(80, 40);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(module, addCourse, back);
        vBox.setSpacing(25);
        vBox.setAlignment(Pos.CENTER);
        root.setCenter(vBox);


        Scene scene = new Scene(root);
        
            module.setOnAction(e -> {
            ModuleController.display();
            stage.close();
        });

        addCourse.setOnAction(e -> {
            AddCourseController.display();
            stage.close();
        });

        back.setOnAction(e -> {
            MainMenu.display();
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
    }
}
