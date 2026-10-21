package dao;

import conexion.Conexion;
import dominio.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) de la tabla "consulta".
 * Recibe objetos Consulta (del paquete dominio) y los guarda,
 * actualiza, elimina o lee desde MySQL usando la clase Conexion.
 */
public class ConsultaDAO {

    /**
     * Inserta una consulta nueva.
     *
     * @return el id que asigno MySQL, o -1 si no se inserto nada.
     */
    public int guardar(Consulta consulta) throws SQLException {
        String sql = "INSERT INTO consulta (procedimiento, fecha, hora, id_mascota, id_veterinario) VALUES (?, ?, ?, ?, ?)";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, consulta.getProcedimiento());
            ps.setString(2, consulta.getFecha());
            ps.setString(3, consulta.getHora());
            ps.setInt(4, consulta.getId_mascota());
            ps.setInt(5, consulta.getId_veterinario());

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
     * Devuelve todas las consultas guardadas, ordenadas por fecha.
     */
    public List<Consulta> listar() throws SQLException {
        String sql = "SELECT id, procedimiento, fecha, hora, id_mascota, id_veterinario FROM consulta ORDER BY fecha";
        List<Consulta> lista = new ArrayList<>();

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Consulta(
                        rs.getInt("id"),
                        rs.getString("procedimiento"),
                        rs.getString("fecha"),
                        rs.getString("hora"),
                        rs.getInt("id_mascota"),
                        rs.getInt("id_veterinario")
                ));
            }
        }
        return lista;
    }

    /**
     * Actualiza los datos de una consulta ya existente (usando su id).
     *
     * @return true si se actualizo algun registro.
     */
    public boolean actualizar(Consulta consulta) throws SQLException {
        String sql = "UPDATE consulta SET procedimiento = ?, fecha = ?, hora = ?, id_mascota = ?, id_veterinario = ? WHERE id = ?";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, consulta.getProcedimiento());
            ps.setString(2, consulta.getFecha());
            ps.setString(3, consulta.getHora());
            ps.setInt(4, consulta.getId_mascota());
            ps.setInt(5, consulta.getId_veterinario());
            ps.setInt(6, consulta.getId());

            return ps.executeUpdate() > 0;
        }
    }

    /**
     * Elimina una consulta por su id.
     *
     * @return true si se elimino algun registro.
     */
    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM consulta WHERE id = ?";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
