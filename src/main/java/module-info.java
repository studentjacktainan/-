module com.example.tank_war {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tank_war to javafx.fxml;
    exports com.example.tank_war;
}