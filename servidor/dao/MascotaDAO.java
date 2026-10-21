package dao;

import conexion.Conexion;
import dominio.Mascota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO (Data Access Object) de la tabla "mascota".
 * Recibe objetos Mascota (del paquete dominio) y los guarda,
 * actualiza, elimina o lee desde MySQL usando la clase Conexion.
 */
public class MascotaDAO {

    /**
     * Inserta una mascota nueva.
     *
     * @return el id que asigno MySQL, o -1 si no se inserto nada.
     */
    public int guardar(Mascota mascota) throws SQLException {
        String sql = "INSERT INTO mascota (nombre, edad, especie, raza, genero, peso, id_dueño) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, mascota.getNombre());
            ps.setInt(2, mascota.getEdad());
            ps.setString(3, mascota.getEspecie());
            ps.setString(4, mascota.getRaza());
            ps.setString(5, mascota.getGenero());
            ps.setDouble(6, mascota.getPeso());
            ps.setInt(7, mascota.getId_dueno());

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
     * Devuelve todas las mascotas guardadas, ordenadas por nombre.
     */
    public List<Mascota> listar() throws SQLException {
        String sql = "SELECT id, nombre, edad, especie, raza, genero, peso, id_dueno FROM mascota ORDER BY nombre";
        List<Mascota> lista = new ArrayList<>();

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Mascota(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("edad"),
                        rs.getString("especie"),
                        rs.getString("raza"),
                        rs.getString("genero"),
                        rs.getDouble("peso"),
                        rs.getInt("id_dueno")));
            }
        }
        return lista;
    }
    /**
     * Actualiza los datos de una mascota ya existente (usando su id).
     *
     * @return true si se actualizo algun registro.
     */
    public boolean actualizar(Mascota mascota) throws SQLException {
        String sql = "UPDATE mascota SET nombre = ?, edad = ?, especie = ?, raza = ?, genero = ?, peso = ?, id_dueno = ? WHERE id = ?";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, mascota.getNombre());
            ps.setInt(2, mascota.getEdad());
            ps.setString(3, mascota.getEspecie());
            ps.setString(4, mascota.getRaza());
            ps.setString(5, mascota.getGenero());
            ps.setDouble(6, mascota.getPeso());
            ps.setInt(7, mascota.getId_dueno());
            ps.setInt(8, mascota.getId());

            return ps.executeUpdate() > 0;
        }
    }

    /**
     * Elimina una mascota por su id.
     *
     * @return true si se elimino algun registro.
     */
    public boolean eliminar(int id) throws SQLException {
        String sql = "DELETE FROM mascota WHERE id = ?";

        try (Connection cn = Conexion.getConexion();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        }
    }
}
