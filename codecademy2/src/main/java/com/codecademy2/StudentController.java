package com.codecademy2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.codecademy2.*;
import com.codecademy2.DB.DbConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StudentController {
    public static void display() {
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setResizable(false);

        FlowPane root = new FlowPane();

        DbConnection db = new DbConnection();
        ObservableList list = db.getStudents();

        TableView<Student> table = new TableView<>();
        table.setItems(list);
        TableColumn<Student, String> emailCol = new TableColumn<>("email");
        emailCol.setCellValueFactory(new PropertyValueFactory<Student,
        String>("email"));
        TableColumn<Student, String> nameCol = new TableColumn<>("name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Student,
        String>("name"));
        TableColumn<Student, LocalDate> birthdayCol = new TableColumn<>("birthday");
        birthdayCol.setCellValueFactory(new PropertyValueFactory<Student,
        LocalDate>("birthDate"));
        TableColumn<Student, String> genderCol = new TableColumn<>("gender");
        genderCol.setCellValueFactory(new PropertyValueFactory<Student,
        String>("gender"));
        TableColumn<Student, String> adressCol = new TableColumn<>("adress");
        adressCol.setCellValueFactory(new PropertyValueFactory<Student,
        String>("adress"));
        TableColumn<Student, String> countryCol = new TableColumn<>("Country");
        countryCol.setCellValueFactory(new PropertyValueFactory<Student,
        String>("country"));
        TableColumn<Student, String> cityCol = new TableColumn<>("City");
        cityCol.setCellValueFactory(new PropertyValueFactory<Student,
        String>("city"));
        table.getColumns().addAll(emailCol, nameCol, birthdayCol, genderCol, adressCol, countryCol, cityCol);

        Label studentOverview = new Label("Student overview");
        studentOverview.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        Button add = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        Button back = new Button("Back");

        HBox hBox = new HBox();

        hBox.getChildren().addAll(add, edit, delete, back);
        hBox.setSpacing(25);

        add.setPrefSize(50, 30);
        edit.setPrefSize(50, 30);
        delete.setPrefSize(80, 30);
        back.setPrefSize(50, 30);
        table.setEditable(false);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(studentOverview, table, hBox);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vbox);

        Scene scene = new Scene(root);

        add.setOnAction(e -> {
            AddStudentController.display();
            stage.close();
        });

        back.setOnAction(e -> {
            MainMenu.display();
            stage.close();
        });

        edit.setOnAction(e -> {
            Student student = table.getSelectionModel().getSelectedItem();
            if (student != null) {
                EditStudentController.display(student);
                stage.close();
            } else {
                System.out.println("No student selected");
            }
        });

        delete.setOnAction(e -> {
            Student student = table.getSelectionModel().getSelectedItem();
            if (student != null) {
                db.deleteStudent(student);
                stage.close();
                display();
            } else {
                System.out.println("No student selected");
            }
        });

        stage.setScene(scene);
        stage.show();
    }
}
