package com.example.knk_project.controllers;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.services.NotaService;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.NotaServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AddGradeController implements Initializable {

    @FXML
    private Spinner<Integer> gjysmevjetoriSpinner;

    @FXML
    private ComboBox<Lenda> lendaComboBox;

    @FXML
    private Label messageLabel;

    @FXML
    private ComboBox<Nxenesi> nxenesiComboBox;

    @FXML
    private Spinner<Integer> rubrikaSpinner;

    @FXML
    private Spinner<Integer> vleraNotesSpinner;

    @FXML
    void shtoNotenClick(ActionEvent event) {

    }

    private ValidatorInterface validator = new ValidatorService();
    private NotaServiceInterface notaService = new NotaService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> rubrikaSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2, 1);
        this.rubrikaSpinner.setValueFactory(rubrikaSpinnerValueFactory);
        SpinnerValueFactory<Integer> vleraNotesSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        this.vleraNotesSpinner.setValueFactory(vleraNotesSpinnerValueFactory);
        SpinnerValueFactory<Integer> gjysmevjetoriSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2, 1);
        this.gjysmevjetoriSpinner.setValueFactory(gjysmevjetoriSpinnerValueFactory);
    }

    private void validateInputs() throws ValidationException {
        this.validator.validateComboBox(lendaComboBox);
        this.validator.validateComboBox(nxenesiComboBox);
        this.validator.throwIfInvalid();
    }



}
