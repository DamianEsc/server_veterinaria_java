package dominio;

import java.util.ArrayList;
import dao.VacunaDAO;

public class GestionVacuna {
    private VacunaDAO vacunaDAO = new VacunaDAO();

    public int guardar(Vacuna vacuna) {
        try {
            return vacunaDAO.guardar(vacuna);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<Vacuna> listar() {
        try {
            return (ArrayList<Vacuna>) vacunaDAO.listar();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean actualizar(Vacuna vacuna) {
        try {
            return vacunaDAO.actualizar(vacuna);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            return vacunaDAO.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
