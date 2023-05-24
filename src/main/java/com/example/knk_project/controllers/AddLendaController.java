package com.example.knk_project.controllers;

import com.example.knk_project.models.dto.CreateLendaDto;
import com.example.knk_project.models.dto.CreateShtetiDto;
import com.example.knk_project.services.LendaService;
import com.example.knk_project.services.exceptions.ValidationException;

import com.example.knk_project.services.interfaces.LendaServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddLendaController {
    private ValidatorInterface validator = new ValidatorService();
    private LendaServiceInterface lendaService = new LendaService();


    @FXML
    private Label addStateLabel;

    @FXML
    private TextField lendaTextField;

    @FXML
    private Label messageLabel;

    @FXML
    void shtoLendenClick(ActionEvent event) {
        try{
        this.validateInputs();
        CreateLendaDto createLendaDto = new CreateLendaDto(lendaTextField.getText());
            this.lendaService.insert(createLendaDto);
            this.messageLabel.setText("Successfully added subject");
        } catch (ValidationException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }catch (SQLException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
    }


    private void validateInputs() throws ValidationException{
        this.validator.validateTextField(lendaTextField);
        this.validator.throwIfInvalid();
    }

}

