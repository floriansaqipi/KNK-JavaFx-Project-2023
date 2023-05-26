package com.example.knk_project.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class TableProfesorKlasaController {

    @FXML
    private TableView<ProfesorKlasa> ProfesorKlasaTableView;

    public void initialize() {
        // Create table columns

        TableColumn<ProfesorKlasa, String> profesoriColumn = new TableColumn<>("Profesori");
        TableColumn<ProfesorKlasa, String> klasaColumn = new TableColumn<>("Klasa");
        TableColumn<ProfesorKlasa, Void> editColumn = new TableColumn<>("Edit");
        TableColumn<ProfesorKlasa, Void> deleteColumn = new TableColumn<>("Delete");

        // Set cell value factories


        profesoriColumn.setCellValueFactory(new PropertyValueFactory<>("profesori"));
        klasaColumn.setCellValueFactory(new PropertyValueFactory<>("klasa"));


        profesoriColumn.setPrefWidth(112);
        klasaColumn.setPrefWidth(112);
        editColumn.setPrefWidth(112);
        deleteColumn.setPrefWidth(112);

        // Add columns to table

        ProfesorKlasaTableView.getColumns().addAll(profesoriColumn, klasaColumn, editColumn, deleteColumn);

        // Create button cell factories for edit and delete columns
        Callback<TableColumn<ProfesorKlasa, Void>, TableCell<ProfesorKlasa, Void>> editCellFactory = new Callback<>() {
            @Override
            public TableCell<ProfesorKlasa, Void> call(final TableColumn<ProfesorKlasa, Void> param) {
                final TableCell<ProfesorKlasa, Void> cell = new TableCell<>() {
                    private final Button editButton = new Button("Edit");

                    {
                        editButton.setOnAction((ActionEvent event) -> {
                            ProfesorKlasa profesorKlasa = getTableView().getItems().get(getIndex());
                            // Handle the edit button click here
                            System.out.println("Edit button clicked for Profesor Lenda with ID: " + profesorKlasa.getKlasa());
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(editButton);
                        }
                    }
                };
                return cell;
            }
        };

        Callback<TableColumn<ProfesorKlasa, Void>, TableCell<ProfesorKlasa, Void>> deleteCellFactory = new Callback<>() {
            @Override
            public TableCell< ProfesorKlasa, Void> call(final TableColumn<ProfesorKlasa, Void> param) {
                final TableCell<ProfesorKlasa, Void> cell = new TableCell<>() {
                    private final Button deleteButton = new Button("Delete");

                    {
                        deleteButton.setOnAction((ActionEvent event) -> {
                            ProfesorKlasa profesorKlasa = getTableView().getItems().get(getIndex());
                            // Handle the delete button click here
                            System.out.println("Delete button clicked for Profesor Lenda with ID: " + profesorKlasa.getKlasa());
                        });
                    }

                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(deleteButton);
                        }
                    }
                };
                return cell;
            }
        };

        // Set cell factories for edit and delete columns
        editColumn.setCellFactory(editCellFactory);
        deleteColumn.setCellFactory(deleteCellFactory);

        // Add sample data

        ProfesorKlasaTableView.getItems().add(new ProfesorKlasa("fjolla","X"));
        ProfesorKlasaTableView.getItems().add(new ProfesorKlasa("fjolla", "V"));
        ProfesorKlasaTableView.getItems().add(new ProfesorKlasa("fjolla", "XI"));
        // Add more rows as needed
    }

    // Sample data class
    public static class ProfesorKlasa {

        private String profesori;
        private String klasa;

        public ProfesorKlasa( String profesori, String klasa) {

            this.profesori = profesori;
            this.klasa = klasa;
        }


        public String getProfesori() {
            return profesori;
        }

        public String getKlasa() {
            return klasa;
        }
    }
}
