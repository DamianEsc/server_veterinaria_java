package dominio;

import java.util.ArrayList;
import dao.DuenoDAO;

public class GestionDueno {
    private DuenoDAO duenoDAO = new DuenoDAO();

    public int guardar(Dueno dueno) {
        try {
            return duenoDAO.guardar(dueno);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<Dueno> listar() {
        try {
            return (ArrayList<Dueno>) duenoDAO.listar();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean actualizar(Dueno dueno) {
        try {
            return duenoDAO.actualizar(dueno);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            return duenoDAO.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}