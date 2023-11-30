package com.example.comp1008fall2023thursdays2pmgui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    void onLogin(Event event) {

        System.out.println(username.getText());
        System.out.println(password.getText());

        String swap = password.getText();
        password.setText(username.getText());
        username.setText(swap);

    }

}
