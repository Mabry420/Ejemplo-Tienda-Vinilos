package com.tiendavinilos.view;

import com.tiendavinilos.database.ViniloDAO;
import com.tiendavinilos.model.Vinilo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

/**
 * Controlador de la vista principal de la aplicación.
 * Se encarga de mostrar y gestionar los vinilos en la interfaz.
 *
 * Este archivo se conecta con el archivo FXML Principal.fxml diseñado en SceneBuilder.
 */
public class PrincipalController {

    @FXML
    private TableView<Vinilo> tablaVinilos;

    @FXML
    private TableColumn<Vinilo, String> colTitulo;

    @FXML
    private TableColumn<Vinilo, String> colArtista;

    @FXML
    private TableColumn<Vinilo, Double> colPrecio;

    @FXML
    private TableColumn<Vinilo, Integer> colAnio;

    @FXML
    private TableColumn<Vinilo, String> colGenero;

    @FXML
    private TextField buscarCampo;

    private final ViniloDAO viniloDAO;
    private final ObservableList<Vinilo> vinilosList;

    public PrincipalController() {
        this.viniloDAO = new ViniloDAO();
        this.vinilosList = FXCollections.observableArrayList();
    }

    /**
     * Se ejecuta al cargar la vista. Inicializa las columnas y carga los datos.
     */
    @FXML
    public void initialize() {
        colTitulo.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
        colArtista.setCellValueFactory(cellData -> cellData.getValue().artistaProperty());
        colPrecio.setCellValueFactory(cellData -> cellData.getValue().precioProperty());
        colAnio.setCellValueFactory(cellData -> cellData.getValue().anioProperty());
        colGenero.setCellValueFactory(cellData -> cellData.getValue().generoProperty());

        tablaVinilos.setItems(vinilosList);
        cargarVinilos();
    }

    /**
     * Carga todos los vinilos desde la base de datos y los muestra en la tabla.
     */
    public void cargarVinilos() {
        vinilosList.setAll(viniloDAO.findAll());
    }

    /**
     * Agrega un nuevo vinilo a la base de datos.
     * (Por ahora es un método de ejemplo; se completará con la interfaz de formulario)
     */
    @FXML
    public void agregarVinilo() {
        // TODO: Implementar formulario para agregar vinilos
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Función en desarrollo");
        alert.setContentText("El formulario para agregar vinilos se implementará pronto.");
        alert.showAndWait();
    }

    /**
     * Busca vinilos según el texto ingresado.
     */
    @FXML
    public void buscarVinilo() {
        String texto = buscarCampo.getText().toLowerCase();
        var filtrados = viniloDAO.findAll().stream()
                .filter(v -> v.getTitulo().toLowerCase().contains(texto)
                        || v.getArtista().toLowerCase().contains(texto))
                .toList();
        vinilosList.setAll(filtrados);
    }
}
