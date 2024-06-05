
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
	 *
	 * private TNivel nivel;
	 */


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

	@Override
	public String toString() {
		return "Curso [titulo=" + this.titulo + ", fecha_Inicio=" + this.fecha_Inicio + ", fecha_fin=" + this.fecha_fin + ", diaSemana=" + this.diaSemana + ", horaEjecucion=" + this.horaEjecucion + ", capacidad=" + this.capacidad + ", nombreComercial="
			+ this.nombreComercial + "]";
	}


	// Object interface -------------------------------------------------------
	/*
	 *
	 * private List<Estilo> estilos;
	 *
	 *
	 * @NotNull
	 *
	 * @Valid
	 *
	 * @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
	 * public List<Estilo> getEstilos() {
	 * return this.estilos;
	 * }
	 * public void setEstilos(final List<Estilo> estilos) {
	 * this.estilos = estilos;
	 * }
	 *
	 */
	private Academia nombreComercial;


	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Academia getNombreComercial() {
		return this.nombreComercial;
	}
	public void setNombreComercial(final Academia nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

}
