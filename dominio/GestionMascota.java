package dominio;

import java.util.ArrayList;
import dao.MascotaDAO;

public class GestionMascota {
    private MascotaDAO mascotaDAO = new MascotaDAO();

    public int guardar(Mascota mascota) {
        try {
            return mascotaDAO.guardar(mascota);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<Mascota> listar() {
        try {
            return (ArrayList<Mascota>) mascotaDAO.listar();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean actualizar(Mascota mascota) {
        try {
            return mascotaDAO.actualizar(mascota);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            return mascotaDAO.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
