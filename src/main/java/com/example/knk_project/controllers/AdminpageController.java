package com.example.knk_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminpageController implements Initializable {
    @FXML
    private AnchorPane ap;
    @FXML
    private BorderPane bp;

    @FXML
    public void shtoshtetin(MouseEvent event) {
        loadPage("shto-shtetin-view");
    }
    @FXML
    public void shtokomunen(MouseEvent event) {
        loadPage("shto-komuna-view");
    }
    @FXML
    public void shtoprofesorKlasen(MouseEvent event) {
        loadPage("shto-profesor-klasa");
    }
    @FXML
    public void shtoklasen(MouseEvent event) {
        loadPage("add-class-view");
    }
    @FXML
    public void shtolenden(MouseEvent event) {
        loadPage("add-subject-view");
    }
    @FXML
    public void shtoprofesorLneden(MouseEvent event) {
        loadPage("shto-profesori-lenda");
    }
    @FXML
    private void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/knk_project/" + page + ".fxml"));
        } catch (IOException ex){
            Logger.getLogger(AdminpageController.class.getName()).log(Level.SEVERE,null,ex);
        }
        bp.setCenter(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
