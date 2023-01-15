module com.codecademy2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.codecademy2 to javafx.fxml;
    exports com.codecademy2;
    exports com.codecademy2.Domain;
    exports com.codecademy2.GUI;
    exports com.codecademy2.DB;

    opens com.codecademy2.Domain to javafx.fxml;
    opens com.codecademy2.GUI to javafx.fxml;
    opens com.codecademy2.DB to javafx.fxml;
    

    
    
}
