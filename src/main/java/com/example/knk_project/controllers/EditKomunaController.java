package com.example.knk_project.controllers;

import com.example.knk_project.models.*;
import com.example.knk_project.models.dto.UpdateKomunaDto;
import com.example.knk_project.models.dto.UpdateNotaDto;
import com.example.knk_project.services.IntegerRoman;
import com.example.knk_project.services.KomunaService;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.KomunaServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditKomunaController implements Initializable {

    private KomunaShtetiTableView komunaShtetiTableView;
    private TableKomunaController tableKomunaController;
    private ValidatorInterface validator = new ValidatorService();
    private KomunaServiceInterface komunaService = new KomunaService();
    private Komuna komuna;

    @FXML
    private Label addCityLabel;

    @FXML
    private TextField komunaTextField;

    @FXML
    private Label messageLabel;


    public void setKomuna(Komuna komuna) {
        this.komuna = komuna;
    }

    public void setKomunaShtetiTableView(KomunaShtetiTableView komunaShtetiTableView) {
        this.komunaShtetiTableView = komunaShtetiTableView;
    }

    public void setTableNotaControllerNew(TableKomunaController tableKomunaController) {
        this.tableKomunaController = tableKomunaController;
    }

    private void close(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.tableKomunaController.initData();
        stage.close();
    }


    @FXML
    void editKomunaClick(ActionEvent event) throws SQLException {
        int id = this.komunaShtetiTableView.getKomuna().getId();
        String emri = this.komunaTextField.getText();
        int shteti_id = this.komunaShtetiTableView.getShteti().getId();
        UpdateKomunaDto updateKomunaDto = new UpdateKomunaDto(
                id,
                emri,
                shteti_id
        );
        try {
            validateInputs();
            this.komunaService.update(updateKomunaDto);
            this.messageLabel.setText("Successfully edited grade");
            this.close(event);
        } catch (ValidationException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Invalid inputs");
        } catch (SQLException exception) {
            exception.printStackTrace();
            this.messageLabel.setText("Something went wrong with the database");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void validateInputs() throws ValidationException {
        this.validator.validateTextField(komunaTextField);
        this.validator.throwIfInvalid();
    }

    private void initalizeKomunaName() {
        this.komunaTextField.setText(komuna.getEmri());
    }



    public void initData() {
      initalizeKomunaName();
    }

}
