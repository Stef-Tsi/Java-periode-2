package com.codecademy2.GUI;

import com.codecademy2.DB.DbConnection;
import com.codecademy2.Domain.Student;

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

public class EditStudentController {
    private static String genderVal;

    public static void display(Student student) {
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2202133), Miquel Stam(2192528)");
        stage.setWidth(900);
        stage.setHeight(700);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        Label studentLabel = new Label("Student");
        studentLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        
        TextField name = new TextField();
        TextField email = new TextField();
        RadioButton male = new RadioButton("Male");
        RadioButton female = new RadioButton("Female");
        RadioButton other = new RadioButton("Other");
        if(student.getGender().equals("Male")){
            male.selectedProperty().set(true);
        }else if(student.getGender().equals("Other")){
            other.selectedProperty().set(true);
        }else if(student.getGender().equals("Female")){
            female.selectedProperty().set(true);
        }
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
        email.setText(student.getEmail());
        email.setEditable(false);
        name.setPromptText("Name");
        name.setText(student.getName());
        adress.setPromptText("Adress");
        adress.setText(student.getAdress());
        city.setPromptText("City");
        city.setText(student.getCity());
        country.setPromptText("Country");
        country.setText(student.getCountry());
        birthday.setPromptText("Birthday");
        birthday.setValue(student.getBirthDate());

        Button back = new Button("Back");
        Button update = new Button("Update");
        DbConnection dbConnection = new DbConnection();
        update.setOnAction(e -> {
            dbConnection.updateStudent(new Student(email.getText(), name.getText(), birthday.getValue(), genderVal, adress.getText(), country.getText(), city.getText()));
            stage.close();
            StudentController.display();
        });
      
        HBox hBox = new HBox();
        hBox.getChildren().addAll(update, back);
        hBox.setSpacing(70);
        back.setPrefSize(50, 30);
        update.setPrefSize(70, 30);

        VBox vBox = new VBox();
        HBox gender = new HBox();
        gender.getChildren().addAll(male, female, other);
        gender.setSpacing(5);
        vBox.getChildren().addAll(studentLabel, name, email, gender , adress, city, country, birthday, hBox);
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
