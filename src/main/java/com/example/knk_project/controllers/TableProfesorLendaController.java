package com.example.knk_project.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class TableProfesorLendaController {

    @FXML
    private TableView<ProfesorLenda> ProfesorLendaTableView;

    public void initialize() {
        // Create table columns

        TableColumn<ProfesorLenda, String> profesoriColumn = new TableColumn<>("Profesori");
        TableColumn<ProfesorLenda, String> lendaColumn = new TableColumn<>("Lenda");
        TableColumn<ProfesorLenda, Void> editColumn = new TableColumn<>("Edit");
        TableColumn<ProfesorLenda, Void> deleteColumn = new TableColumn<>("Delete");

        // Set cell value factories


        profesoriColumn.setCellValueFactory(new PropertyValueFactory<>("profesori"));
        lendaColumn.setCellValueFactory(new PropertyValueFactory<>("lenda"));
        profesoriColumn.setPrefWidth(112);
        lendaColumn.setPrefWidth(112);
        editColumn.setPrefWidth(112);
        deleteColumn.setPrefWidth(112);

        // Add columns to table

        ProfesorLendaTableView.getColumns().addAll(profesoriColumn, lendaColumn, editColumn, deleteColumn);

        // Create button cell factories for edit and delete columns
        Callback<TableColumn<ProfesorLenda, Void>, TableCell<ProfesorLenda, Void>> editCellFactory = new Callback<>() {
            @Override
            public TableCell<ProfesorLenda, Void> call(final TableColumn<ProfesorLenda, Void> param) {
                final TableCell<ProfesorLenda, Void> cell = new TableCell<>() {
                    private final Button editButton = new Button("Edit");

                    {
                        editButton.setOnAction((ActionEvent event) -> {
                            ProfesorLenda profesorLenda = getTableView().getItems().get(getIndex());
                            // Handle the edit button click here
                            System.out.println("Edit button clicked for Profesor Lenda with ID: " + profesorLenda.getLenda());
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

        Callback<TableColumn<ProfesorLenda, Void>, TableCell<ProfesorLenda, Void>> deleteCellFactory = new Callback<>() {
            @Override
            public TableCell<ProfesorLenda, Void> call(final TableColumn<ProfesorLenda, Void> param) {
                final TableCell<ProfesorLenda, Void> cell = new TableCell<>() {
                    private final Button deleteButton = new Button("Delete");

                    {
                        deleteButton.setOnAction((ActionEvent event) -> {
                            ProfesorLenda profesorLenda = getTableView().getItems().get(getIndex());
                            // Handle the delete button click here
                            System.out.println("Delete button clicked for Profesor Lenda with ID: " + profesorLenda.getLenda());
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

        ProfesorLendaTableView.getItems().add(new ProfesorLenda("fjolla","biologji"));
        ProfesorLendaTableView.getItems().add(new ProfesorLenda("fjolla", "matematike"));
        ProfesorLendaTableView.getItems().add(new ProfesorLenda("fjolla", "kimi"));
        // Add more rows as needed
    }

    // Sample data class
    public static class ProfesorLenda {

        private String profesori;
        private String lenda;

        public ProfesorLenda( String profesori, String lenda) {

            this.profesori = profesori;
            this.lenda = lenda;
        }


        public String getProfesori() {
            return profesori;
        }

        public String getLenda() {
            return lenda;
        }
    }
}
