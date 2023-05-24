package com.example.knk_project.controllers;

import com.example.knk_project.models.dto.CreateKlasaDto;
import com.example.knk_project.services.KlasaService;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.KlasaServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class addClassController implements Initializable {


    @FXML
    private Spinner<Integer> klasaSpinner;

    @FXML
    private Label messageLabel;

    @FXML
    private Spinner<Integer> paraleljaSpinner;

    @FXML
    private TextField vitiShkollorTextField;


    private ValidatorInterface validator = new ValidatorService();
    private KlasaServiceInterface klasaService = new KlasaService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> klasaSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12, 6);
        this.klasaSpinner.setValueFactory(klasaSpinnerValueFactory);
        SpinnerValueFactory<Integer> paraleljaSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20, 1);
        this.paraleljaSpinner.setValueFactory(paraleljaSpinnerValueFactory);
    }

    @FXML
    void addClassClick() {
        this.validateInputs();

        CreateKlasaDto createKlasaDto = this.initilializeCreateKlasaDto();

        try {

            this.klasaService.register(createKlasaDto);
            this.messageLabel.setText("Succesfully added class");

        } catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
    }

    private void validateInputs() {

        this.validator.validateVitiShkollorTextField(vitiShkollorTextField);
        try {
            this.validator.throwIfInvalid();
        } catch (ValidationException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }
    }


    private CreateKlasaDto initilializeCreateKlasaDto() {
        int klasa = this.klasaSpinner.getValue();
        int paralelja = this.paraleljaSpinner.getValue();
        String vitiShkollor = this.vitiShkollorTextField.getText();


        return new CreateKlasaDto(
                klasa,
                paralelja,
                vitiShkollor
        );
    }
}
