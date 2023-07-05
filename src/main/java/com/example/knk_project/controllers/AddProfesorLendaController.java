package com.example.knk_project.controllers;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.ProfesoriLenda;
import com.example.knk_project.repositories.interfaces.ProfesoriLendaRepositoryInterface;
import com.example.knk_project.services.LendaService;
import com.example.knk_project.services.ProfesoriLendaService;
import com.example.knk_project.services.ProfesoriService;
import com.example.knk_project.services.exceptions.ProfesorLendaException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.LendaServiceInterface;
import com.example.knk_project.services.interfaces.ProfesoriLendaServiceInterface;
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

public class AddProfesorLendaController implements Initializable {
    private ValidatorInterface validator = new ValidatorService();
    private ProfesoriServiceInterface profesoriService = new ProfesoriService();
    private LendaServiceInterface lendaService = new LendaService();

    private ProfesoriLendaServiceInterface profesoriLendaService = new ProfesoriLendaService();

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
        try {
            this.validateInputs();
            int profesoriId = this.profesoriComboBox.getValue().getId();
            int lendaId = this.lendaComboBox.getValue().getId();
            ProfesoriLenda profesoriLenda = new ProfesoriLenda(profesoriId,lendaId);
            this.profesoriLendaService.insert(profesoriLenda);
            this.messageLabel.setText("Successfully added subject to professor");

        } catch (ValidationException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        } catch (ProfesorLendaException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Professor Lenda already exists");
        }catch (SQLException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
    }

    private void validateInputs() throws ValidationException {
        this.validator.validateComboBox(lendaComboBox);
        this.validator.validateComboBox(profesoriComboBox);
        this.validator.throwIfInvalid();
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
                return profesoriComboBox.getItems().stream().filter(ap -> (ap.getEmri() + " " + ap.getMbiemri() + " (" + ap.getUsername() + ")").equals(string)).findFirst().orElse(null);
            }
        });

        try {
            this.lendaComboBox.getItems().addAll(this.lendaService.getAllLendet());
        } catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }

        this.lendaComboBox.setConverter(new StringConverter<Lenda>() {
            @Override
            public String toString(Lenda object) {
                return object.getEmri();
            }

            @Override
            public Lenda fromString(String string) {
                return lendaComboBox.getItems().stream().filter(ap -> ap.getEmri().equals(string)).findFirst().orElse(null);
            }
        });
    }


}
