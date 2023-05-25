package com.example.knk_project.controllers;

import com.example.knk_project.models.dto.CreateAdminiDto;
import com.example.knk_project.services.AdminiService;
import com.example.knk_project.services.PasswordHasher;
import com.example.knk_project.services.exceptions.DifferentPasswordsException;
import com.example.knk_project.services.exceptions.UserAlreadyExistsException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.AdminiServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class SignUpAdminiController {

    @FXML
    private TextField usernameTextField;
    @FXML
    private Label messageLabel;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private PasswordField confirmPasswordField;


    private ValidatorInterface validator = new ValidatorService();
    private AdminiServiceInterface signUpAdminiService = new AdminiService();

    public void signUpClick(){
        this.validateInputs();

        CreateAdminiDto createAdminiDto = this.initilializeCreateAdminiDto();

        try{

            this.signUpAdminiService.signUp(createAdminiDto);
            this.messageLabel.setText("Successfully added user");
        } catch (UserAlreadyExistsException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Username is taken");
        } catch (SQLException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }


    }

    private void validateInputs(){

        this.validator.validateUsernameTextField(usernameTextField);
        this.validator.validatePasswordField(passwordPasswordField);
        this.validator.validatePasswordField(confirmPasswordField);

        try{
            this.validator.validateMatchingPasswords(passwordPasswordField,confirmPasswordField);
            this.validator.throwIfInvalid();
        }catch (ValidationException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }catch (DifferentPasswordsException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Passwords must match");
        }
    }

    private CreateAdminiDto initilializeCreateAdminiDto(){
        String username = this.usernameTextField.getText();
        String password = this.passwordPasswordField.getText();
        String salt = PasswordHasher.generateSalt();
        String saltedPassword = PasswordHasher.generateSaltedHash(password,salt);

        return new CreateAdminiDto(
                username,
                salt,
                saltedPassword
        );
    }

}