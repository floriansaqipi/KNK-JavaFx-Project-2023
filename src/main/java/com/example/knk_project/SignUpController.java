package com.example.knk_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignUpController {

    @FXML
    private Label account;

    @FXML
    private TextField email;

    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private CheckBox privacyandpolicy;

    @FXML
    private Label signin;

    @FXML
    private Button signup;

    @FXML
    public void signupacction(ActionEvent event) throws IOException {
       SignupApplication m = new SignupApplication();;
        m.changeScene("login-admin-view.fxml");

    }


}