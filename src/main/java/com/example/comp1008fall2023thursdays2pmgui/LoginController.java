package com.example.comp1008fall2023thursdays2pmgui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    Label error;

    @FXML
    void onLoginp1(Event event) {

        System.out.println(username.getText());
        System.out.println(password.getText());

        String swap = password.getText();
        password.setText(username.getText());
        username.setText(swap);

    }    @FXML
    void onLogin(Event event) {

        error.setText("");
        if(username.getText().equals("admin") && password.getText().equals("pass")){
            System.out.println("Congrats");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Congrats");
            alert.setContentText("You have logged in!");
            alert.show();

        }
        else{
            error.setText("Invalid Username and/or Password");
        }

    }
    @FXML
    void initialize(){

        //method runs right before STAGE is shown
        // all NODES have been loaded
        // equivelent window.onload

        error.setText("");
    }

}
