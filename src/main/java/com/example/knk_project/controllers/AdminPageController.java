package com.example.knk_project.controllers;

import javafx.event.ActionEvent;
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


    private MainController mainController;
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
        AnchorPane anchorPane = null;
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + "table-komuna-view" + ".fxml"));
            anchorPane = fxmlLoader.load();
            TableKomunaController tableKomunaController = fxmlLoader.getController();
            tableKomunaController.initData();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        bp.setCenter(anchorPane);
    }
    public void tabelashteti(MouseEvent event) {
        AnchorPane anchorPane = null;
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + "table-shteti-view" + ".fxml"));
            anchorPane = fxmlLoader.load();
            TableShtetiController tableShtetiController = fxmlLoader.getController();
            tableShtetiController.initData();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        bp.setCenter(anchorPane);
    }


    public void tabelaprofesorlenda(MouseEvent event) {
        AnchorPane anchorPane = null;
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" +
                    "table-profesor-lenda-view" + ".fxml"));
            anchorPane = fxmlLoader.load();
            TableProfesorLendaController tableProfesorLendaController = fxmlLoader.getController();
            tableProfesorLendaController.initData();

        }catch (IOException ex) {
            ex.printStackTrace();
        }
        bp.setCenter(anchorPane);
    }


    public void tabelaprofesorklasa(MouseEvent event) {

        AnchorPane anchorPane = null;
        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" +
                    "table-profesor-klasa-view" + ".fxml"));
            anchorPane = fxmlLoader.load();
            TableProfesorKlasaController tableProfesorKlasaController = fxmlLoader.getController();
            tableProfesorKlasaController.initData();

        }catch (IOException ex) {
            ex.printStackTrace();
        }
        bp.setCenter(anchorPane);
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

    @FXML
    public void loadAdminHomePage(ActionEvent event){
        initData();
    }

    public void LogOut(MouseEvent event) {
        this.mainController.reset();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setAdminPage() throws IOException {

            AnchorPane root = null;

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + "admin-home-page-view" + ".fxml"));
            root =  fxmlLoader.load();
            AdminHomePageController adminHomePageController = fxmlLoader.getController();
            adminHomePageController.setMainController(mainController);

            bp.setCenter(root);

    }

    public void initData() {
        try{

        this.setAdminPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
