package com.example.knk_project.controllers;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.repositories.KlasaRepository;
import com.example.knk_project.repositories.interfaces.KlasaRepositoryInterface;
import com.example.knk_project.services.IntegerRoman;
import com.example.knk_project.services.KlasaService;
import com.example.knk_project.services.NotaService;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.KlasaServiceInterface;
import com.example.knk_project.services.interfaces.NotaServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddGradeController implements Initializable {
    Profesori profesori;
    @FXML
    private Spinner<Integer> gjysmevjetoriSpinner;

    @FXML
    private ComboBox<Klasa> klasaComboBox;

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
    private KlasaServiceInterface klasaService =  new KlasaService();

    public void setProfesori(Profesori profesori) {
        this.profesori = profesori;
    }

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
        try{
        this.initializeKlasaComboBox();
        }catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
    }

    private void validateInputs() throws ValidationException {
        this.validator.validateComboBox(lendaComboBox);
        this.validator.validateComboBox(nxenesiComboBox);
        this.validator.throwIfInvalid();
    }

    private void initializeKlasaComboBox() throws SQLException {
        Platform.runLater(() -> {
            try {
                System.out.println(profesori.getId());
                this.klasaComboBox.getItems().addAll(this.klasaService.getAllKlasatByProfesorId(profesori.getId()));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });

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


    public void generateOtherComboBoxes(ActionEvent event) {
    }
}
