package com.example.knk_project.controllers;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.services.ProfesoriService;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ProfesoriServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class addProfesorLendaController implements Initializable {
    private ValidatorInterface validator = new ValidatorService();
    private ProfesoriServiceInterface profesoriService = new ProfesoriService();

    @FXML
    private ComboBox<Lenda> lendaComboBox;

    @FXML
    private Label messageLabel;

    @FXML
    private ComboBox<Profesori> profesoriComboBox;

    private List<Lenda> lendaOptions = new ArrayList<>();
    private List<Profesori> profesoriOptions = new ArrayList<>();

    @FXML
    void shtoLendenProfesoritClick(ActionEvent event) {
        this.validateInputs();
    }

    private void validateInputs() {
        this.validator.validateComboBox(lendaComboBox);
        this.validator.validateComboBox(profesoriComboBox);
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
            this.profesoriComboBox.getItems().addAll(this.profesoriService.getAllProfesoret());
        } catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }

        this.profesoriComboBox.setConverter(new StringConverter<Profesori>() {
            @Override
            public String toString(Profesori object) {
                return object.getEmri() + " " + object.getMbiemri() + " (" + object.getUsername() + ")";
            }

            @Override
            public Profesori fromString(String string) {
                return profesoriComboBox.getItems().stream().filter(ap ->
                        (ap.getEmri() + " " + ap.getMbiemri() + " (" + ap.getUsername() + ")")
                                .equals(string)).findFirst().orElse(null);
            }
        });
    }


}
