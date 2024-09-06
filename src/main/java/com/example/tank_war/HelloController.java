package com.example.tank_war;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void submitclicked(ActionEvent actionEvent) throws IOException, SQLException {
        ArrayList<Object> params=new ArrayList<Object>();
        String sql_search="select * from userinfo where username= ? and userpwd= ? and email = ?";
        String sql_register="insert into userinfo (user_id,username, userpwd, email,registration_date) values(?,?,?,?,now())";
        String name=username.getText().trim();
        String pwd=password.getText().trim();
        String mail=email.getText().trim();
        params.add(name);
        params.add(pwd);
        params.add(mail);
        if(DbUtil.getexecuteQuery(sql_search,params).next()){
            try {
                Parent newSceneRoot = FXMLLoader.load(getClass().getResource("start-view.fxml"));
                Scene newScene = new Scene(newSceneRoot);
                Stage currentStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
                currentStage.setScene(newScene);
                System.out.println("ok");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            String uniqueID = UUID.randomUUID().toString().substring(0,8);
            params.add(0,uniqueID);
            DbUtil.getexecuteUpdate(sql_register,params);
            System.out.println("ok");
            Parent newSceneRoot = FXMLLoader.load(getClass().getResource("start-view.fxml"));
            Scene newScene = new Scene(newSceneRoot);
            Stage currentStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            currentStage.setScene(newScene);
            System.out.println("ok");
        }
    }

    public void cancelclicked(ActionEvent actionEvent) {
        Stage currentStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        currentStage.close(); // 關閉當前窗口
    }
}