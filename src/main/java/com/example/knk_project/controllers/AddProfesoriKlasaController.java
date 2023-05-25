package com.example.knk_project.controllers;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.ProfesoriKlasa;
import com.example.knk_project.models.ProfesoriLenda;
import com.example.knk_project.services.IntegerRoman;
import com.example.knk_project.services.KlasaService;
import com.example.knk_project.services.ProfesoriKlasaService;
import com.example.knk_project.services.ProfesoriService;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.KlasaServiceInterface;
import com.example.knk_project.services.interfaces.ProfesoriKlasaServiceInterface;
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
import java.util.ResourceBundle;

public class AddProfesoriKlasaController implements Initializable {
    ValidatorInterface validator = new ValidatorService();

    ProfesoriServiceInterface profesoriService = new ProfesoriService();
    KlasaServiceInterface klasaService = new KlasaService();

    ProfesoriKlasaServiceInterface profesoriKlasaService = new ProfesoriKlasaService();

    @FXML
    private ComboBox<Klasa> klasaComboBox;

    @FXML
    private Label messageLabel;

    @FXML
    private ComboBox<Profesori> profesoriComboBox;

    @FXML
    void shtoKlasenProfesoritClick(ActionEvent event) {

        try {
            this.validateInputs();
            int profesoriId = this.profesoriComboBox.getValue().getId();
            int klasaId = this.klasaComboBox.getValue().getId();
            ProfesoriKlasa profesoriKlasa = new ProfesoriKlasa(profesoriId,klasaId);
            this.profesoriKlasaService.insert(profesoriKlasa);
            this.messageLabel.setText("Successfully added subject to professor");
        } catch (ValidationException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        } catch (SQLException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            this.initializeProfesoriComboBox();
            this.initializeKlasaComboBox();
        } catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }


    }

    private void validateInputs() throws ValidationException {
        this.validator.validateComboBox(klasaComboBox);
        this.validator.validateComboBox(profesoriComboBox);
        this.validator.throwIfInvalid();
    }

    private void initializeProfesoriComboBox() throws SQLException {
        this.profesoriComboBox.getItems().addAll(this.profesoriService.getAllProfesoret());
        this.profesoriComboBox.setConverter(new StringConverter<Profesori>() {
            @Override
            public String toString(Profesori object) {
                return object.getEmri() + " " + object.getMbiemri() + " (" + object.getUsername() + ")";
            }

            @Override
            public Profesori fromString(String string) {
                return profesoriComboBox.getItems().stream().filter(ap -> (ap.getEmri() + " " + ap.getMbiemri() + " (" + ap.getUsername() + ")").equals(string)).findFirst().orElse(null);
            }
        });
    }

    private void initializeKlasaComboBox() throws SQLException {
        this.klasaComboBox.getItems().addAll(this.klasaService.getAllKlasat());
        this.klasaComboBox.setConverter(new StringConverter<Klasa>() {
            @Override
            public String toString(Klasa object) {
                return IntegerRoman.intToRoman(object.getKlasa()) + "/" + object.getParalelja() + " " + object.getViti();
            }

            @Override
            public Klasa fromString(String string) {
                return klasaComboBox.getItems().stream().filter(ap -> (IntegerRoman.intToRoman(ap.getKlasa()) + "/" + ap.getParalelja() + " " + ap.getViti()).equals(string)).findFirst().orElse(null);
            }
        });
    }
}
