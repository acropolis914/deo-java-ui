package com.ui.deo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        // Load the scene directly from the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/ui/deo/layout.fxml"));
        Scene scene = new Scene(loader.load());

        // Get the controller after loading the scene
        Controller controller = loader.getController();
        if (controller != null) {
            controller.printDataMatrix();
        } else {
            System.out.println("Controller is null");
        }

        scene.getStylesheets().add(getClass().getResource("/com/ui/deo/styles.css").toExternalForm());
        primaryStage.setTitle("Production Data");
        primaryStage.setScene(scene);
        primaryStage.setWidth(700);
        primaryStage.setHeight(600);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
