package com.example.knk_project.controllers;

import com.example.knk_project.SignupApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class SignUpAdminiController {



    @FXML
    private TextField emriTextField;

    @FXML
    private TextField mbiemriTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private PasswordField confirmPasswordField;



    @FXML
    public void signupacction(ActionEvent event) throws IOException {
       SignupApplication m = new SignupApplication();;
        m.changeScene("log-in-admin-view.fxml");

    }


}