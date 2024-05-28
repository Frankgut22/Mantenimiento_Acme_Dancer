
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Curso extends DomainEntity {
	// Constructors -----------------------------------------------------------

	public Curso() {
		super();
	}


	// Identification ---------------------------------------------------------

	private String	titulo;
	private Date	fecha_Inicio;
	private Date	fecha_fin;
	private String	diaSemana;
	private String	horaEjecucion;
	private int		capacidad;
	/*
	 * FALTA POR HACER
	 * private Estilo estilo;
	 * private TNivel nivel;
	 */


	@GeneratedValue(strategy = GenerationType.TABLE)

	@NotBlank
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	public Date getFecha_Inicio() {
		return this.fecha_Inicio;
	}
	public void setFecha_Inicio(final Date fecha_Inicio) {
		this.fecha_Inicio = fecha_Inicio;
	}
	@DateTimeFormat(pattern = "dd/MM/YYYY")
	public Date getFecha_fin() {
		return this.fecha_fin;
	}
	public void setFecha_fin(final Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	@NotBlank
	public String getDiaSemana() {
		return this.diaSemana;
	}
	public void setDiaSemana(final String diaSemana) {
		this.diaSemana = diaSemana;
	}
	@DateTimeFormat(pattern = "dd/MM/YYYY HH:mm")
	public String getHoraEjecucion() {
		return this.horaEjecucion;
	}
	public void setHoraEjecucion(final String horaEjecucion) {
		this.horaEjecucion = horaEjecucion;
	}
	@Min(1)
	public int getCapacidad() {
		return this.capacidad;
	}
	public void setCapacidad(final int capacidad) {
		this.capacidad = capacidad;
	}
	// Object interface -------------------------------------------------------

}
