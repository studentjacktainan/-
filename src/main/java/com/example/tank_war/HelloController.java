package com.example.tank_war;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void submitclicked(ActionEvent actionEvent) {

    }

    public void cancelclicked(ActionEvent actionEvent) {
    }
}