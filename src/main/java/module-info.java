module com.example.unwritiing {
    requires javafx.controls;
    requires javafx.fxml;

    opens Unwriting.ui to javafx.fxml;
    exports Unwriting.ui;

    opens com.example.unwritiing to javafx.fxml;
    exports com.example.unwritiing;
}