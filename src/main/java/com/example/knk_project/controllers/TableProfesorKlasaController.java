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

        TableColumn<ProfesorKlasa, Integer> idColumn = new TableColumn<>("Profesori_id");
        TableColumn<ProfesorKlasa, String> usernameColumn = new TableColumn<>("Username");
        TableColumn<ProfesorKlasa, String> emriColumn = new TableColumn<>("Emri");
        TableColumn<ProfesorKlasa, String> mbiemriColumn = new TableColumn<>("Mbiemri");
        TableColumn<ProfesorKlasa, String> klasa_idColumn = new TableColumn<>("Klasa_id");
        TableColumn<ProfesorKlasa, Void> editColumn = new TableColumn<>("Edit");
        TableColumn<ProfesorKlasa, Void> deleteColumn = new TableColumn<>("Delete");

        // Set cell value factories


        idColumn.setCellValueFactory(new PropertyValueFactory<>("Profesori_id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("Username"));
        emriColumn.setCellValueFactory(new PropertyValueFactory<>("Emri"));
        mbiemriColumn.setCellValueFactory(new PropertyValueFactory<>("Mbiemri"));
        klasa_idColumn.setCellValueFactory(new PropertyValueFactory<>("klasa_id"));




        idColumn.setPrefWidth(75);
        usernameColumn.setPrefWidth(80);
        emriColumn.setPrefWidth(88);
        mbiemriColumn.setPrefWidth(88);
        editColumn.setPrefWidth(80);
        deleteColumn.setPrefWidth(80);

        // Add columns to table

        ProfesorKlasaTableView.getColumns().addAll(idColumn,usernameColumn,emriColumn,mbiemriColumn, klasa_idColumn,editColumn, deleteColumn);

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
                            System.out.println("Edit button clicked for Profesor Lenda with ID: " + profesorKlasa.getProfesori_id());
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
            public TableCell<ProfesorKlasa, Void> call(final TableColumn<ProfesorKlasa, Void> param) {
                final TableCell<ProfesorKlasa, Void> cell = new TableCell<>() {
                    private final Button deleteButton = new Button("Delete");

                    {
                        deleteButton.setOnAction((ActionEvent event) -> {
                            ProfesorKlasa profesorKlasa = getTableView().getItems().get(getIndex());
                            // Handle the delete button click here
                            System.out.println("Delete button clicked for Profesor Lenda with ID: " + profesorKlasa.getProfesori_id());
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

        ProfesorKlasaTableView.getItems().add(new ProfesorKlasa(1, "test@gmail.com", "test", "test", 2));
        ProfesorKlasaTableView.getItems().add(new ProfesorKlasa(1, "test@gmail.com", "test", "test", 2));
        ProfesorKlasaTableView.getItems().add(new ProfesorKlasa(1, "test@gmail.com", "test", "test", 2));

        // Add more rows as needed
    }

    // Sample data class
    public static class ProfesorKlasa {
        private int profesori_id;
        private String username;

        private String emri;
        private String mbiemri;

        private int klasa_id;

        public ProfesorKlasa(int profesori_id, String username, String emri, String mbiemri, int klasa_id) {

            this.username = username;
            this.emri = emri;
            this.mbiemri = mbiemri;
            this.profesori_id = profesori_id;
            this.klasa_id = klasa_id;
        }


        public int getProfesori_id() {
            return profesori_id;
        }


        public String getUsername() {
            return username;
        }

        public String getEmri() {
            return emri;
        }

        public String getMbiemri() {
            return mbiemri;
        }


        public int getKlasa_id() {
            return klasa_id;
        }
    }
}
