package com.example.knk_project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class AdminHomePageController extends BaseController implements Initializable {


    private MainController mainController;


    @FXML
    private Label dashboardInfo;

    @FXML
    private Label welcomeAdminLabel;

    @FXML
    void loadDashboard(ActionEvent event) {
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/admin-dashboard.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            AdminDashboardController adminDashboardController = fxmlLoader.getController();
            adminDashboardController.setMainController(mainController);
            mainController.setMainPane(anchorPane);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    void loadAlbanianText(ActionEvent event) {
        Locale.setDefault(new Locale("sq"));
        loadLang();
    }

    @FXML
    void loadEnglishText(ActionEvent event) {
        Locale.setDefault(new Locale("en"));
        loadLang();
    }
    @Override
    public void translate(ResourceBundle bundle) {
        this.welcomeAdminLabel.setText(bundle.getString("admin.welcome.banner"));
        this.dashboardInfo.setText(bundle.getString("admin.dashboard.info"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadLang();
    }
}
