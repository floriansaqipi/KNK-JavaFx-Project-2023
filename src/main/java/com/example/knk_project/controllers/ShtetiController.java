package com.example.knk_project.controllers;

import com.example.knk_project.models.dto.CreateShtetiDto;
import com.example.knk_project.services.ShtetiService;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ShtetiServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class ShtetiController {
    private ValidatorInterface validator = new ValidatorService();
    private ShtetiServiceInterface shtetiService = new ShtetiService();


    @FXML
    private Label messageLabel;

    @FXML
    private TextField shtetiTextField;

    @FXML
    void shtoShtetinClick(ActionEvent event) {
       this.validateInputs();
        CreateShtetiDto createShtetiDto = new CreateShtetiDto(shtetiTextField.getText());
        try{

        this.shtetiService.register(createShtetiDto);
        this.messageLabel.setText("Successfully added state");
        } catch (SQLException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
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
