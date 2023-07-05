package com.example.knk_project.services.validators;

import com.example.knk_project.services.exceptions.DifferentPasswordsException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Control;

import java.util.ResourceBundle;

public class ValidatorService implements ValidatorInterface {
    private boolean isValid = true;

    private ResourceBundle bundle;

    public void setBundle(ResourceBundle bundle) {
//        System.out.println(bundle.getString("not.empty.val"));
        this.bundle = bundle;
    }

    @Override
    public void validateTextField(TextField textField)  {
        if(textField.getText().trim().isEmpty()){
            this.setErrorStyle(textField);
            if(bundle != null){

            textField.setPromptText(bundle.getString("not.empty.val"));
            }else {
                textField.setPromptText("Can't be empty");
            }
            this.isValid = false;
            return;
        }
        this.setDefaultStyle(textField);
    }

    @Override
    public void validateGeneralPasswordField(PasswordField passwordField) {
        if(passwordField.getText().trim().isEmpty()){
            this.setErrorStyle(passwordField);
            if(bundle != null){

            passwordField.setPromptText(bundle.getString("not.empty.val"));
            }else {
                passwordField.setPromptText("Can not be empty");
            }
            this.isValid = false;
            return;
        }
        this.setDefaultStyle(passwordField);
    }

    @Override
    public void validateDatePicker(DatePicker datePicker)  {
        if(datePicker.getValue() == null){
            this.setErrorStyle(datePicker);
            datePicker.setPromptText("Zgjedh nje date");
            this.isValid = false;
            return;
        }
        this.setDefaultStyle(datePicker);
    }

    @Override
    public <T> void validateComboBox(ComboBox<T> comboBox)  {
        if(comboBox.getValue() == null){
            this.setErrorStyle(comboBox);
            comboBox.setPromptText("Zgjedh nje opsion");
            this.isValid = false;
            return;
        }
        this.setDefaultStyle(comboBox);
    }

    @Override
    public void validatePasswordField(PasswordField passwordField)  {
        if(passwordField.getText().trim().length() < 8
                || !passwordField.getText().trim().matches(".*[0-9].*")){
            this.setErrorStyle(passwordField);
            passwordField.setPromptText("Sheno te paketen 8 karaktere dhe numra");
            this.isValid = false;
            return;
        }
        this.setDefaultStyle(passwordField);
    }

    @Override
    public void validatePhoneTextField(TextField textField)  {
        if(!textField.getText().trim().matches("^\\d+$")){
            this.setErrorStyle(textField);
            textField.setPromptText("Sheno numer telefoni valid");
            this.isValid = false;
            return;
        }
        this.setDefaultStyle(textField);
    }

    @Override
    public void validateEmailTextField(TextField textField){
        if(!textField.getText().trim().matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})?$")){
            this.setErrorStyle(textField);
            textField.setPromptText("Sheno email valide");
            this.isValid = false;
            return;
        }
        this.setDefaultStyle(textField);
    }

    @Override
    public void validateUsernameTextField(TextField textField)  {
        if(!textField.getText().trim().matches("[a-zA-Z0-9]{3,}")){
            this.setErrorStyle(textField);
            textField.setPromptText("Sheno (3 te pakten) karaktere alfanumerike");
            this.isValid = false;
            return;
        }
        this.setDefaultStyle(textField);
    }

    @Override
    public void validateEmriTextField(TextField textField)  {
        if(!textField.getText().trim().matches("[a-zA-Z]{2,}")){
            this.setErrorStyle(textField);
            textField.setPromptText("Sheno (2 te pakten) karaktere alfabetike");
            this.isValid = false;
            return;
        }
        this.setDefaultStyle(textField);
    }

    @Override
    public void validateMbiemriTextField(TextField textField)  {
        if(!textField.getText().trim().matches("[a-zA-Z]{2,}")){
            this.setErrorStyle(textField);
            textField.setPromptText("Sheno (2 te pakten) karaktere alfabetike");
            this.isValid = false;
            return;
        }
        this.setDefaultStyle(textField);
    }

    @Override
    public void validateVitiShkollorTextField(TextField textField) {
        if(!textField.getText().trim().matches("\\d{4}\\/\\d{4}")) {
            this.setErrorStyle(textField);
            textField.setPromptText("Sipas formatit yyyy/yyyy+1");
            this.isValid = false;
            return;
        }
        String[] numbers = textField.getText().split("/");
        Integer viti1 = Integer.parseInt(numbers[0]);
        Integer viti2 = Integer.parseInt(numbers[1]);
        if(viti2 - viti1 != 1) {
            this.setErrorStyle(textField);
            textField.setPromptText("Viti shkollor është i gabuar");
            this.isValid = false;
            return;
        }
        this.setDefaultStyle(textField);
    }

    @Override
    public void validateMatchingPasswords(PasswordField passwordField, PasswordField confirmPasswordField)
            throws DifferentPasswordsException {
                if(!passwordField.getText().trim().equals(confirmPasswordField.getText().trim())){
                    this.setErrorStyle(passwordField);
                    this.setErrorStyle(confirmPasswordField);
                    throw new DifferentPasswordsException("Passwords must be different");
                }
    }

    @Override
    public void throwIfInvalid() throws ValidationException {
        if(!this.isValid){
            this.isValid = true;
            throw new ValidationException("this is invalid");
        }
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
        control.setStyle("" +
                "-fx-border-color: red;" +
                " -fx-prompt-text-fill: red;" +
                " -fx-pref-width: 260;" +
                " -fx-pref-height:30;" +
                "-fx-border-radius:20;"+
                "-fx-background-radius:20");
    }
    
    private void setDefaultStyle(Control control){
        control.setStyle("" +
                "-fx-border-color: gray;" +
                " -fx-prompt-text-fill: gray;" +
                " -fx-pref-width: 260;" +
                " -fx-pref-height:30;" +
                "-fx-border-radius:20;"+
                "-fx-background-radius:20");
    }



}
