package com.example.comp1008fall2023thursdays2pmgui;

public class RegisterModel {


    private String username, password, confirmPassword;
    private static final int MIN_NUM = 5;
    public RegisterModel(){}

    public void process(String username, String password, String confirmPassword) {
        setUsername(username);
        setPassword(password);
        setConfirmPassword(confirmPassword);
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
