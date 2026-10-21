package dao;

import conexion.Conexion;
import dominio.Dueno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) de la tabla "dueño".
 * Recibe objetos Dueno (del paquete dominio) y los guarda,
 * actualiza, elimina o lee desde MySQL usando la clase Conexion.
 */
public class DuenoDAO {

    /**
     * Inserta un dueno nuevo.
     *
     * @return el id que asigno MySQL, o -1 si no se inserto nada.
     */
    public int guardar(Dueno dueno) throws SQLException {
        String sql = "INSERT INTO dueño (nombre, ci, telefono, email) VALUES (?, ?, ?, ?)";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, dueno.getNombre());
            ps.setString(2, dueno.getCi());
            ps.setString(3, dueno.getTelefono());
            ps.setString(4, dueno.getEmail());

            int filas = ps.executeUpdate();
            if (filas == 0) {
                return -1;
            }

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
            return -1;
        }
    }

    /**
     * Devuelve todos los duenos guardados, ordenados por nombre.
     */
    public List<Dueno> listar() throws SQLException {
        String sql = "SELECT id, nombre, ci, telefono, email FROM dueño ORDER BY nombre";
        List<Dueno> lista = new ArrayList<>();

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Dueno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("ci"),
                        rs.getString("telefono"),
                        rs.getString("email")));
            }
        }
        return lista;
    }

    /**
     * Actualiza los datos de un dueno ya existente (usando su id).
     *
     * @return true si se actualizo algun registro.
     */
    public boolean actualizar(Dueno dueno) throws SQLException {
        String sql = "UPDATE dueño SET nombre = ?, ci = ?, telefono = ?, email = ? WHERE id = ?";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, dueno.getNombre());
            ps.setString(2, dueno.getCi());
            ps.setString(3, dueno.getTelefono());
            ps.setString(4, dueno.getEmail());
            ps.setInt(5, dueno.getId());

            return ps.executeUpdate() > 0;
        }
    }

    /**
     * Elimina un dueno por su id.
     *
     * @return true si se elimino algun registro.
     */
    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM dueño WHERE id = ?";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
