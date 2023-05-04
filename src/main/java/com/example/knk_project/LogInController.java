package com.example.knk_project;

import com.example.knk_project.LoginApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogInController {

    @FXML
    private CheckBox RememberMe;

    @FXML
    private Label account;

    @FXML
    private Label forgetPassword;

    @FXML
    private Button login;

    @FXML
    private PasswordField password;

    @FXML
    private Label signup;

    @FXML
    private TextField username;

    @FXML
    private Label wrongLogIn;

    @FXML
    void loginaction(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        LoginApplication m = new LoginApplication();
        if(username.getText().toString().equals("javacoding") && password.getText().toString().equals("123")){
            wrongLogIn.setText("Success!");

            m.changeScene("signup-admin-view.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data");
        }
        else{
            wrongLogIn.setText("Wrong username or password!");
        }
    }

}