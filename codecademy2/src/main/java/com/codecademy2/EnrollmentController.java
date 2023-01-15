package com.codecademy2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

import com.codecademy2.DB.DbConnection;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class EnrollmentController {
    
    public static void display(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setResizable(false);

        Label enrollmentOverview = new Label("Enrollment overview");
        enrollmentOverview.setFont(Font.font("Arial",FontWeight.BOLD ,30));

        FlowPane root = new FlowPane();

        DbConnection db = new DbConnection();
        ObservableList list = db.getEnrollments();

        TableView<Enrollment> table = new TableView<>();

        table.setItems(list);
        TableColumn<Enrollment, String> studentEmail = new TableColumn<>("StudentEmail");
        studentEmail.setCellValueFactory(new PropertyValueFactory<Enrollment, String>("StudentEmail"));
        TableColumn<Enrollment, String> courseName = new TableColumn<>("CourseName");
        courseName.setCellValueFactory(new PropertyValueFactory<Enrollment, String>("CourseName"));
        TableColumn<Enrollment, LocalDateTime> dateTime = new TableColumn<>("DateTime");
        dateTime.setCellValueFactory(new PropertyValueFactory<Enrollment, LocalDateTime>("EnrollmentDateTime"));
        dateTime.setCellFactory(column -> {
            return new TableCell<Enrollment, LocalDateTime>() {
                @Override
                protected void updateItem(LocalDateTime item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
                    }
                }
            };
        });
        TableColumn<Enrollment, String> progress = new TableColumn<>("Progress");
        progress.setCellValueFactory(new PropertyValueFactory<Enrollment, String>("Progress"));

        table.getColumns().addAll(studentEmail, courseName, dateTime, progress);

        Button add = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        Button back = new Button("Back");

        HBox hBox = new HBox();
        
        hBox.getChildren().addAll(add, edit, delete, back);
        hBox.setSpacing(25);

        add.setPrefSize(50, 30);
        edit.setPrefSize(50, 30);
        delete.setPrefSize(80,30);
        back.setPrefSize(50, 30);
        table.setEditable(false);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(enrollmentOverview, table, hBox);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vbox);
        
        Scene scene = new Scene(root);
        
        add.setOnAction(e -> {
            AddEnrollmentController.display();
            stage.close();
        });

        back.setOnAction(e -> {
            MainMenu.display();
            stage.close();
        });

        edit.setOnAction(e -> {
            Enrollment enrollment = table.getSelectionModel().getSelectedItem();
            if (enrollment != null) {
                EditEnrollmentController.display(enrollment);
                stage.close();
            } else {
                System.out.println("No enrollment selected");
            }
            stage.close();
        });

        delete.setOnAction(e -> {
            Enrollment enrollment = table.getSelectionModel().getSelectedItem();
            if (enrollment == null) {
                return;
            }
            db.deleteEnrollment(enrollment);
            display();
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
    }
}
