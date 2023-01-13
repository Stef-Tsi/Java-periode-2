package com.codecademy2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StudentController {
    public static void display(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        TableView table = new TableView();

        Label student = new Label("Student");
        student.setFont(new Font("Arial", 20));

        Button add = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        Button back = new Button("Exit");

        HBox hBox = new HBox();
        
        hBox.getChildren().addAll(add, edit, delete, back);
        hBox.setSpacing(25);

        add.setPrefSize(50, 30);
        edit.setPrefSize(50, 30);
        delete.setPrefSize(50,30);
        back.setPrefSize(50, 30);
        table.setEditable(false);
        TableColumn nameCol = new TableColumn("Name");
        TableColumn emailCol = new TableColumn("Email");
        TableColumn genderCol = new TableColumn("Gender");
        TableColumn adressCol = new TableColumn("Adress");
        TableColumn postcodeCol = new TableColumn("Postcode");
        TableColumn cityCol = new TableColumn("City");
        TableColumn countryCol = new TableColumn("Country");
        TableColumn enrollmentsCol = new TableColumn("Enrollments");
        TableColumn birthdayCol = new TableColumn("Birthday");

        table.getColumns().addAll(nameCol, emailCol, genderCol, adressCol, postcodeCol, cityCol, countryCol, enrollmentsCol, birthdayCol);
 
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, hBox);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vbox);
        
        Scene scene = new Scene(root);
        
        add.setOnAction(e -> {
            AddStudentController.diplay();
            stage.initModality(Modality.WINDOW_MODAL);
        });

        back.setOnAction(e -> {
            MainMenu.display();
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
    }
}
