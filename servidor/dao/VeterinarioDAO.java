package dao;

import conexion.Conexion;
import dominio.Veterinario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) de la tabla "veterinario".
 * Recibe objetos Veterinario (del paquete dominio) y los guarda,
 * actualiza, elimina o lee desde MySQL usando la clase Conexion.
 */
public class VeterinarioDAO {

    /**
     * Inserta un veterinario nuevo.
     *
     * @return el id que asigno MySQL, o -1 si no se inserto nada.
     */
    public int guardar(Veterinario veterinario) throws SQLException {
        String sql = "INSERT INTO veterinario (nombre, contraseña, especialidad) VALUES (?, ?, ?)";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, veterinario.getNombre());
            ps.setString(2, veterinario.getContraseña());
            ps.setString(3, veterinario.getEspecialidad());
            
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
     * Devuelve todos los veterinarios guardados, ordenados por nombre.
     */
    public List<Veterinario> listar() throws SQLException {
        String sql = "SELECT id, nombre, contraseña, especialidad FROM veterinario ORDER BY nombre";
        List<Veterinario> lista = new ArrayList<>();

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Veterinario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("contraseña"),
                        rs.getString("especialidad")));
            }
        }
        return lista;
    }

    /**
     * Actualiza los datos de un veterinario ya existente (usando su id).
     *
     * @return true si se actualizo algun registro.
     */
    public boolean actualizar(Veterinario veterinario) throws SQLException {
        String sql = "UPDATE veterinario SET nombre = ?, contraseña = ?, especialidad = ? WHERE id = ?";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, veterinario.getNombre());
            ps.setString(2, veterinario.getContraseña());
            ps.setString(3, veterinario.getEspecialidad());
            ps.setInt(4, veterinario.getId());

            return ps.executeUpdate() > 0;
        }
    }

    /**
     * Elimina un veterinario por su id.
     *
     * @return true si se elimino algun registro.
     */
    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM veterinario WHERE id = ?";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
