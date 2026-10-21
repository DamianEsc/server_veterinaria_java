package dominio;

import java.util.ArrayList;
import dao.VeterinarioDAO;

public class GestionVeterinario {
    private VeterinarioDAO veterinarioDAO = new VeterinarioDAO();

    public int guardar(Veterinario veterinario) {
        try {
            return veterinarioDAO.guardar(veterinario);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<Veterinario> listar() {
        try {
            return (ArrayList<Veterinario>) veterinarioDAO.listar();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean actualizar(Veterinario veterinario) {
        try {
            return veterinarioDAO.actualizar(veterinario);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            return veterinarioDAO.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}