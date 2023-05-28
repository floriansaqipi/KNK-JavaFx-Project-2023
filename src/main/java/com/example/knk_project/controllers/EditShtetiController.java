package com.example.knk_project.controllers;

import com.example.knk_project.controllers.EditShtetiController;
import com.example.knk_project.models.Shteti;
import com.example.knk_project.models.dto.UpdateShtetiDto;
import com.example.knk_project.services.ShtetiService;
import com.example.knk_project.services.exceptions.ValidationException;
import com.example.knk_project.services.interfaces.ShtetiServiceInterface;
import com.example.knk_project.services.interfaces.ValidatorInterface;
import com.example.knk_project.services.validators.ValidatorService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditShtetiController implements Initializable {

    @FXML
    private Label messageLabel;

    @FXML
    private TextField shtetiTextField;


    private Shteti shteti;
    private TableShtetiController tableShtetiController;
    private ValidatorInterface validator = new ValidatorService();
    private ShtetiServiceInterface shtetiService = new ShtetiService();


    public void setShteti(Shteti shteti) {
        this.shteti = shteti;
    }


    public void setTableShtetiController(TableShtetiController tableShtetiController) {
        this.tableShtetiController = tableShtetiController;
    }

    private void close(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.tableShtetiController.initData();
        stage.close();
    }


    @FXML
    void editShtetinClick(ActionEvent event) throws SQLException {
        int id = this.shteti.getId();
        String emri = this.shtetiTextField.getText();

        UpdateShtetiDto updateShtetiDto = new UpdateShtetiDto(
                id,
                emri
        );
        try {
            validateInputs();
            this.shtetiService.update(updateShtetiDto);
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
        this.validator.validateTextField(shtetiTextField);
        this.validator.throwIfInvalid();
    }

    private void initalizeShtetiName() {
        this.shtetiTextField.setText(shteti.getEmri());
    }



    public void initData() {
        initalizeShtetiName();
    }

}
