
package domain;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Curso {
	// Constructors -----------------------------------------------------------

	public Curso() {
		super();
	}


	// Identification ---------------------------------------------------------

	private int		id;
	private int		version;
	private String	titulo;
	private Date	fecha_Inicio;
	private Date	fecha_fin;
	private String	diaSemana;
	private Time	horaEjecucion;
	private int		capacidad;
	/*
	 * FALTA POR HACER
	 * private Estilo estilo;
	 * private TNivel nivel;
	 */


	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	@Version
	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}
	@NotBlank
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}
	@NotBlank
	public Date getFecha_Inicio() {
		return this.fecha_Inicio;
	}
	public void setFecha_Inicio(final Date fecha_Inicio) {
		this.fecha_Inicio = fecha_Inicio;
	}
	@NotBlank
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
	@NotBlank
	public Time getHoraEjecucion() {
		return this.horaEjecucion;
	}
	public void setHoraEjecucion(final Time horaEjecucion) {
		this.horaEjecucion = horaEjecucion;
	}
	@NotBlank
	public int getCapacidad() {
		return this.capacidad;
	}
	public void setCapacidad(final int capacidad) {
		this.capacidad = capacidad;
	}
	// Object interface -------------------------------------------------------

	@Override
	public int hashCode() {
		return this.getId();
	}

	@Override
	public boolean equals(final Object other) {
		boolean result;

		if (this == other)
			result = true;
		else if (other == null)
			result = false;
		else if (other instanceof Integer)
			result = (this.getId() == (Integer) other);
		else if (!this.getClass().isInstance(other))
			result = false;
		else
			result = (this.getId() == ((DomainEntity) other).getId());

		return result;
	}

	@Override
	public String toString() {
		StringBuilder result;

		result = new StringBuilder();
		result.append(this.getClass().getName());
		result.append("{");
		result.append("id=");
		result.append(this.getId());
		result.append(", version=");
		result.append(this.getVersion());
		result.append(", titulo:");
		result.append(this.getTitulo());
		result.append(", fecha_Inicio:");
		result.append(this.getFecha_Inicio());
		result.append(", fecha_Fin:");
		result.append(this.getFecha_fin());
		result.append(", diaSemana:");
		result.append(this.getDiaSemana());
		result.append(", horaEjecucion:");
		result.append(this.getHoraEjecucion());
		result.append(", capacidad:");
		result.append(this.getCapacidad());
		result.append("}");

		return result.toString();
	}

}
