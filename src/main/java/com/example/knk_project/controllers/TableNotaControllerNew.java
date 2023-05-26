package com.example.knk_project.controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class TableNotaControllerNew {

    @FXML
    private TableView<Nota> NotaTableView;

    public void initialize() {
        // Create table columns

        TableColumn<TableNotaControllerNew.Nota, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<TableNotaControllerNew.Nota,Integer> vleraColumn = new TableColumn<>("Vlera");
        TableColumn<TableNotaControllerNew.Nota,Integer> rubrikaColumn = new TableColumn<>("Rubrika");
        TableColumn<TableNotaControllerNew.Nota,Integer> gjysmevjetoriColumn = new TableColumn<>("Gjysmevjetori");
        TableColumn<TableNotaControllerNew.Nota,Integer> profesori_idColumn = new TableColumn<>("Profesori_id");
        TableColumn<TableNotaControllerNew.Nota,Integer> lenda_idColumn = new TableColumn<>("Lenda_id");
        TableColumn<TableNotaControllerNew.Nota,Integer> nxenesi_idColumn = new TableColumn<>("Nxenesi_id");
        TableColumn<TableNotaControllerNew.Nota,Void> editColumn = new TableColumn<>("Edit");
        TableColumn<TableNotaControllerNew.Nota,Void> deleteColumn = new TableColumn<>("Delete");

        // Set cell value factories


        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
        vleraColumn.setCellValueFactory(new PropertyValueFactory<>("Vlera"));
        rubrikaColumn.setCellValueFactory(new PropertyValueFactory<>("Rubrika"));
        gjysmevjetoriColumn.setCellValueFactory(new PropertyValueFactory<>("Gjysmevjetori"));
        profesori_idColumn.setCellValueFactory(new PropertyValueFactory<>("Profesori_id"));
        lenda_idColumn.setCellValueFactory(new PropertyValueFactory<>("Lenda_id"));
        nxenesi_idColumn.setCellValueFactory(new PropertyValueFactory<>("Nxenesi_id"));


        idColumn.setPrefWidth(30);
        vleraColumn.setPrefWidth(40);
        rubrikaColumn.setPrefWidth(55);
        gjysmevjetoriColumn.setPrefWidth(85);
        profesori_idColumn.setPrefWidth(75);
        lenda_idColumn.setPrefWidth(55);
        nxenesi_idColumn.setPrefWidth(70);
        editColumn.setPrefWidth(50);
        deleteColumn.setPrefWidth(60);

        // Add columns to table

        NotaTableView.getColumns().addAll(idColumn,vleraColumn,rubrikaColumn,gjysmevjetoriColumn,profesori_idColumn,lenda_idColumn,nxenesi_idColumn, editColumn, deleteColumn);

        // Create button cell factories for edit and delete columns
        Callback<TableColumn<Nota, Void>, TableCell<Nota, Void>> editCellFactory = new Callback<>() {
            @Override
            public TableCell<Nota, Void> call(final TableColumn<Nota, Void> param) {
                final TableCell<Nota, Void> cell = new TableCell<>() {
                    private final Button editButton = new Button("Edit");

                    {
                        editButton.setOnAction((ActionEvent event) -> {
                            Nota nota = getTableView().getItems().get(getIndex());
                            // Handle the edit button click here
                            System.out.println("Edit button clicked for Profesor Lenda with ID: " + nota.getId());
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

        Callback<TableColumn<Nota, Void>, TableCell<Nota, Void>> deleteCellFactory = new Callback<>() {
            @Override
            public TableCell< Nota, Void> call(final TableColumn<Nota, Void> param) {
                final TableCell<Nota, Void> cell = new TableCell<>() {
                    private final Button deleteButton = new Button("Delete");

                    {
                        deleteButton.setOnAction((ActionEvent event) -> {
                            Nota nota = getTableView().getItems().get(getIndex());
                            // Handle the delete button click here
                            System.out.println("Delete button clicked for Profesor Lenda with ID: " + nota.getId());
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

        NotaTableView.getItems().add(new Nota(1,5,3,1,3,1,5));
        NotaTableView.getItems().add(new Nota(8,5,3,1,3,1,5));
        NotaTableView.getItems().add(new Nota(6,5,3,1,3,1,5));
        // Add more rows as needed
    }

    // Sample data class
    public class Nota {
        private int id;
        private int vlera;
        private int rubrika;
        private int gjysmevjetori;
        private int profesoriId;
        private int lendaId;
        private int nxenesiId;

        public Nota(int id, int vlera, int rubrika, int gjysmevjetori, int profesoriId, int lendaId, int nxenesiId) {
            this.id = id;
            this.vlera = vlera;
            this.rubrika = rubrika;
            this.gjysmevjetori = gjysmevjetori;
            this.profesoriId = profesoriId;
            this.lendaId = lendaId;
            this.nxenesiId = nxenesiId;
        }

        public int getId() {
            return id;
        }

        public int getVlera() {
            return vlera;
        }

        public int getRubrika() {
            return rubrika;
        }

        public int getGjysmevjetori() {
            return gjysmevjetori;
        }

        public int getProfesoriId() {
            return profesoriId;
        }

        public int getLendaId() {
            return lendaId;
        }

        public int getNxenesiId() {
            return nxenesiId;
        }
    }

}
