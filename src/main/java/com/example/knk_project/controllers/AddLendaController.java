package com.example.knk_project.controllers;

import com.example.knk_project.models.dto.CreateShtetiDto;
import com.example.knk_project.services.exceptions.ValidationException;

import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class addLendaController {
    private ValidatorInterface validator = new ValidatorService();
    private Lenda


    @FXML
    private Label addStateLabel;

    @FXML
    private TextField lendaTextField;

    @FXML
    private Label messageLabel;

    @FXML
    void shtoLendenClick(ActionEvent event) {
        this.validateInputs();
        CreateShtetiDto createShtetiDto = new CreateShtetiDto(lendaTextField.getText());
        try{

            this.shtetiService.register(createShtetiDto);
            this.messageLabel.setText("Successfully added state");
        } catch (SQLException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
    }


    private void validateInputs(){
        this.validator.validateTextField(lendaTextField);
        try{
            this.validator.throwIfInvalid();
        }catch (ValidationException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }
    }

}

