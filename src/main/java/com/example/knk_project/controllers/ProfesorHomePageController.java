package com.example.knk_project.controllers;

import com.example.knk_project.models.Profesori;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ProfesorHomePageController {
    private MainController mainController;
    private Profesori profesori;

        @FXML
        public void loadDashboard(ActionEvent event) {
            try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/professor-dashboard-view.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            ProfessorDashboardController professorDashboardController = fxmlLoader.getController();
            professorDashboardController.setProfesori(this.profesori);
            professorDashboardController.setMainController(mainController);
//            professorDashboardController.initData();
//            professorDashboardController.printProfesori();
            mainController.setMainPane(anchorPane);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    public void setProfesori(Profesori profesori) {
        this.profesori = profesori;
    }

    public void printProfesori(){
        System.out.println(this.profesori);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
