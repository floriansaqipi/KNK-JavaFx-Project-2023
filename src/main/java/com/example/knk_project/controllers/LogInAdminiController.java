package com.example.knk_project.controllers;


import com.example.knk_project.services.NxenesiService;
import com.example.knk_project.services.exceptions.IncorrectPasswordException;
import com.example.knk_project.services.exceptions.UserNotFoundException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.NxenesiServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class LogInAdminiController {

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private Label messageLabel;


    private NxenesiServiceInterface nxenesiService = new NxenesiService();

    private ValidatorInterface validatorSerice = new ValidatorService();

    public void logInClick(){
        this.validateInputs();
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();
        try{

            this.nxenesiService.logIn(username,password);
        }catch (UserNotFoundException exception){
            exception.printStackTrace();
            this.messageLabel.setText("User by username doesn't exist");
        } catch (IncorrectPasswordException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Password is incorrect");
        } catch (SQLException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }

    }

    private void validateInputs(){
        this.validatorSerice.validateTextField(usernameTextField);
        this.validatorSerice.validatePasswordField(passwordPasswordField);
        try {
            this.validatorSerice.throwIfInvalid();
        } catch (ValidationException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }
    }

}
