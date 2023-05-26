package com.example.knk_project.controllers;

import com.example.knk_project.models.Profesori;
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

public class ProfesorPageController implements Initializable {
    private Profesori profesori ;
    @FXML
    private AnchorPane ap;

    @FXML
    private BorderPane bp;
    @FXML
    private Button logOutButton;

    public void setProfesori(Profesori profesori) {
        this.profesori = profesori;
    }

    @FXML
    public void ShtoNoten(MouseEvent event) {

        AnchorPane root = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + "add-nota-view" + ".fxml"));
            root =  fxmlLoader.load();
            AddGradeController addGradeController = fxmlLoader.getController();
            addGradeController.setProfesori(this.profesori);
            addGradeController.initData();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        bp.setCenter(root);

    }
    @FXML
    public void Notat(MouseEvent event) {
        loadPage("transcript");
    }



    @FXML
    public void ShikoProfilin(MouseEvent event) {
      loadPage("profile-professor-view");
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
