package com.example.comp1008fall2023thursdays2pmgui;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class RegisterModel {


    private String username, password, confirmPassword;
    private static final int MIN_NUM = 5;
    static final Path pathRoot = Path.of("src","main",
            "resources", "com", "example", "comp1008fall2023thursdays2pmgui");
    static final Path pathFile = pathRoot.resolve("credentials.txt");
    public RegisterModel(){}

    private void saveData(){

        try{
            if(!Files.exists(pathRoot))
                Files.createDirectory(pathRoot);
            if(!Files.exists(pathFile))
                Files.createFile(pathFile);

            String content = String.format("%s/%s%n", username, password);
            Files.writeString(pathFile, content, StandardOpenOption.APPEND);

        }
        catch (Exception e){
            System.err.println(e);
        }

    }
    public void process(String username, String password, String confirmPassword) {
        setUsername(username);
        setPassword(password);
        setConfirmPassword(confirmPassword);

        saveData();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username.length() < MIN_NUM)
            throw new IllegalArgumentException("Username too short");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length() < MIN_NUM)
            throw new IllegalArgumentException("Password too short");
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        if(!confirmPassword.equals(password))
            throw new IllegalArgumentException("Password do not match");
        this.confirmPassword = confirmPassword;
    }
}
