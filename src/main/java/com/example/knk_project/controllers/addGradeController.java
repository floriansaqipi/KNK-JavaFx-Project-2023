package com.example.knk_project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class addGradeController implements Initializable {
    @FXML
    private Tab classSubjectTab;
    @FXML
    private Tab idTab;
    @FXML
    private Tab setGradeTab;


    @FXML
    private ComboBox chooseClassComboBox;
    @FXML
    private ComboBox chooseSubjectComboBox;

    @FXML
    private TextField idTextField;
    private TextField stdnameTextField;
    @FXML
    private TextField stdsurnameTextField;
    @FXML
    private RadioButton grade1Radio;
    @FXML
    private RadioButton grade2Radio;
    @FXML
    private RadioButton grade3Radio;
    @FXML
    private RadioButton grade4Radio;
    @FXML
    private RadioButton grade5Radio;
    @FXML
    private CheckBox confirmCheckBox;

    private Label label1;
    private Label label2;






    @FXML
    void select(ActionEvent event) {

    }
    public <resourceBundle> void initialize(URL url, resourceBundle rb){


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void contClick(ActionEvent actionEvent) {
    }

    public void contClick1(ActionEvent actionEvent) {
    }

    public void finishClick(ActionEvent actionEvent) {
    }
}
