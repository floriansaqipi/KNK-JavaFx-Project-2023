package com.example.knk_project.services.validators;

import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Control;

public class ValidatorService implements ValidatorInterface {

    @Override
    public void validateTextField(TextField textField) throws ValidationException {

    }

    @Override
    public void validateDatePicker(DatePicker datePicker) throws ValidationException {
        if(datePicker.getValue() == null){
            this.setDefaultStyle(datePicker);
            datePicker.setPromptText("Zgjedh nje date");
            throw new ValidationException("Text field must not be empty");
        }
        this.setDefaultStyle(datePicker);
    }

    @Override
    public void validateComboBox(ComboBox<String> comboBox) throws ValidationException {
        if(comboBox.getValue().isEmpty()){
            this.setErrorStyle(comboBox);
            comboBox.setPromptText("Zgjedh nje opsion");
            throw new ValidationException("Text field must not be empty");
        }
        this.setDefaultStyle(comboBox);
    }

    @Override
    public void validatePasswordField(PasswordField passwordField) throws ValidationException {
        if(passwordField.getText().trim().length() < 9
                || !passwordField.getText().trim().matches(".*[0-9].*")){
            this.setErrorStyle(passwordField);
            passwordField.setPromptText("Sheno te paketen 8 karaktere dhe numra");
            throw new ValidationException("Text field must not be empty");
        }
        this.setDefaultStyle(passwordField);
    }

    @Override
    public void validatePhoneTextField(TextField textField) throws ValidationException {
        if(textField.getText().trim().matches("^\\d+$")){
            this.setErrorStyle(textField);
            textField.setPromptText("Sheno numer telefoni valid");
            throw new ValidationException("Text field must not be empty");
        }
        this.setDefaultStyle(textField);
    }

    @Override
    public void validateEmailTextField(TextField textField) throws ValidationException {
        if(textField.getText().trim().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){
            this.setErrorStyle(textField);
            textField.setPromptText("Sheno email valide");
            throw new ValidationException("Text field must not be empty");
        }
        this.setDefaultStyle(textField);
    }

    @Override
    public void validateUsernameTextField(TextField textField) throws ValidationException {
        if(textField.getText().trim().matches("[a-zA-Z0-9]+")){
            this.setErrorStyle(textField);
            textField.setPromptText("Sheno disa karaktere alfanumerike");
            throw new ValidationException("Text field error");
        }
        this.setDefaultStyle(textField);
    }

    @Override
    public void validateEmriTextField(TextField textField) throws ValidationException {
        if(textField.getText().trim().matches("[a-zA-Z]+")){
            this.setErrorStyle(textField);
            textField.setPromptText("Sheno disa karaktere alfabetike");
            throw new ValidationException("Text field error");
        }
        this.setDefaultStyle(textField);
    }

    @Override
    public void validateMbiemriTextField(TextField textField) throws ValidationException {
        if(textField.getText().trim().matches("[a-zA-Z]+")){
            this.setErrorStyle(textField);
            textField.setPromptText("Sheno disa karaktere alfabetike");
            throw new ValidationException("Text field error");
        }
        this.setDefaultStyle(textField);
    }

//    private void setErrorStyle(TextField textField){
//        textField.setStyle("-fx-border-color: red; -fx-prompt-text-fill: red;");
//    }
//    private void setDefaultStyle(TextField textField){
//        textField.setStyle("-fx-border-color: gray; -fx-prompt-text-fill: gray;");
//    }
//
//    private void passWordFieldSetErrorStyle(PasswordField passwordField){
//        passwordField.setStyle("-fx-border-color: red; -fx-prompt-text-fill: red;");
//    }
//
//    private void passWordFieldSetDefaultStyle(PasswordField passwordField){
//        passwordField.setStyle("-fx-border-color: gray; -fx-prompt-text-fill: gray;");
//    }
//
//    private void comboBoxSetErrorStyle(ComboBox<String> comboBox){
//        comboBox.setStyle("-fx-border-color: red; -fx-prompt-text-fill: red;");
//    }
//
//    private void comboBoxSetDefaultStyle(ComboBox<String> comboBox){
//        comboBox.setStyle("-fx-border-color: gray; -fx-prompt-text-fill: gray;");
//    }
    
    private void setErrorStyle(Control  control){
        control.setStyle("-fx-border-color: red; -fx-prompt-text-fill: red;");
    }
    
    private void setDefaultStyle(Control control){
        control.setStyle("-fx-border-color: gray; -fx-prompt-text-fill: gray;");
    }


}
