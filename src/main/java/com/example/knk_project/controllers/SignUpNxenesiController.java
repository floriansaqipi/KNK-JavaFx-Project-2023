package com.example.knk_project.controllers;

import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

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

    public void signUpClick(){
        this.validateInputs();
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
            this.validator.throwIfInvalid();
        }catch (ValidationException exception){
            this.messageLabel.setText("Invalid inputs");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.vendLindjaComboBox.getItems().addAll(this.vendLindjaOptions);
        this.komunaComboBox.getItems().addAll(this.komunaOptions);
        this.klasaComboBox.getItems().addAll(this.klassaOptions);
    }
}
