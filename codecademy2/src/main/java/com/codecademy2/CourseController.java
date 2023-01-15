package com.codecademy2;

import com.codecademy2.DB.DbConnection;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CourseController {
    public static void display(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setResizable(false);

        Label moduleOverview = new Label("Course overview");
        moduleOverview.setFont(Font.font("Arial",FontWeight.BOLD ,30));

        FlowPane root = new FlowPane();

        DbConnection db = new DbConnection();
        ObservableList list = db.getCourses();

        TableView<Course> table = new TableView<>();
        table.setItems(list);
        TableColumn<Course, String> courseName = new TableColumn<>("Course Name");
        courseName.setCellValueFactory(new PropertyValueFactory<Course, String>("CourseName"));
        TableColumn<Course, String> moduleId = new TableColumn<>("Module Id");
        moduleId.setCellValueFactory(new PropertyValueFactory<Course, String>("ModuleId"));
        TableColumn<Course, String> courseTopic = new TableColumn<>("Course Topic");
        courseTopic.setCellValueFactory(new PropertyValueFactory<Course, String>("CourseTopic"));
        TableColumn<Course, String> courseIntroText = new TableColumn<>("Course Intro Text");
        courseIntroText.setCellValueFactory(new PropertyValueFactory<Course, String>("CourseIntroText"));
        TableColumn<Course, String> courseTag = new TableColumn<>("Course Tag");
        courseTag.setCellValueFactory(new PropertyValueFactory<Course, String>("CourseTag"));

        TableColumn<Course, String> courseDifficulty = new TableColumn<>("Course Difficulty");
        courseDifficulty.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDifficulty().toString()));
    
        table.getColumns().addAll(courseName, moduleId,  courseTopic, courseIntroText, courseTag, courseDifficulty);

        Button addCourse = new Button("Add");
        Button edit = new Button("Edit");
        Button delete = new Button("Delete");
        Button modules = new Button("modules");
        Button back = new Button("Back");

        HBox hBox = new HBox();
        
        hBox.getChildren().addAll(addCourse, modules, edit, delete, back);
        hBox.setSpacing(25);

        addCourse.setPrefSize(50, 30);
        modules.setPrefSize(80, 30);
        edit.setPrefSize(50, 30);
        delete.setPrefSize(80,30);
        back.setPrefSize(50, 30);
        table.setEditable(false);
 
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(moduleOverview, table, hBox);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vbox);
        
        Scene scene = new Scene(root);
        
        modules.setOnAction(e -> {
            ModuleController.display();
            stage.close();
        });

        addCourse.setOnAction(e -> {
            AddCourseController.display();
            stage.close();
        });

        back.setOnAction(e -> {
            MainMenu.display();
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
    }
}
