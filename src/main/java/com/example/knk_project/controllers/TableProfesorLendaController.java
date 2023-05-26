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

        TableColumn<TableProfesorLendaController.ProfesorLenda, Integer> profesori_idColumn = new TableColumn<>("Profesori_id");
        TableColumn<TableProfesorLendaController.ProfesorLenda, String> usernameColumn = new TableColumn<>("Username");
        TableColumn<TableProfesorLendaController.ProfesorLenda, String> emriColumn = new TableColumn<>("Emri");
        TableColumn<TableProfesorLendaController.ProfesorLenda, String> mbiemriColumn = new TableColumn<>("Mbiemri");
        TableColumn<TableProfesorLendaController.ProfesorLenda, String> emri_lendesColumn = new TableColumn<>("Lenda");
        TableColumn<TableProfesorLendaController.ProfesorLenda, String> lenda_idColumn = new TableColumn<>("Lenda_id");
        TableColumn<TableProfesorLendaController.ProfesorLenda, Void> editColumn = new TableColumn<>("Edit");
        TableColumn<TableProfesorLendaController.ProfesorLenda, Void> deleteColumn = new TableColumn<>("Delete");

        // Set cell value factories


        profesori_idColumn.setCellValueFactory(new PropertyValueFactory<>("Profesori_id"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("Username"));
        emriColumn.setCellValueFactory(new PropertyValueFactory<>("Emri"));
        mbiemriColumn.setCellValueFactory(new PropertyValueFactory<>("Mbiemri"));
        emri_lendesColumn.setCellValueFactory(new PropertyValueFactory<>("Lenda"));
        lenda_idColumn.setCellValueFactory(new PropertyValueFactory<>("Lenda_id"));

        profesori_idColumn.setPrefWidth(50);
        usernameColumn.setPrefWidth(70);
        emriColumn.setPrefWidth(50);
        mbiemriColumn.setPrefWidth(70);
        emri_lendesColumn.setPrefWidth(90);


        editColumn.setPrefWidth(60);
        deleteColumn.setPrefWidth(60);

        // Add columns to table

        ProfesorLendaTableView.getColumns().addAll(profesori_idColumn,usernameColumn,emriColumn,mbiemriColumn,emri_lendesColumn,lenda_idColumn,editColumn,deleteColumn);

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
                            System.out.println("Edit button clicked for Profesor Lenda with ID: " + profesorLenda.getProfesori_id());
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
                            System.out.println("Delete button clicked for Profesor Lenda with ID: " + profesorLenda.getProfesori_id());
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

        ProfesorLendaTableView.getItems().add(new TableProfesorLendaController.ProfesorLenda(1, "test@gmail.com", "test", "test", "biologji",4));
        ProfesorLendaTableView.getItems().add(new TableProfesorLendaController.ProfesorLenda(1, "test@gmail.com", "test", "test", "biologji",4));
        ProfesorLendaTableView.getItems().add(new TableProfesorLendaController.ProfesorLenda(1, "test@gmail.com", "test", "test", "biologji",4));
        // Add more rows as needed
    }

    // Sample data class
    public static class ProfesorLenda {
        private int profesori_id;
        private String username;
        private String emri;
        private String mbiemri;
        private String emri_lendes;
        private int lenda_id;


        public ProfesorLenda(int profesori_id, String username, String emri, String mbiemri,String emri_lendes, int lenda_id ) {

            this.username = username;
            this.emri = emri;
            this.mbiemri = mbiemri;
            this.profesori_id = profesori_id;
            this.emri_lendes= emri_lendes;
            this.lenda_id = lenda_id;
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
        public String getEmri_lendes() {
            return emri_lendes;
        }

        public int getLenda_id() {
            return lenda_id;
        }
    }
    }

