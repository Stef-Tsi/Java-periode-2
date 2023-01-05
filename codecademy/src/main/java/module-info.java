module com.codecademy {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.codecademy to javafx.fxml;
    exports com.codecademy;
}
