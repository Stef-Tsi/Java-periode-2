package com.codecademy2.GUI;


import com.codecademy2.DB.DbConnection;
import com.codecademy2.Domain.Student;
import com.codecademy2.Logic.Logic;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddStudentController {
    private static String genderVal;

    public static void display(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2202133), Miquel Stam(2192528)");
        stage.setWidth(900);
        stage.setHeight(700);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        Label student = new Label("Student");
        student.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        Label errorLabel = new Label();
        TextField name = new TextField();
        TextField email = new TextField();
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        RadioButton other = new RadioButton("Other");
        male.setOnAction(event -> {
            female.setSelected(false);
            other.setSelected(false);
            genderVal ="Male";
        });
        female.setOnAction(event -> {
            male.setSelected(false);
            other.setSelected(false);
            genderVal="Female";
        });
        other.setOnAction(event -> {
            male.setSelected(false);
            female.setSelected(false);
            genderVal="Other";
        });

        TextField adress = new TextField();
        TextField city = new TextField();
        TextField country = new TextField();
        DatePicker birthday = new DatePicker();
        
        email.setPromptText("Email");
        name.setPromptText("Name");
        adress.setPromptText("Adress");
        city.setPromptText("City");
        country.setPromptText("Country");
        birthday.setPromptText("Birthday");

        Button back = new Button("Back");
        Button save = new Button("Save");
        DbConnection dbConnection = new DbConnection();
        save.setOnAction(e -> {
            if (Logic.mailTool(email.getText()) == false || name.getText().isEmpty() || email.getText().isEmpty() || adress.getText().isEmpty() || city.getText().isEmpty() || country.getText().isEmpty() || birthday.getValue() == null || genderVal == null) {
                errorLabel.setText("Please fill in all the fields, \nand make sure the email is valid \n(example@example.example)");
                System.out.println("Email is not valid");
                email.clear();
                email.setPromptText("Email is not valid");
                return;
            }
            dbConnection.addStudent( new Student(email.getText(), name.getText(), birthday.getValue(), genderVal, adress.getText(), country.getText(), city.getText()));
            System.out.println(genderVal);
            stage.close();
            StudentController.display();
        });
      
        HBox hBox = new HBox();
        hBox.getChildren().addAll(save, back);
        hBox.setSpacing(70);
        back.setPrefSize(50, 30);
        save.setPrefSize(50, 30);

        VBox vBox = new VBox();
        HBox gender = new HBox();
        gender.getChildren().addAll(male, female, other);
        gender.setSpacing(5);
        vBox.getChildren().addAll(student, errorLabel, name, email, gender , adress, city, country, birthday, hBox);
        vBox.setSpacing(25);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vBox);
        Scene scene = new Scene(root);
            
        back.setOnAction(e -> {
            stage.close();
            StudentController.display();
        });

        stage.setScene(scene);
        stage.show();
    }
    
}
