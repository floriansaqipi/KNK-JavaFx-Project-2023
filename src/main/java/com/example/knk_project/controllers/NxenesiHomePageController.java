package com.example.knk_project.controllers;

import com.example.knk_project.models.Nxenesi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NxenesiHomePageController {
    private MainController mainController;
    private Nxenesi nxenesi;


    @FXML
    void loadDashboard(ActionEvent event) {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/student-dashboard.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            StudentDashboardController studentDashboardController = fxmlLoader.getController();
            studentDashboardController.setNxenesi(this.nxenesi);
            studentDashboardController.setMainController(mainController);
//            studentDashboardController.initData();
//            studentDashboardController.printNxenesi();
            mainController.setMainPane(anchorPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setNxenesi(Nxenesi nxenesi) {
        this.nxenesi = nxenesi;
    }


    public void printNxenesi() {
        System.out.println(this.nxenesi);
    }
}
