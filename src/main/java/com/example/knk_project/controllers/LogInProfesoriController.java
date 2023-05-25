package com.example.knk_project.controllers;

import com.example.knk_project.services.ProfesoriService;
import com.example.knk_project.services.exceptions.IncorrectPasswordException;
import com.example.knk_project.services.exceptions.UserNotFoundException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ProfesoriServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;





public class LogInProfesoriController {
    private MainController mainController;
    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private Label messageLabel;

    private ProfesoriServiceInterface profesoriService = new ProfesoriService();

    private ValidatorInterface validatorService = new ValidatorService();

    public void logInClick(){
        this.validateInputs();
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();
        try{

            this.profesoriService.logIn(username,password);
            this.messageLabel.setText("Log in was successfull");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin-page-view"));
            this.mainController.setMainPane(fxmlLoader.load());
        }catch (UserNotFoundException exception){
            exception.printStackTrace();
            this.messageLabel.setText("User by username doesn't exist");
        } catch (IncorrectPasswordException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Password is incorrect");
        } catch (SQLException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        } catch (IOException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with loader");
        }

    }

    private void validateInputs(){
        this.validatorService.validateTextField(usernameTextField);
        this.validatorService.validatePasswordField(passwordPasswordField);
        try {
            this.validatorService.throwIfInvalid();
        } catch (ValidationException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }
    }


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
