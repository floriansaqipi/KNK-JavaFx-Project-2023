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
    private Tab idTab;
    private Tab setGradeTab;


    @FXML
    private ComboBox chooseClassComboBox;
    private ComboBox chooseSubjectComboBox;

    private TextField idTextField;
    private TextField stdnameTextField;
    private TextField stdsurnameTextField;
    private RadioButton grade1Radio;
    private RadioButton grade2Radio;
    private RadioButton grade3Radio;
    private RadioButton grade4Radio;
    private RadioButton grade5Radio;
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

}
