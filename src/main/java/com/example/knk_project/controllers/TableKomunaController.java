package com.example.knk_project.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class TableKomunaController {

    @FXML
    private TableView<Komuna> komunaTableView;

    public void initialize() {

        TableColumn<Komuna, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Komuna, String> emriColumn = new TableColumn<>("Emri");
        TableColumn<Komuna, Integer> shtetiIdColumn = new TableColumn<>("Shteti_Id");
        TableColumn<Komuna, Void> editColumn = new TableColumn<>("Edit");
        TableColumn<Komuna, Void> deleteColumn = new TableColumn<>("Delete");


        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        emriColumn.setCellValueFactory(new PropertyValueFactory<>("emri"));
        shtetiIdColumn.setCellValueFactory(new PropertyValueFactory<>("shtetiId"));
        idColumn.setPrefWidth(98);
        emriColumn.setPrefWidth(98);
        shtetiIdColumn.setPrefWidth(98);
        deleteColumn.setPrefWidth(98);


        komunaTableView.getColumns().addAll(idColumn, emriColumn, shtetiIdColumn, editColumn, deleteColumn);


        Callback<TableColumn<Komuna, Void>, TableCell<Komuna, Void>> editCellFactory = new Callback<>() {
            @Override
            public TableCell<Komuna, Void> call(final TableColumn<Komuna, Void> param) {
                final TableCell<Komuna, Void> cell = new TableCell<>() {
                    private final Button editButton = new Button("Edit");

                    {
                        editButton.setOnAction((ActionEvent event) -> {
                            Komuna komuna = getTableView().getItems().get(getIndex());

                            System.out.println("Edit button clicked for Komuna with ID: " + komuna.getId());
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

        Callback<TableColumn<Komuna, Void>, TableCell<Komuna, Void>> deleteCellFactory = new Callback<>() {
            @Override
            public TableCell<Komuna, Void> call(final TableColumn<Komuna, Void> param) {
                final TableCell<Komuna, Void> cell = new TableCell<>() {
                    private final Button deleteButton = new Button("Delete");

                    {
                        deleteButton.setOnAction((ActionEvent event) -> {
                            Komuna komuna = getTableView().getItems().get(getIndex());

                            System.out.println("Delete button clicked for Komuna with ID: " + komuna.getId());
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


        editColumn.setCellFactory(editCellFactory);
        deleteColumn.setCellFactory(deleteCellFactory);


        komunaTableView.getItems().add(new Komuna(1, "Komuna 1", 1));
        komunaTableView.getItems().add(new Komuna(2, "Komuna 2", 2));
        komunaTableView.getItems().add(new Komuna(3, "Komuna 3", 1));

    }


    public static class Komuna {
        private int id;
        private String emri;
        private int shtetiId;

        public Komuna(int id, String emri, int shtetiId) {
            this.id = id;
            this.emri = emri;
            this.shtetiId = shtetiId;
        }

        public int getId() {
            return id;
        }

        public String getEmri() {
            return emri;
        }

        public int getShtetiId() {
            return shtetiId;
        }
    }
}
