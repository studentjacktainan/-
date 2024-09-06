package com.example.tank_war;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EndView {
    public void viewRankClicked(ActionEvent actionEvent) {
    }

    public void returnToMainClicked(ActionEvent actionEvent) {
    }

    public void exitClicked(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
