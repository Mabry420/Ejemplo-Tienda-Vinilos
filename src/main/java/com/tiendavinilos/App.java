package com.tiendavinilos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación Tienda de Vinilos.
 * Inicia la interfaz gráfica con JavaFX.
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Carga la vista principal desde el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Principal.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Tienda de Vinilos");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
