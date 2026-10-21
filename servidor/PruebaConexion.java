import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Prueba de conexion: abre la base de datos, ejecuta un SELECT
 * sobre la tabla duenos y muestra los registros encontrados.
 *
 * Compilar (desde la raiz del proyecto):
 * javac -encoding UTF-8 -cp "lib\mysql-connector-j-8.0.33.jar" -d bin
 * conexion\Conexion.java PruebaConexion.java
 *
 * Ejecutar:
 * java -cp "bin;lib\mysql-connector-j-8.0.33.jar" PruebaConexion
 *
 * Requisitos: MySQL (XAMPP) iniciado y veterinaria.sql importado.
 */
public class PruebaConexion {

    public static void main(String[] args) {
        String sql = "SELECT id, nombre, ci, telefono, email FROM dueño";

        // try-with-resources: cierra solo la conexion, el Statement y el ResultSet
        try (Connection cn = Conexion.getConexion();
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql)) {

            System.out.println("Conexion OK a veterinaria\n");
            System.out.println("Registros en la tabla dueño:\n");

            int contador = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String ci = rs.getString("ci");
                String telefono = rs.getString("telefono");
                String email = rs.getString("email");

                System.out.println("ID: " + id
                        + " | Nombre: " + nombre
                        + " | CI: " + ci
                        + " | Telefono: " + telefono
                        + " | Email: " + email);
                contador++;
            }

            if (contador == 0) {
                System.out.println("(La tabla dueño esta vacia)");
            } else {
                System.out.println("\nTotal: " + contador + " dueño(s)");
            }

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Revisa que MySQL (XAMPP) este iniciado y que hayas importado veterinaria.sql");
            e.printStackTrace();
        }
    }
}
