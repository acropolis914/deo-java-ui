package com.ui.deo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ui/deo/layout.fxml"));

        // Load the scene directly from the FXML file
        Scene scene = new Scene(loader.load());

        primaryStage.setTitle("Production Data");
        primaryStage.setScene(scene);
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}