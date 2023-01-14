package com.codecademy2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        FlowPane root = new FlowPane();
        Button add = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        Button back = new Button("Exit");
      
        add.setPrefSize(50, 30);
        edit.setPrefSize(50, 30);
        delete.setPrefSize(80,30);
        back.setPrefSize(50, 30);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(add, edit, delete, back);
        hBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().add(hBox);
        Scene scene = new Scene(root);
        


        back.setOnAction(e -> {
            MainMenu.display();
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
    }
}
