package com.example.knk_project.controllers;

import com.example.knk_project.models.*;
import com.example.knk_project.models.dto.UpdateProfesoriKlasaDto;
import com.example.knk_project.services.IntegerRoman;
import com.example.knk_project.services.KlasaService;
import com.example.knk_project.services.ProfesoriKlasaService;
import com.example.knk_project.services.ProfesoriService;
import com.example.knk_project.services.exceptions.ProfesorKlasaException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.KlasaServiceInterface;
import com.example.knk_project.services.interfaces.ProfesoriKlasaServiceInterface;
import com.example.knk_project.services.interfaces.ProfesoriServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditProfesoriKlasaController implements Initializable {

    private AdminProfesorKlasaTableView adminProfesorKlasaTableView;
    private TableProfesorKlasaController tableProfesorKlasaController;
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
    void editKlasenProfesoritClick(ActionEvent event) {

        try {
            this.validateInputs();
            int profesoriId = this.adminProfesorKlasaTableView.getProfesori().getId();
            int klasaId = this.adminProfesorKlasaTableView.getKlasa().getId();
            int profesoriIdNew = this.profesoriComboBox.getValue().getId();
            int klasaIdNew = this.klasaComboBox.getValue().getId();
            UpdateProfesoriKlasaDto updateProfesoriKlasaDto = new UpdateProfesoriKlasaDto(
                    profesoriId, klasaId, profesoriIdNew, klasaIdNew
            );
            this.profesoriKlasaService.update(updateProfesoriKlasaDto);
            this.messageLabel.setText("Successfully added subject to professor");
            this.close(event);
        } catch (ValidationException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }catch (ProfesorKlasaException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Professor Klasa already exists");
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

    private void close(ActionEvent event){
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        this.tableProfesorKlasaController.initData();
        stage.close();
    }

    public void initData() {

        this.loadInProfesoriComboBoxData();
        this.loadInKlasaComboBoxData();

    }

    private void loadInProfesoriComboBoxData(){
        this.profesoriComboBox.setValue(this.adminProfesorKlasaTableView.getProfesori());
    }

    private void loadInKlasaComboBoxData(){
        this.klasaComboBox.setValue(this.adminProfesorKlasaTableView.getKlasa());
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

    public void setAdminProfesorKlasaTableView(AdminProfesorKlasaTableView adminProfesorKlasaTableView) {
        this.adminProfesorKlasaTableView = adminProfesorKlasaTableView;
    }

    public void setTableProfesorKlasaController(TableProfesorKlasaController tableProfesorKlasaController) {
        this.tableProfesorKlasaController = tableProfesorKlasaController;
    }
}
