package com.example.comp1008fall2023thursdays2pmgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private Label error;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password,confirmPassword;


    RegisterModel model = new RegisterModel();

    @FXML
    void onRegister(ActionEvent event) {

        try{
            model.process(username.getText(), password.getText(), confirmPassword.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Successfully Created the User");
            alert.setTitle("User Created!");
            alert.show();

            username.setText("");
            password.setText("");
            confirmPassword.setText("");
            error.setText("");
        }
        catch (Exception e){
            error.setText(e.getMessage());
        }

    }
    @FXML
    void initialize(){
        error.setText("");
    }



}
