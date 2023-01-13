package com.codecademy2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CourseController {
    public static void diplay(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        Button student = new Button("Student");
        Button back = new Button("Exit");
        student.setPrefSize(80, 40);
        back.setPrefSize(50, 20);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(student, back);
        vBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().add(vBox);
        Scene scene = new Scene(root);
        


        back.setOnAction(e -> {
            MainMenu.diplay();
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
    }
}
