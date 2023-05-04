package com.example.knk_project.services.interfaces;

import com.example.knk_project.services.exceptions.ValidationException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public interface ValidatorInterface {
    void validateTextField(TextField textField) throws ValidationException;
    void validateDatePicker(DatePicker datePicker) throws ValidationException;
    void validateComboBox(ComboBox<String> comboBox) throws ValidationException;
    void validatePasswordField(PasswordField passwordField) throws ValidationException;
    void validatePhoneTextField(TextField textField) throws ValidationException;
    void validateEmailTextField(TextField textField) throws ValidationException;
    void validateUsernameTextField(TextField textField) throws ValidationException;
    void validateEmriTextField(TextField textField) throws ValidationException;
    void validateMbiemriTextField(TextField textField) throws ValidationException;

}
