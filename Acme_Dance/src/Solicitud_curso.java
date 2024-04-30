import java.util.Date;

public class Solicitud_curso {

	private String	nombre;
	private Date	fecha_inicio;
	private Date	fecha_fin;
	private String	descripcion;
	private Estilo	estilo;


	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha_inicio() {
		return this.fecha_inicio;
	}

	public void setFecha_inicio(final Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return this.fecha_fin;
	}

	public void setFecha_fin(final Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public Estilo getEstilo() {
		return this.estilo;
	}

	public void setEstilo(final Estilo estilo) {
		this.estilo = estilo;
	}

}
