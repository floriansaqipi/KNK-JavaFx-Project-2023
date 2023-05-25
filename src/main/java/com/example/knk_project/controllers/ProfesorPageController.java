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

public class ProfesorPageController implements Initializable {
    @FXML
    private AnchorPane ap;

    @FXML
    private BorderPane bp;


    @FXML
    public void ShtoNoten(MouseEvent event) {
        loadPage("add-grade-view");
    }
    @FXML
    public void Notat(MouseEvent event) {
        loadPage("transcript");
    }
    @FXML
    public void ShikoLendet(MouseEvent event) {
        loadPage("shto-profesor-lenda-view");
    }
    @FXML
    public void KlasatEmia(MouseEvent event) {
        loadPage("add-profesor-klasa-view");
    }
    @FXML
    public void ShikoProfilin(MouseEvent event) {

    }


    private void loadPage(String page){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/knk_project/"+page + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ProfesorPageController.class.getName()).log(Level.SEVERE,null,ex);
        }
        bp.setCenter(root);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
