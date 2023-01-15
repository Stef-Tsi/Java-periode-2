module com.codecademy2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.codecademy2 to javafx.fxml;
    exports com.codecademy2;
    
    
}
