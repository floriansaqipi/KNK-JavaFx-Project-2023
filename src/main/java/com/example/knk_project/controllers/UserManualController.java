package com.example.knk_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class UserManualController {
    private MainController mainController ;
    @FXML
    private Label manualLabel;

    @FXML
    private TextArea manualTextArea;


    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }



}
