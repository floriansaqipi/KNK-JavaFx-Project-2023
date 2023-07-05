package com.example.knk_project.controllers;

import com.example.knk_project.models.dto.CreateProfesoriDto;
import com.example.knk_project.models.dto.CreateProfesoriDto;
import com.example.knk_project.services.ProfesoriService;
import com.example.knk_project.services.PasswordHasher;
import com.example.knk_project.services.exceptions.DifferentPasswordsException;
import com.example.knk_project.services.exceptions.UserAlreadyExistsException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ProfesoriServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


 public class SignUpProfesoriController {
    @FXML
    private TextField emriTextField;
    @FXML
    private TextField mbiemriTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField titleTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label messageLabel;

    private ValidatorInterface validator = new ValidatorService();
    private ProfesoriServiceInterface signUpProfesoriService = new ProfesoriService();

    public void signUpClick(){


       try{
       this.validateInputs();
       CreateProfesoriDto createProfesoriDto = this.initilializeCreateProfesoriDto();

          this.signUpProfesoriService.signUp(createProfesoriDto);
          this.messageLabel.setText("Successfully added user");
       } catch (ValidationException exception){
          exception.printStackTrace();
          this.messageLabel.setText("Invalid inputs");
       }catch (DifferentPasswordsException exception){
          exception.printStackTrace();
          this.messageLabel.setText("Passwords must match");
       }catch (UserAlreadyExistsException exception){
          exception.printStackTrace();
          this.messageLabel.setText("Username is taken");
       } catch (SQLException exception){
          exception.printStackTrace();
          this.messageLabel.setText("Something went wrong with the database");
       }


    }

    private void validateInputs() throws DifferentPasswordsException, ValidationException {

       this.validator.validateUsernameTextField(usernameTextField);
       this.validator.validatePasswordField(passwordPasswordField);
       this.validator.validatePasswordField(confirmPasswordField);
       this.validator.validateEmriTextField(emriTextField);
       this.validator.validateMbiemriTextField(mbiemriTextField);
       this.validator.validateTextField(titleTextField);


          this.validator.validateMatchingPasswords(passwordPasswordField,confirmPasswordField);
          this.validator.throwIfInvalid();

    }

    private CreateProfesoriDto initilializeCreateProfesoriDto(){
       String username = this.usernameTextField.getText();
       String password = this.passwordPasswordField.getText();
       String salt = PasswordHasher.generateSalt();
       String saltedPassword = PasswordHasher.generateSaltedHash(password,salt);
       String emri = this.emriTextField.getText();
       String mbiemri = this.mbiemriTextField.getText();
       String titulli = this.titleTextField.getText();

       return new CreateProfesoriDto(
               username,
               salt,
               saltedPassword,
               emri,
               mbiemri,
               titulli
       );
    }
}
