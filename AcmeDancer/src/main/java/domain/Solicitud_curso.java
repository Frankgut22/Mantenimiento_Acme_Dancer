
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Solicitud_curso extends DomainEntity {

	// Constructors -----------------------------------------------------------
	public Solicitud_curso() {
		super();
	}


	// Identification ---------------------------------------------------------

	private String	nombre;
	private Date	fecha_inicio;
	private Date	fecha_fin;
	private String	descripcion;
	//private Estilo	estilo;


	@GeneratedValue(strategy = GenerationType.TABLE)

	@NotBlank
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	public Date getFecha_inicio() {
		return this.fecha_inicio;
	}
	public void setFecha_inicio(final Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	public Date getFecha_fin() {
		return this.fecha_fin;
	}
	public void setFecha_fin(final Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	@NotBlank
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	/*
	 * @NotBlank
	 * public Estilo getEstilo() {
	 * return this.estilo;
	 * }
	 * public void setEstilo(final Estilo estilo) {
	 * this.estilo = estilo;
	 * }
	 */
	// Object interface -------------------------------------------------------

}
