package com.example.knk_project.services.interfaces;

import com.example.knk_project.services.exceptions.DifferentPasswordsException;
import com.example.knk_project.services.exceptions.ValidationException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public interface ValidatorInterface {
    void validateTextField(TextField textField) ;
    void validateGeneralPasswordField(PasswordField passwordField);
    void validateDatePicker(DatePicker datePicker) ;
    void validateComboBox(ComboBox<String> comboBox) ;
    void validatePasswordField(PasswordField passwordField) ;
    void validatePhoneTextField(TextField textField) ;
    void validateEmailTextField(TextField textField) ;
    void validateUsernameTextField(TextField textField) ;
    void validateEmriTextField(TextField textField) ;
    void validateMbiemriTextField(TextField textField) ;

    void validateMatchingPasswords(PasswordField passwordField, PasswordField confirmPasswordField) throws DifferentPasswordsException;

    void throwIfInvalid() throws ValidationException;

}
