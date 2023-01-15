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
import javafx.stage.Stage;

public class AddEnrollmentController {
    public static void display(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        

        ChoiceBox certificate = new ChoiceBox();
        ChoiceBox student = new ChoiceBox();
        ChoiceBox course = new ChoiceBox();
        Label enrollment = new Label("Enrollment");
        enrollment.setFont(Font.font("Arial", FontWeight.BOLD, 30));



        Button back = new Button("Back");
        Button save = new Button("Save");
      
        HBox hBox = new HBox();
        hBox.getChildren().addAll(save, back);
        hBox.setSpacing(70);
        back.setPrefSize(50, 30);
        save.setPrefSize(50, 30);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(enrollment, certificate, student,course , hBox);
        
        vBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vBox);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        save.setOnAction(e -> {
           
        });

        back.setOnAction(e -> {
            stage.close();
        });
    }
}
