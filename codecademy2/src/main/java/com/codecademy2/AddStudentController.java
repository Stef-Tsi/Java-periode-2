package com.codecademy2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddStudentController {
    public static void diplay(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(700);
        stage.setHeight(500);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        //nameCol, emailCol, genderCol, adressCol, cityCol, countryCol, enrollmentsCol, birthdayCol
        Label nameCol = new Label("Name");
        Label emailCol = new Label("Email");
        Label genderCol = new Label("Gender");
        Label adressCol = new Label("Adress");
        Label postcodeCol = new Label("Postcode");
        Label cityCol = new Label("City");
        Label countryCol = new Label("Country");
        Label enrollmentsCol = new Label("Enrollments");
        Label birthdayCol = new Label("Birthday");

        TextField name = new TextField();
        TextField email = new TextField();
        TextField gender = new TextField();
        TextField adress = new TextField();
        TextField postcode = new TextField();
        TextField city = new TextField();
        TextField country = new TextField();
        TextField enrollments = new TextField();
        DatePicker birthday = new DatePicker();


        Button back = new Button("Back");
        
        
        back.setPrefSize(50, 30);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(name, email, gender , adress, postcode, city, country, enrollments, birthday);

        vBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vBox,back);
        Scene scene = new Scene(root);
        


        back.setOnAction(e -> {
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
    }
}
