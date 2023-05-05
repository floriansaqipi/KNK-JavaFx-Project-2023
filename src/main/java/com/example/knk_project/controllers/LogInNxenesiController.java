package com.example.knk_project.controllers;

import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInNxenesiController {
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Label messageLabel;

    private ValidatorInterface validatorService = new ValidatorService();

    public void logInClick(){

    }

    private void validateInputs(){

    }
}
