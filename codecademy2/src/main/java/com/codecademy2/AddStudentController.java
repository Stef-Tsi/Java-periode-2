package com.codecademy2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        TextField name = new TextField("Name");
        TextField email = new TextField("Email");
        TextField gender = new TextField("Gender");
        TextField adress = new TextField("adress");
        TextField postcodeCol = new TextField("postcode");
        TextField city = new TextField("City");
        TextField country = new TextField("Country");
        TextField enrollments = new TextField("enrollments");
        TextField birthday = new TextField("birthday");

        Button back = new Button("Back");
        
        
        back.setPrefSize(50, 30);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(name, email, gender , adress, postcodeCol, city, country, enrollments, birthday);

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
