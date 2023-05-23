package com.example.knk_project.controllers;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class addProfesoriKlasaController implements Initializable {
    ValidatorInterface validator = new ValidatorService();

    @FXML
    private ComboBox<Klasa> klasaComboBox;

    @FXML
    private Label messageLabel;

    @FXML
    private ComboBox<Profesori> profesoriComboBox;

    @FXML
    void shtoKlasenProfesoritClick(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.validateInputs();
    }

    private void validateInputs() {
        this.validator.validateComboBox(klasaComboBox);
        this.validator.validateComboBox(profesoriComboBox);
        try {
            this.validator.throwIfInvalid();
        } catch (ValidationException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }
    }
}
