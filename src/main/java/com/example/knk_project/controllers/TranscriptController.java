package com.example.knk_project.controllers;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TranscriptController implements Initializable {

    @FXML
    private PieChart piechart;

    @FXML
    private Label titlelabel;

    @FXML
    private TableView<GradeData> tableview;

    @FXML
    private TableColumn<GradeData, String> subjectColumn;

    @FXML
    private TableColumn<GradeData, String> professorColumn;

    @FXML
    private TableColumn<GradeData, Integer> gradeColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        titlelabel.setText("Transcript");


        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Grade 1", 10),
                new PieChart.Data("Grade 2", 20),
                new PieChart.Data("Grade 3", 15),
                new PieChart.Data("Grade 4", 25),
                new PieChart.Data("Grade 5", 30)
        );


        piechart.setData(pieChartData);


        ObservableList<GradeData> tableData = FXCollections.observableArrayList(
                new GradeData("Subject 1", "Professor 1", 1),
                new GradeData("Subject 2", "Professor 2", 2),
                new GradeData("Subject 3", "Professor 3", 3),
                new GradeData("Subject 4", "Professor 4", 4),
                new GradeData("Subject 5", "Professor 5", 5)
        );


        subjectColumn.setCellValueFactory(data -> data.getValue().subjectProperty());
        professorColumn.setCellValueFactory(data -> data.getValue().professorProperty());
        gradeColumn.setCellValueFactory(data -> data.getValue().gradeProperty().asObject());


        tableview.setItems(tableData);
    }

    public static class GradeData {
        private final String subject;
        private final String professor;
        private final int grade;

        public GradeData(String subject, String professor, int grade) {
            this.subject = subject;
            this.professor = professor;
            this.grade = grade;
        }

        public String getSubject() {
            return subject;
        }

        public String getProfessor() {
            return professor;
        }

        public int getGrade() {
            return grade;
        }

        public StringProperty subjectProperty() {
            return new SimpleStringProperty(subject);
        }

        public StringProperty professorProperty() {
            return new SimpleStringProperty(professor);
        }

        public IntegerProperty gradeProperty() {
            return new SimpleIntegerProperty(grade);
        }
    }
}