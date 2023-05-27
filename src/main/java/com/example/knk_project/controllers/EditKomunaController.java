package com.example.knk_project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditKomunaController {

    @FXML
    private Label AddCity;

    @FXML
    private TextField emriKomunesTextField;

    @FXML
    private TextField komunaIDTextField;

    @FXML
    void updateOnAction(ActionEvent event) {

    }

    void setTextField(int komunaID, String emriKomunes) {

        this.komunaIDTextField.setText(komunaID + "");
        this.emriKomunesTextField.setText(emriKomunes);

    }

}
