module com.example.brief7 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.brief7 to javafx.fxml;
    exports com.example.brief7;
}