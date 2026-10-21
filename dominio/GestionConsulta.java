package dominio;

import java.util.ArrayList;
import dao.ConsultaDAO;

public class GestionConsulta {
    private ConsultaDAO consultaDAO = new ConsultaDAO();

    public int guardar(Consulta consulta) {
        try {
            return consultaDAO.guardar(consulta);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<Consulta> listar() {
        try {
            return (ArrayList<Consulta>) consultaDAO.listar();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public boolean actualizar(Consulta consulta) {
        try {
            return consultaDAO.actualizar(consulta);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        try {
            return consultaDAO.eliminar(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
