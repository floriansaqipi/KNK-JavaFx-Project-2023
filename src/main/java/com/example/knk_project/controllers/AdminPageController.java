package com.example.knk_project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminPageController implements Initializable {
    @FXML
    private AnchorPane ap;
    @FXML
    private BorderPane bp;
    @FXML
    private Button logOutButton;


    public void shtoshtetin(MouseEvent event) {
        loadPage("shto-shtetin-view");
    }

    public void shtokomunen(MouseEvent event) {
        loadPage("shto-komuna-view");
    }

    public void shtoklasen(MouseEvent event) {
        loadPage("add-class-view");
    }


    public void shtolenden(MouseEvent event) {
        loadPage("shto-lenden-view");
    }

    public void shtoProfesorLenden(MouseEvent event) {
        loadPage("shto-profesor-lenda-view");
    }

    public void shtoProfesorKlasen(MouseEvent event) {
        loadPage("add-profesor-klasa-view");
    }
    public void tabelakomuna(MouseEvent event) {
        loadPage("table-komuna-view");
    }
    public void tabelashteti(MouseEvent event) {
        loadPage("table-shteti-view");
    }


    public void tabelaprofesorlenda(MouseEvent event) {
        loadPage("table-profesor-lenda-view");
    }


    public void tabelaprofesorklasa(MouseEvent event) {
        loadPage("table-profesor-klasa-view");
    }


    @FXML
    private void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/knk_project/" + page + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(AdminPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        bp.setCenter(root);
    }

    public void LogOut(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/knk_project/homepage-view.fxml"));
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setTitle("Homepage");
            stage.setScene(new Scene(root));
            stage.show();

            // Close the current stage
            Stage currentStage = (Stage) logOutButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ProfesorPageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
