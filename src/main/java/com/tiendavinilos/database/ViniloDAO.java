package com.tiendavinilos.database;

import com.tiendavinilos.model.Vinilo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Realiza las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para los vinilos en la base de datos MySQL.
 */
public class ViniloDAO {

    private final DatabaseConnection dbConnection;

    public ViniloDAO() {
        this.dbConnection = new DatabaseConnection();
    }

    /**
     * Obtiene todos los vinilos de la base de datos.
     *
     * @return lista de todos los vinilos
     */
    public List<Vinilo> findAll() {
        List<Vinilo> vinilos = new ArrayList<>();
        String sql = "SELECT id, titulo, artista, precio, anio, genero FROM vinilos";

        try (Connection conn = dbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                vinilos.add(extractVinilo(rs));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener vinilos: " + e.getMessage());
        }

        return vinilos;
    }

    /**
     * Busca un vinilo por su ID.
     *
     * @param id del vinilo
     * @return el vinilo encontrado, o null si no existe
     */
    public Vinilo findById(int id) {
        String sql = "SELECT id, titulo, artista, precio, anio, genero FROM vinilos WHERE id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return extractVinilo(rs);
                }
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar vinilo por ID: " + e.getMessage());
        }

        return null;
    }

    /**
     * Agrega un nuevo vinilo a la base de datos.
     *
     * @param vinilo el vinilo a agregar
     * @return true si se agregó correctamente
     */
    public boolean insert(Vinilo vinilo) {
        String sql = "INSERT INTO vinilos (titulo, artista, precio, anio, genero) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vinilo.getTitulo());
            pstmt.setString(2, vinilo.getArtista());
            pstmt.setDouble(3, vinilo.getPrecio());
            pstmt.setInt(4, vinilo.getAnio());
            pstmt.setString(5, vinilo.getGenero());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al agregar vinilo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Actualiza un vinilo existente en la base de datos.
     *
     * @param vinilo el vinilo con los datos actualizados
     * @return true si se actualizó correctamente
     */
    public boolean update(Vinilo vinilo) {
        String sql = "UPDATE vinilos SET titulo = ?, artista = ?, precio = ?, anio = ?, genero = ? WHERE id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vinilo.getTitulo());
            pstmt.setString(2, vinilo.getArtista());
            pstmt.setDouble(3, vinilo.getPrecio());
            pstmt.setInt(4, vinilo.getAnio());
            pstmt.setString(5, vinilo.getGenero());
            pstmt.setInt(6, vinilo.getId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar vinilo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Elimina un vinilo de la base de datos.
     *
     * @param id del vinilo a eliminar
     * @return true si se eliminó correctamente
     */
    public boolean delete(int id) {
        String sql = "DELETE FROM vinilos WHERE id = ?";

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar vinilo: " + e.getMessage());
            return false;
        }
    }

    /**
     * Extrae un objeto Vinilo desde un ResultSet.
     */
    private Vinilo extractVinilo(ResultSet rs) throws SQLException {
        Vinilo vinilo = new Vinilo();
        vinilo.setId(rs.getInt("id"));
        vinilo.setTitulo(rs.getString("titulo"));
        vinilo.setArtista(rs.getString("artista"));
        vinilo.setPrecio(rs.getDouble("precio"));
        vinilo.setAnio(rs.getInt("anio"));
        vinilo.setGenero(rs.getString("genero"));
        return vinilo;
    }
}
