package com.example.knk_project.controllers;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.dto.CreateNotaDto;
import com.example.knk_project.repositories.interfaces.NxenesiRepositoryInterface;
import com.example.knk_project.services.*;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.*;
import com.example.knk_project.services.validators.ValidatorService;
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
    private KlasaServiceInterface klasaService = new KlasaService();
    private LendaServiceInterface lendaService = new LendaService();
    private NxenesiServiceInterface nxenesiService = new NxenesiService();
    private ValidatorInterface validator = new ValidatorService();
    private NotaServiceInterface notaService = new NotaService();

    public void setProfesori(Profesori profesori) {
        this.profesori = profesori;
    }

    @FXML
    void shtoNotenClick(ActionEvent event) throws SQLException {
        int vlera = this.vleraNotesSpinner.getValue();
        int rubrika = this.rubrikaSpinner.getValue();
        int gjysmevjetori = this.gjysmevjetoriSpinner.getValue();
        int profesoriId = this.profesori.getId();
        int lendaId = this.lendaComboBox.getValue().getId();
        int nxenesiId = this.nxenesiComboBox.getValue().getId();
        CreateNotaDto createNotaDto = new CreateNotaDto(
                vlera,
                rubrika,
                gjysmevjetori,
                profesoriId,
                lendaId,
                nxenesiId
        );
        try {
            this.notaService.insert(createNotaDto);
            this.messageLabel.setText("Successfully added grade");
        }catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> rubrikaSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2, 1);
        this.rubrikaSpinner.setValueFactory(rubrikaSpinnerValueFactory);
        SpinnerValueFactory<Integer> vleraNotesSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1);
        this.vleraNotesSpinner.setValueFactory(vleraNotesSpinnerValueFactory);
        SpinnerValueFactory<Integer> gjysmevjetoriSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 2, 1);
        this.gjysmevjetoriSpinner.setValueFactory(gjysmevjetoriSpinnerValueFactory);
        this.lendaComboBox.setVisible(false);
        this.nxenesiComboBox.setVisible(false);
    }

    private void validateInputs() throws ValidationException {
        this.validator.validateComboBox(lendaComboBox);
        this.validator.validateComboBox(nxenesiComboBox);
        this.validator.throwIfInvalid();
    }

    private void initializeKlasaComboBox() throws SQLException {
//        System.out.println(profesori.getId());
        this.klasaComboBox.getItems().clear();
        this.klasaComboBox.getItems().addAll(this.klasaService.getAllKlasatByProfesorId(profesori.getId()));
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
//        System.out.println(this.klasaComboBox.getValue().getId());
        this.lendaComboBox.setVisible(true);
        this.nxenesiComboBox.setVisible(true);
        try {

        this.initializeLendaComboBox();
        this.initializeNxenesiComboBox();
        } catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }

    }

    private void initializeLendaComboBox() throws SQLException {
//        this.lendaComboBox.getItems().clear();
//        System.out.println(profesori.getId());
        this.lendaComboBox.getItems().addAll(this.lendaService.getAllLendetByProfesoriId(profesori.getId()));


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

    private void initializeNxenesiComboBox() throws SQLException {
        int klasaId = this.klasaComboBox.getValue().getId();
//        System.out.println(klasaId);
        this.nxenesiComboBox.getItems().addAll(this.nxenesiService.getAllNxenesitByKlasaId(klasaId));
//        System.out.println(nxenesiComboBox.getItems());
        this.nxenesiComboBox.setConverter(new StringConverter<Nxenesi>() {
            @Override
            public String toString(Nxenesi object) {
                return  object.getEmri()+ " " + object.getMbiemri()  + " (" +  object.getUsername() + ")";
            }

            @Override
            public Nxenesi fromString(String string) {
                return nxenesiComboBox.getItems().stream().filter(ap ->
                        (ap.getEmri()+ " " + ap.getMbiemri()  + " (" +  ap.getUsername() + ")").equals(string))
                        .findFirst().orElse(null);
            }
        });

    }

    public void initData() {
        try {
            this.initializeKlasaComboBox();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
