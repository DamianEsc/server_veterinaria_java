package dominio;

public class Veterinario {

    private int id;
	private String nombre;
	private String contraseña;
	private String especialidad;

	public Veterinario(int id, String nombre, String contraseña, String especialidad) {
		this.id = id;
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.especialidad = especialidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
}