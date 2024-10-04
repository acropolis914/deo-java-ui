package com.ui.deo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class Controller {

    @FXML
    private TableView<ProductionData> chairTable;

    @FXML
    private TableColumn<ProductionData, String> locationColumn;

    @FXML
    private TableColumn<ProductionData, Integer> chairs2021Column;

    @FXML
    private TableColumn<ProductionData, Integer> tables2021Column;

    @FXML
    private TableColumn<ProductionData, Integer> chairs2022Column;

    @FXML
    private TableColumn<ProductionData, Integer> tables2022Column;

    // Create an ObservableList for the data
    private ObservableList<ProductionData> productionDataList;

    @FXML
    public void initialize() {
        // Initialize the ObservableList
        productionDataList = FXCollections.observableArrayList(
                new ProductionData("San Jose", 30, 18, 36, 20),
                new ProductionData("Hayward", 20, 12, 24, 18),
                new ProductionData("Oakland", 16, 10, 20, 12)
        );

        // Bind table columns to the ProductionData properties
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        chairs2021Column.setCellValueFactory(new PropertyValueFactory<>("chairs2021"));
        tables2021Column.setCellValueFactory(new PropertyValueFactory<>("tables2021"));
        chairs2022Column.setCellValueFactory(new PropertyValueFactory<>("chairs2022"));
        tables2022Column.setCellValueFactory(new PropertyValueFactory<>("tables2022"));

        // Make the TableView editable
        chairTable.setEditable(true);

        // Set cell factories for editable columns
        setEditableCellFactories();

        // Bind the data (ObservableList) to the TableView
        chairTable.setItems(productionDataList);
    }

    private void setEditableCellFactories() {
        // Location column remains read-only
        locationColumn.setCellFactory(tc -> new TextFieldTableCell<>());

        // Numeric columns become editable
        chairs2021Column.setCellFactory(tc -> new TextFieldTableCell<>(new IntegerStringConverter()));
        tables2021Column.setCellFactory(tc -> new TextFieldTableCell<>(new IntegerStringConverter()));
        chairs2022Column.setCellFactory(tc -> new TextFieldTableCell<>(new IntegerStringConverter()));
        tables2022Column.setCellFactory(tc -> new TextFieldTableCell<>(new IntegerStringConverter()));

        // Add change listeners to each column
        addChangeListeners();
    }

    private void addChangeListeners() {
        chairs2021Column.setOnEditCommit(event -> {
            int newValue = event.getNewValue().intValue();
            int index = event.getTablePosition().getRow();
            productionDataList.get(index).setChairs2021(newValue);
            printDataMatrix();
        });

        tables2021Column.setOnEditCommit(event -> {
            int newValue = event.getNewValue().intValue();
            int index = event.getTablePosition().getRow();
            productionDataList.get(index).setTables2021(newValue);
        });

        chairs2022Column.setOnEditCommit(event -> {
            int newValue = event.getNewValue().intValue();
            int index = event.getTablePosition().getRow();
            productionDataList.get(index).setChairs2022(newValue);
        });

        tables2022Column.setOnEditCommit(event -> {
            int newValue = event.getNewValue().intValue();
            int index = event.getTablePosition().getRow();
            productionDataList.get(index).setTables2022(newValue);
        });
    }

    // Method to add new data (can be called from UI controls like buttons)
    public void addProductionData(ProductionData data) {
        productionDataList.add(data);
    }

    // Method to remove data
    public void removeProductionData(ProductionData data) {
        productionDataList.remove(data);
    }

    // Method to modify existing data
    public void updateProductionData(int index, ProductionData updatedData) {
        productionDataList.set(index, updatedData);
    }

    public int[][] getDataMatrix() {
        // Matrix to store the numerical data from ProductionData (ignores the location)
        int[][] dataMatrix = new int[productionDataList.size()][4]; // 4 columns for chairs and tables (2021 and 2022)

        for (int i = 0; i < productionDataList.size(); i++) {
            ProductionData data = productionDataList.get(i);
            dataMatrix[i][0] = data.getChairs2021(); // 2021 Chairs
            dataMatrix[i][1] = data.getTables2021(); // 2021 Tables
            dataMatrix[i][2] = data.getChairs2022(); // 2022 Chairs
            dataMatrix[i][3] = data.getTables2022(); // 2022 Tables
        }

        return dataMatrix;
    }

    // Example method to print the matrix
    public void printDataMatrix() {
        int[][] dataMatrix = getDataMatrix();
        System.out.println("Matrix of Production Data:");

        for (int[] row : dataMatrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println(); // New line after each row
        }
    }
}
