package com.example.knk_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpNxenesiController implements Initializable {
    @FXML
    private TextField emriTextField;
    @FXML
    private TextField mbiemriTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private DatePicker dateLindjaDatePicker;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private ComboBox<String> vendlinjdaComboBox;
    @FXML
    private ComboBox<String> komunaComboBox;
    @FXML
    private ComboBox<String> klasaComboBox;
    @FXML
    private TextField adresaTextField;
    @FXML
    private TextField emriPrinditTextField;
    @FXML
    private TextField mbiemriPrinditTextField;
    @FXML
    private TextField profesioniPrinditTextField;
    @FXML
    private TextField numriTelefonitPrinditTextField;
    @FXML
    private TextField emailPrinditTextField;

    public void signUpClick(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}