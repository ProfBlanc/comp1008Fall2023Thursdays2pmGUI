package com.example.comp1008fall2023thursdays2pmgui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

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

    }
    @FXML
    void onLogin(Event event) throws IOException {

        error.setText("");
        List<String> lines = Files.readAllLines(RegisterModel.pathFile);
        boolean found = false;

        for(String line : lines){
            String[] pieces = line.split("/");
            String currentUsername = pieces[0];
            String currentPassword = pieces[1];

            if(currentUsername.equals(username.getText()) && currentPassword.equals(password.getText())){
                found = true;
                break;
            }
        }

        if(found){

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
    void onLoginPart1(Event event) {

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
    void onRegisterClick(Event event) throws Exception{
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("register-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize(){

        //method runs right before STAGE is shown
        // all NODES have been loaded
        // equivelent window.onload

        error.setText("");
    }

}
