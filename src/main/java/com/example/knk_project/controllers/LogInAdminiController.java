package com.example.knk_project.controllers;

import com.example.knk_project.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogInAdminiController {

    @FXML
    private PasswordField passwordPasswordField;



    @FXML
    private TextField usernameTextField;


    @FXML
    void loginaction(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
//        LoginApplication m = new LoginApplication();
//        if(username.getText().toString().equals("javacoding") && password.getText().toString().equals("123")){
//            wrongLogIn.setText("Success!");
//
//            m.changeScene("sign-up-admin-view.fxml");
//        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
//            wrongLogIn.setText("Please enter your data");
//        }
//        else{
//            wrongLogIn.setText("Wrong username or password!");
//        }
  }


}
