package com.example.knk_project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.InflaterInputStream;

public class ProfileProfessorController implements Initializable {

    @FXML
    private TextField emriTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField mbiemriTextField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField titulliTextField;
    // Variables to store the user data
    private String id;
    private String emri;
    private String mbiemri;
    private String titulli;
    private String password;

    public ProfileProfessorController(String id, String emri, String mbiemri, String titulli, String password) throws IOException {
        this.id = id;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.titulli = titulli;
        this.password = password;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Set the user data in the text fields
        idTextField.setText(id);
        emriTextField.setText(emri);
        mbiemriTextField.setText(mbiemri);
        titulliTextField.setText(titulli);
        passwordPasswordField.setText(password);
    }

    @FXML
    void editProfileClick(ActionEvent event) {
        loadPage("edit-professor-view");

    }

    private void loadPage(String page){
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/example/knk_project/"+page + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ProfesorPageController.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

}
