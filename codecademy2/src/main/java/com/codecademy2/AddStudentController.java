package com.codecademy2;

import com.codecademy2.Logic.Logic;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddStudentController {
    public static void display(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(900);
        stage.setHeight(700);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        
        TextField name = new TextField();
        TextField email = new TextField();
        ChoiceBox gender = new ChoiceBox();
        gender.getItems().add("Male");
        gender.getItems().add("Female");
        gender.getItems().add("Non-Binary");

        TextField adress = new TextField();
        TextField postcodeCol = new TextField();
        TextField city = new TextField();
        TextField country = new TextField();
        TextField enrollments = new TextField();
        DatePicker birthday = new DatePicker();

        name.setPromptText("Name");
        email.setPromptText("Email");
        adress.setPromptText("Adress");
        postcodeCol.setPromptText("Postcode");
        city.setPromptText("City");
        country.setPromptText("Country");
        enrollments.setPromptText("Enrollments");
        birthday.setPromptText("Birthday");

        Button back = new Button("Back");
        Button save = new Button("Save");
      
        HBox hBox = new HBox();
        hBox.getChildren().addAll(save, back);
        hBox.setSpacing(70);
        back.setPrefSize(50, 30);
        save.setPrefSize(50, 30);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(name, email, gender , adress, postcodeCol, city, country, enrollments, birthday, hBox);

        vBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vBox);
        Scene scene = new Scene(root);
            
        back.setOnAction(e -> {
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
    }
    
}
