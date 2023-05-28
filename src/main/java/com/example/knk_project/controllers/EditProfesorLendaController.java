package com.example.knk_project.controllers;

import com.example.knk_project.models.AdminProfesorLendaTableView;
import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Profesori;
import com.example.knk_project.models.ProfesoriLenda;
import com.example.knk_project.models.dto.UpdateProfesoriKlasaDto;
import com.example.knk_project.services.LendaService;
import com.example.knk_project.services.ProfesoriLendaService;
import com.example.knk_project.services.ProfesoriService;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.LendaServiceInterface;
import com.example.knk_project.services.interfaces.ProfesoriLendaServiceInterface;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EditProfesorLendaController implements Initializable {
    private AdminProfesorLendaTableView adminProfesorLendaTableView;
    private TableProfesorLendaController tableProfesorLendaController;

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
    void editLendenProfesoritClick(ActionEvent event) {
        try {
            this.validateInputs();
            int profesoriId = this.adminProfesorLendaTableView.getProfesori().getId();
            int lendaId = this.adminProfesorLendaTableView.getLenda().getId();
            int newProfesoriId = this.profesoriComboBox.getValue().getId();
            int newLendaId = this.lendaComboBox.getValue().getId();
            UpdateProfesoriKlasaDto updateProfesoriKlasaDto =
                    new UpdateProfesoriKlasaDto(profesoriId,lendaId,newProfesoriId,newLendaId);
            this.profesoriLendaService.update(updateProfesoriKlasaDto);
            this.messageLabel.setText("Successfully updated subject to professor");
            this.close(event);

        } catch (ValidationException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        } catch (SQLException exception){
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
    }

    private void close(ActionEvent event){
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        this.tableProfesorLendaController.initData();
        stage.close();
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

    public void initData() {

            this.loadInProfesoriComboBoxData();
            this.loadInLendaComboBoxData();

    }

    private void loadInProfesoriComboBoxData(){
        this.profesoriComboBox.setValue(this.adminProfesorLendaTableView.getProfesori());
    }

    private void loadInLendaComboBoxData(){
        this.lendaComboBox.setValue(this.adminProfesorLendaTableView.getLenda());
    }

    public void setAdminProfesorLendaTableView(AdminProfesorLendaTableView adminProfesorLendaTableView) {
        this.adminProfesorLendaTableView = adminProfesorLendaTableView;
    }

    public void setTableProfesorLendaController(TableProfesorLendaController tableProfesorLendaController) {
        this.tableProfesorLendaController = tableProfesorLendaController;
    }
}
