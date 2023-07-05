package com.example.knk_project.controllers;

import com.example.knk_project.models.*;
import com.example.knk_project.models.dto.CreateNotaDto;
import com.example.knk_project.models.dto.UpdateNotaDto;
import com.example.knk_project.services.*;
import com.example.knk_project.services.exceptions.NotaExistsException;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.*;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditGradeController implements Initializable {
    private Profesori profesori;

    private ProfesoriNotaTableView profesoriNotaTableView;

    private TableNotaControllerNew tableNotaControllerNew;

    private NxenesiServiceInterface nxenesiService = new NxenesiService();

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
    private ValidatorInterface validator = new ValidatorService();
    private NotaServiceInterface notaService = new NotaService();

    public void setProfesori(Profesori profesori) {
        this.profesori = profesori;
    }
    public void setProfesoriNotaTableView(ProfesoriNotaTableView profesoriNotaTableView) {
        this.profesoriNotaTableView = profesoriNotaTableView;
    }

    public void setTableNotaControllerNew(TableNotaControllerNew tableNotaControllerNew) {
        this.tableNotaControllerNew = tableNotaControllerNew;
    }

    private void close(ActionEvent event){
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        this.tableNotaControllerNew.initData();
        stage.close();
    }


    @FXML
    void editNotenClick(ActionEvent event) throws SQLException {
        try {
            validateInputs();
        int id = this.profesoriNotaTableView.getNota().getId();
        int vlera = this.vleraNotesSpinner.getValue();
        int rubrika = this.rubrikaSpinner.getValue();
        int gjysmevjetori = this.gjysmevjetoriSpinner.getValue();
        int profesoriId = this.profesori.getId();
        int lendaId = this.lendaComboBox.getValue().getId();
        int nxenesiId = this.nxenesiComboBox.getValue().getId();
        UpdateNotaDto updateNotaDto = new UpdateNotaDto(
                id,
                vlera,
                rubrika,
                gjysmevjetori,
                profesoriId,
                lendaId,
                nxenesiId
        );
            this.notaService.update(updateNotaDto);
            this.messageLabel.setText("Successfully edited grade");
            this.close(event);
        }catch (ValidationException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        }
        catch (SQLException exception) {
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
        this.validator.validateComboBox(klasaComboBox);
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

    private void loadInSpinnerData(){
        this.vleraNotesSpinner.getValueFactory().setValue(this.profesoriNotaTableView.getNota().getVlera());
        this.gjysmevjetoriSpinner.getValueFactory().setValue(this.profesoriNotaTableView.getNota().getGjysmevjetori());
        this.rubrikaSpinner.getValueFactory().setValue(this.profesoriNotaTableView.getNota().getRubrika());
    }

    private void loadInKlasaComboBoxData() throws SQLException {
        Klasa klasa = this.klasaService.getKlasaByNxenesiId(this.profesoriNotaTableView.getNota().getNxenesiId());
        this.klasaComboBox.setValue(klasa);
        this.generateOtherComboBoxes(new ActionEvent());
    }

    private void loadInLendaComboBoxData(){
        this.lendaComboBox.setValue(this.profesoriNotaTableView.getLenda());
    }

    private void loadInNxenesiComboBoxData(){
        this.nxenesiComboBox.setValue(this.profesoriNotaTableView.getNxenesi());
    }


    public void generateOtherComboBoxes(ActionEvent event) {
//        System.out.println(this.klasaComboBox.getValue().getId());
        this.lendaComboBox.getItems().clear();
        this.nxenesiComboBox.getItems().clear();
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
            this.loadInSpinnerData();
            this.loadInKlasaComboBoxData();
            this.loadInLendaComboBoxData();
            this.loadInNxenesiComboBoxData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
