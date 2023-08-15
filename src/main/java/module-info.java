module com.example.activecalc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.activecalc to javafx.fxml;
    exports com.example.activecalc;
}