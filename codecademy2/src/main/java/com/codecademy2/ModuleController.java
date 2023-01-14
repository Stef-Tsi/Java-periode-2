package com.codecademy2;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ModuleController {
    public static void display(){
        Stage stage = new Stage();
        stage.setTitle("Anhtuan Nguyen(2192526), Luuk beks(2192527), Miquel Stam(2192528)");
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.setResizable(false);

        FlowPane root = new FlowPane();
        TableView table = new TableView();

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
        TableColumn contactName = new TableColumn("Contact name");
        TableColumn contactEmail = new TableColumn("Contact Email");
        TableColumn moduleversion = new TableColumn("version");
        TableColumn follownumber = new TableColumn("Follow Number");
 

        table.getColumns().addAll(follownumber, moduleversion, contactName, contactEmail);
 
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.getChildren().addAll(table, hBox);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(vbox);
        
        Scene scene = new Scene(root);
        
        add.setOnAction(e -> {
            AddModuleController.display();
        });


        back.setOnAction(e -> {
            MainMenu.display();
            stage.close();
        });

        stage.setScene(scene);
        stage.show();
    }
}
