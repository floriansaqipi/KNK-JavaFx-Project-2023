

package com.example.knk_project.controllers;

        import com.example.knk_project.models.Shteti;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.TableCell;
        import javafx.scene.control.TableColumn;
        import javafx.scene.control.TableView;
        import javafx.scene.control.cell.PropertyValueFactory;
        import javafx.scene.layout.AnchorPane;
        import javafx.util.Callback;

public class TableShtetiController {

    @FXML
    private TableView<Shteti> shtetiTableView;

    public void initialize() {

        TableColumn<Shteti, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Shteti, String> emriColumn = new TableColumn<>("Emri");
        TableColumn<Shteti, Void> editColumn = new TableColumn<>("Edit");
        TableColumn<Shteti, Void> deleteColumn = new TableColumn<>("Delete");


        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        emriColumn.setCellValueFactory(new PropertyValueFactory<>("emri"));
        idColumn.setPrefWidth(112);
        emriColumn.setPrefWidth(112);
        editColumn.setPrefWidth(112);
        deleteColumn.setPrefWidth(112);


        shtetiTableView.getColumns().addAll(idColumn, emriColumn, editColumn, deleteColumn);


        Callback<TableColumn<Shteti, Void>, TableCell<Shteti, Void>> editCellFactory = new Callback<>() {
            @Override
            public TableCell<Shteti, Void> call(final TableColumn<Shteti, Void> param) {
                final TableCell<Shteti, Void> cell = new TableCell<>() {
                    private final Button editButton = new Button("Edit");

                    {
                        editButton.setOnAction((ActionEvent event) -> {
                            Shteti shteti = getTableView().getItems().get(getIndex());

                            System.out.println("Edit button clicked for Shteti with ID: " + shteti.getId());
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

        Callback<TableColumn<Shteti, Void>, TableCell<Shteti, Void>> deleteCellFactory = new Callback<>() {
            @Override
            public TableCell<Shteti, Void> call(final TableColumn<Shteti, Void> param) {
                final TableCell<Shteti, Void> cell = new TableCell<>() {
                    private final Button deleteButton = new Button("Delete");

                    {
                        deleteButton.setOnAction((ActionEvent event) -> {
                            Shteti komuna = getTableView().getItems().get(getIndex());

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


        shtetiTableView.getItems().add(new Shteti(1, "Shteti 1"));
        shtetiTableView.getItems().add(new Shteti(2, "Shteti 2"));
        shtetiTableView.getItems().add(new Shteti(3, "Shteti 3"));

    }


    public static class Shteti {
        private int id;
        private String emri;


        public Shteti(int id, String emri) {
            this.id = id;
            this.emri = emri;

        }

        public int getId() {
            return id;
        }

        public String getEmri() {
            return emri;
        }


    }
}
