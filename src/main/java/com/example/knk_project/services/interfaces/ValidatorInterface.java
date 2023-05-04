package com.example.knk_project.services.interfaces;

import com.example.knk_project.services.exceptions.ValidationException;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public interface ValidatorInterface {
    void validateTextField(TextField textField) throws ValidationException;

}
