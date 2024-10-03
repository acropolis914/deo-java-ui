package com.ui.deo;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

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

    @FXML
    public void initialize() {
        // Define columns
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
        chairs2021Column.setCellValueFactory(new PropertyValueFactory<>("chairs2021"));
        tables2021Column.setCellValueFactory(new PropertyValueFactory<>("tables2021"));
        chairs2022Column.setCellValueFactory(new PropertyValueFactory<>("chairs2022"));
        tables2022Column.setCellValueFactory(new PropertyValueFactory<>("tables2022"));

        // Sample data
        List<ProductionData> productionDataList = new ArrayList<>();
        productionDataList.add(new ProductionData("San Jose", 30, 18, 36, 20));
        productionDataList.add(new ProductionData("Hayward", 20, 12, 24, 18));
        productionDataList.add(new ProductionData("Oakland", 16, 10, 20, 12));

        // Populate table with data
        chairTable.getItems().addAll(productionDataList);
    }
}
