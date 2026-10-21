package dominio;

public class Consulta {

    private int id;
    private String procedimiento;
    private String fecha;
    private String hora;
    private int id_mascota;
    private int id_veterinario;

    public Consulta(int id, String procedimiento, String fecha, String hora, int id_mascota, int id_veterinario) {
        this.id = id;
        this.procedimiento = procedimiento;
        this.fecha = fecha;
        this.hora = hora;
        this.id_mascota = id_mascota;
        this.id_veterinario = id_veterinario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(int id_mascota) {
        this.id_mascota = id_mascota;
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }
}
