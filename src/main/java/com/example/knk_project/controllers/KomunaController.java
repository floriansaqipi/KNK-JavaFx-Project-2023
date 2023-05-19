package com.example.knk_project.controllers;

import com.example.knk_project.models.Shteti;
import com.example.knk_project.models.dto.CreateKomunaDto;
import com.example.knk_project.services.KomunaService;
import com.example.knk_project.services.ShtetiService;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.KomunaServiceInterface;
import com.example.knk_project.services.interfaces.ShtetiServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class KomunaController implements Initializable {

    private ValidatorInterface validator = new ValidatorService();
    private ShtetiServiceInterface shtetiService = new ShtetiService();
    private KomunaServiceInterface komunaService = new KomunaService();

    @FXML
    private TextField komunaTextField;

    @FXML
    private Label messageLabel;

    @FXML
    private ComboBox<Shteti> shtetiComboBox = new ComboBox<>();

    private List<Shteti> options = new ArrayList<>();

    @FXML
    void shtoKomunaClick(ActionEvent event) {
        this.validateInputs();

        String komunaName = this.komunaTextField.getText();
        int shtetiId = this.shtetiComboBox.getValue().getId();
        try {

            this.komunaService.insert(new CreateKomunaDto(komunaName, shtetiId));
        } catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }

    }

    private void validateInputs() {
        this.validator.validateTextField(komunaTextField);
        this.validator.validateComboBox(shtetiComboBox);
        try {
            this.validator.throwIfInvalid();
        } catch (ValidationException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.shtetiComboBox.getItems().addAll(this.shtetiService.getAllShtetet());
        } catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }

        this.shtetiComboBox.setConverter(new StringConverter<Shteti>() {

            @Override
            public String toString(Shteti object) {
                return object.getEmri();
            }

            @Override
            public Shteti fromString(String string) {
                return shtetiComboBox.getItems().stream().filter(ap ->
                        ap.getEmri().equals(string)).findFirst().orElse(null);
            }
        });
    }
}