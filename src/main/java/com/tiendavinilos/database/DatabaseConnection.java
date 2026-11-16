package com.tiendavinilos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Maneja la conexión con la base de datos MySQL.
 * Los datos de conexión se leen desde el archivo db/config.properties.
 */
public class DatabaseConnection {

    private static final String CONFIG_FILE = "/db/config.properties";

    private String url;
    private String user;
    private String password;

    public DatabaseConnection() {
        loadConfig();
    }

    /**
     * Carga la configuración de la base de datos desde el archivo de propiedades.
     */
    private void loadConfig() {
        try (var inputStream = getClass().getResourceAsStream(CONFIG_FILE)) {
            if (inputStream == null) {
                throw new RuntimeException("No se encontró el archivo de configuración de la base de datos.");
            }

            java.util.Properties props = new java.util.Properties();
            props.load(inputStream);

            this.url = props.getProperty("db.url");
            this.user = props.getProperty("db.user");
            this.password = props.getProperty("db.password");

        } catch (SQLException | java.io.IOException e) {
            throw new RuntimeException("Error al cargar la configuración de la base de datos", e);
        }
    }

    /**
     * Establece y devuelve una conexión con la base de datos MySQL.
     *
     * @return Connection objeto de conexión activa
     * @throws SQLException si no se puede conectar
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * Cierra la conexión si está abierta.
     *
     * @param connection la conexión a cerrar
     */
    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
