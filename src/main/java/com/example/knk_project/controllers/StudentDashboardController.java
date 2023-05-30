package com.example.knk_project.controllers;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.models.NxenesiDashboardTableView;
import com.example.knk_project.models.User;
import com.example.knk_project.services.*;
import com.example.knk_project.services.interfaces.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Array;
import java.sql.SQLException;
import java.util.*;

public class StudentDashboardController implements Initializable {


    private MainController mainController;
    private Nxenesi nxenesi;

    @FXML
    private TableColumn<NxenesiDashboardTableView, Integer> gjysmevjetoriTableColumn;

    @FXML
    private TableColumn<NxenesiDashboardTableView, String> lendaTableColumn;

    @FXML
    private LineChart<Integer, Integer> lineChart;

    @FXML
    private Label nrKlasaveLabel;

    @FXML
    private Label nrLendeveLabel;

    @FXML
    private TableColumn<NxenesiDashboardTableView, String> profesoriUsernameTableColumn;

    @FXML
    private TableColumn<NxenesiDashboardTableView, Integer> rubrikaNotesTableColumn;

    @FXML
    private TextField searchTextField;

    @FXML
    private Label suksesiLabel;

    @FXML
    private ComboBox<String> subjectFilterComboBox;

    @FXML
    private ComboBox<Integer> gradeValFilterComboBox;

    @FXML
    private TableView<NxenesiDashboardTableView> notatTableView;

    @FXML
    private TableColumn<NxenesiDashboardTableView, Integer> vleraNotesTableColumn;

    private NxenesiDashboardServiceInterface nxenesiDashboardService = new NxenesiDashboardService();
    private NotaServiceInterface notaService = new NotaService();
    private LendaServiceInterface lendaService = new LendaService();
    private NxenesiServiceInterface nxenesiService = new NxenesiService();
    private ProfesoriServiceInterface profesoriService = new ProfesoriService();
    private KlasaServiceInterface klasaService = new KlasaService();


    ObservableList<NxenesiDashboardTableView> listOfNxenesiDashboardTableView;


    @FXML
    public void goBackDashboard(ActionEvent event) {
        BorderPane nxenesiPagePane = null;
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/studentpage-view.fxml"));
            nxenesiPagePane = fxmlLoader.load();
            StudentPageController studentPageController = fxmlLoader.getController();
            studentPageController.setMainController(mainController);
            studentPageController.setNxenesi(nxenesi);
            studentPageController.initData();
            mainController.setMainPane(nxenesiPagePane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void initData() {
        try {
            this.suksesiLabel.setText(this.notaService.getAverageGrade(this.nxenesi.getId()) + " ");
            this.nrLendeveLabel.setText(this.lendaService.getNumberOfLendeveOfNxenesi(this.nxenesi.getId()) + " ");
            Klasa klasaENxenesit = this.klasaService.getKlasaByNxenesiId(nxenesi.getId());
            this.nrKlasaveLabel.setText(
                    klasaENxenesit.getKlasa() + " / " +
                            klasaENxenesit.getParalelja());

            listOfNxenesiDashboardTableView = FXCollections.observableArrayList(this.nxenesiDashboardService.getNxenesiDashboardTableView(nxenesi.getId()));
            this.initializeNotatTableView();
            this.initializeLinechart();
            this.initializeFiltersComboBox();
            this.initializeSearchTextField();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setNxenesi(Nxenesi nxenesi) {
        this.nxenesi = nxenesi;
    }

    private void initializeNotatTableView() throws SQLException {
        vleraNotesTableColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getVleraNotes()).asObject());
        rubrikaNotesTableColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getRubrikaNotes()).asObject());
        gjysmevjetoriTableColumn.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().getGjysmevjetoriNotes()).asObject());
        lendaTableColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getEmriLendes()));
        profesoriUsernameTableColumn.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getProfesoriUsername()));

        notatTableView.setItems(listOfNxenesiDashboardTableView);
    }

    private void initializeSearchTextField() {
        FilteredList<NxenesiDashboardTableView> filteredData = new FilteredList<>(listOfNxenesiDashboardTableView, b -> true);
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(nota -> {
                if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                    return true;
                }
                String searchKeyWord = newValue.toLowerCase();

                if (nota.getEmriLendes().toLowerCase().contains(searchKeyWord)) {
                    return true;
                } else if (nota.getProfesoriUsername().toLowerCase().contains(searchKeyWord)) {
                    return true;
                } else if (Integer.toString(nota.getVleraNotes()).toLowerCase().contains(searchKeyWord)) {
                    return true;
                } else if (Integer.toString(nota.getRubrikaNotes()).contains(searchKeyWord)) {
                    return true;
                } else if (Integer.toString(nota.getGjysmevjetoriNotes()).toLowerCase().contains(searchKeyWord)) {
                    return true;
                } else {
                    return false;
                }
            });

        });

        SortedList<NxenesiDashboardTableView> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(notatTableView.comparatorProperty());
        notatTableView.setItems(sortedData);

    }

    private void initializeLinechart() {
        int i = 0;
        XYChart.Series series = new XYChart.Series();
        series.setName("Notat");
        for (NxenesiDashboardTableView n : listOfNxenesiDashboardTableView) {

            series.getData().add(new XYChart.Data<>(Integer.toString(i), n.getVleraNotes()));
            i++;

        }
        lineChart.getData().add(series);
    }

    private void initializeFiltersComboBox() {
        ArrayList<String> subjectOptions = new ArrayList<>();
        ArrayList<Integer> gradeOptions = new ArrayList<>();
        for (NxenesiDashboardTableView n : listOfNxenesiDashboardTableView) {
            if (!subjectOptions.contains(n.getEmriLendes())) {
                subjectOptions.add(n.getEmriLendes());
                this.subjectFilterComboBox.getItems().add(n.getEmriLendes());

            }
            if (!gradeOptions.contains(n.getVleraNotes())) {
                gradeOptions.add(n.getVleraNotes());
                this.gradeValFilterComboBox.getItems().add(n.getVleraNotes());
            }



        }
        this.subjectFilterComboBox.getItems().add("Asnjëra");
        this.gradeValFilterComboBox.getItems().add(0);
        Collections.sort(gradeValFilterComboBox.getItems());
//         String[] subjectOptionsAsArray = (String[]) subjectOptions.toArray();
//         Integer[] gradeOptionsAsArray = (Integer[]) gradeOptions.toArray();
//        this.subjectFilterComboBox.getItems().addAll(subjectOptionsAsArray);
//        this.gradeValFilterComboBox.getItems().addAll(gradeOptionsAsArray);
    }


    void gradeFiltering() throws SQLException {
        Integer grade = this.gradeValFilterComboBox.getValue();
        if(grade != 0) {
            this.listOfNxenesiDashboardTableView = FXCollections.observableArrayList(this.nxenesiDashboardService.filterNotatByValue(grade));
            initializeSearchTextField();
        }
    }


    void subjectFiltering() throws SQLException {
        String subject = this.subjectFilterComboBox.getValue();
        if(!subject.equals("Asnjëra")) {
            this.listOfNxenesiDashboardTableView = FXCollections.observableArrayList(this.nxenesiDashboardService.filterNotatBySubject(subject));
            initializeSearchTextField();
        }
    }

    void gradeAndSubjectFiltering() throws SQLException {
        Integer grade = this.gradeValFilterComboBox.getValue();
        if(grade != 0) {
            String subject = this.subjectFilterComboBox.getValue();
            this.listOfNxenesiDashboardTableView = FXCollections.observableArrayList(this.nxenesiDashboardService.filterNotatByGradeAndBySubject(grade, subject));
            initializeSearchTextField();
        }
    }


    @FXML
    void filterTable(ActionEvent event) throws SQLException {

        this.searchTextField.setText("");
        if (gradeValFilterComboBox.getValue() != null) {
            this.gradeFiltering();
        }
        if (subjectFilterComboBox.getValue() != null) {
            this.subjectFiltering();
        }

        if (subjectFilterComboBox.getValue() != null && gradeValFilterComboBox.getValue() != null
              && !Objects.equals(subjectFilterComboBox.getValue(), "Asnjëra") && gradeValFilterComboBox.getValue() != 0 ) {

            this.gradeAndSubjectFiltering();
        }

        if(Objects.equals(subjectFilterComboBox.getValue(), "Asnjëra") && gradeValFilterComboBox.getValue() == 0 ){
            listOfNxenesiDashboardTableView = FXCollections.observableArrayList(this.nxenesiDashboardService.getNxenesiDashboardTableView(nxenesi.getId()));
        }
        this.notatTableView.setItems(this.listOfNxenesiDashboardTableView);
        initializeSearchTextField();
    }
}