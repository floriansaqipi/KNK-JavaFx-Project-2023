package com.example.knk_project.services.validators;

import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.SingUpNxenesiValidatorInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpNxesnesiValidatorService implements ValidatorInterface, SingUpNxenesiValidatorInterface {

    
    @Override
    public void validateDatePicker(DatePicker datePicker) throws ValidationException {

    }

    @Override
    public void validateComboBox(ComboBox<String> comboBox) throws ValidationException {

    }

    @Override
    public void validatePasswordField(PasswordField passwordField) throws ValidationException {

    }

    @Override
    public void validatePhoneTextField(TextField textField) throws ValidationException {

    }

    @Override
    public void validateEmailTextField(TextField textField) throws ValidationException {

    }

    @Override
    public void validateUsernameTextField(TextField textField) throws ValidationException {

    }

    @Override
    public void validateTextField(TextField textField) throws ValidationException {

    }
}
