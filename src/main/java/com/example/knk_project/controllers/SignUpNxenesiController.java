package com.example.knk_project.controllers;

import com.example.knk_project.models.dto.CreateNxenesiDto;
import com.example.knk_project.models.dto.CreatePrindiDto;
import com.example.knk_project.services.PasswordHasher;
import com.example.knk_project.services.SignUpNxenesiService;
import com.example.knk_project.services.exceptions.DifferentPasswordsException;
import com.example.knk_project.services.exceptions.UserAlreadyExistsException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.SignUpNxenesiServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.sql.Date;

public class SignUpNxenesiController implements Initializable {
    @FXML
    private TextField emriTextField;
    @FXML
    private TextField mbiemriTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private DatePicker dateLindjaDatePicker;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private ComboBox<String> vendLindjaComboBox;
    @FXML
    private ComboBox<String> komunaComboBox;
    @FXML
    private ComboBox<String> klasaComboBox;
    @FXML
    private TextField adresaTextField;
    @FXML
    private TextField emriPrinditTextField;
    @FXML
    private TextField mbiemriPrinditTextField;
    @FXML
    private TextField profesioniPrinditTextField;
    @FXML
    private TextField numriTelefonitPrinditTextField;
    @FXML
    private TextField emailPrinditTextField;

    @FXML
    private Label messageLabel;

    private String[] vendLindjaOptions = {"Gjilan","Malisheva"};
    private String[] komunaOptions = {"Gjilan","Malisheva"};
    private String[] klassaOptions = {"XII/1","XII/2"};

    private ValidatorInterface validator = new ValidatorService();
    private SignUpNxenesiServiceInterface signUpNxenesiService = new SignUpNxenesiService();

    public void signUpClick(){
        this.validateInputs();

        CreateNxenesiDto createNxenesiDto = this.initilializeCreateNxenesiDto();
        CreatePrindiDto createPrindiDto = this.initializeCreatePrindiDto();

        try{

        this.signUpNxenesiService.signUp(createNxenesiDto,createPrindiDto);
        this.messageLabel.setText("Succesfully added user");
        } catch (UserAlreadyExistsException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Username is taken");
        } catch (SQLException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }


    }

    private void validateInputs(){
            this.validator.validateEmriTextField(emriTextField);
            this.validator.validateMbiemriTextField(mbiemriTextField);
            this.validator.validateUsernameTextField(usernameTextField);
            this.validator.validateDatePicker(dateLindjaDatePicker);
            this.validator.validatePasswordField(passwordPasswordField);
            this.validator.validatePasswordField(confirmPasswordField);
            this.validator.validateComboBox(vendLindjaComboBox);
            this.validator.validateComboBox(komunaComboBox);
            this.validator.validateComboBox(klasaComboBox);
            this.validator.validateTextField(adresaTextField);
            this.validator.validateEmriTextField(emriPrinditTextField);
            this.validator.validateMbiemriTextField(mbiemriPrinditTextField);
            this.validator.validatePhoneTextField(numriTelefonitPrinditTextField);
            this.validator.validateEmailTextField(emailPrinditTextField);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.vendLindjaComboBox.getItems().addAll(this.vendLindjaOptions);
        this.komunaComboBox.getItems().addAll(this.komunaOptions);
        this.klasaComboBox.getItems().addAll(this.klassaOptions);
    }

    private CreateNxenesiDto initilializeCreateNxenesiDto(){
        String username = this.usernameTextField.getText();
        String emri =  this.emriTextField.getText();
        String mbiemri = this.mbiemriTextField.getText();
        LocalDate localDate = this.dateLindjaDatePicker.getValue();
        Date dateLindja = Date.valueOf(localDate);
        String password = this.passwordPasswordField.getText();
        String salt = PasswordHasher.generateSalt();
        String saltedPassword = PasswordHasher.generateSaltedHash(password,salt);
        int vendLindjaId = 1;
        int komunaId = 1;
        int klasaId = 1;

        return new CreateNxenesiDto(
                        username,
                        salt,
                        saltedPassword,
                        emri,
                        mbiemri,
                        dateLindja,
                        vendLindjaId,
                        komunaId,
                        klasaId
                );
    }
    private CreatePrindiDto initializeCreatePrindiDto(){
        String emriPrindit = this.emriPrinditTextField.getText();
        String mbiemriPrindit = this.mbiemriPrinditTextField.getText();
        String adresa = this.adresaTextField.getText();
        String profesioni = this.profesioniPrinditTextField.getText();
        String numriTelefonitPrindit = this.numriTelefonitPrinditTextField.getText();
        String emailPrindit = this.emailPrinditTextField.getText();

        return new CreatePrindiDto(
                        emriPrindit,
                        mbiemriPrindit,
                        profesioni,
                        adresa,
                        numriTelefonitPrindit,
                        emailPrindit
                );
    }
}
