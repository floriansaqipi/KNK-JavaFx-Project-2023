package com.example.knk_project.controllers;

import com.example.knk_project.models.Nxenesi;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentPageController implements Initializable {
    private Nxenesi nxenesi;



    private MainController mainController;
    @FXML
    private AnchorPane ap;
    @FXML
    private BorderPane bp;
    @FXML
    private Button logOutButton;
    @FXML
    private Pane p;

    private void setNxenesiPage() throws IOException {
        AnchorPane root = null;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/knk_project/" + "nxenesi-home-page-view" + ".fxml"));
        root =  fxmlLoader.load();

        NxenesiHomePageController nxenesiHomePageController = fxmlLoader.getController();
//        System.out.println(this.mainController);
        nxenesiHomePageController.setMainController(this.mainController);
        nxenesiHomePageController.setNxenesi(this.nxenesi);
//        nxenesiHomePageController.printNxenesi();

//            AddGradeController addGradeController = fxmlLoader.getController();
//            addGradeController.setProfesori(this.profesori);
//            addGradeController.initData();

        bp.setCenter(root);
    }

    @FXML
    public void loadNxenesiHomePage(ActionEvent event){
        initData();
    }

    public void transkripta(MouseEvent event) {
        loadPage("transcript");
    }

    public void profili(MouseEvent event) {
        loadPage("profilistudent-view");
    }
    @FXML
    private void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/knk_project/" + page + ".fxml"));
        } catch (IOException ex){
            Logger.getLogger(StudentPageController.class.getName()).log(Level.SEVERE,null,ex);
        }
        bp.setCenter(root);
    }

    public void LogOut(MouseEvent event) {
       this.mainController.reset();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void initData(){
        try{
        this.setNxenesiPage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setNxenesi(Nxenesi nxenesi) {
        this.nxenesi = nxenesi;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
