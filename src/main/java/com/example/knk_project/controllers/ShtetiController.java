package com.example.knk_project.controllers;

import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ShtetiController {
    private ValidatorInterface validator = new ValidatorService();

    @FXML
    private Label addStateLabel;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField shtetiTextField;

    @FXML
    void shtoShtetinClick(ActionEvent event) {
       this.validateInputs();
    }

    private void validateInputs(){
        this.validator.validateTextField(shtetiTextField);
        try{
            this.validator.throwIfInvalid();
        }catch (ValidationException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }
    }

}
