
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Solicitud_curso {

	// Constructors -----------------------------------------------------------
	public Solicitud_curso() {
		super();
	}


	// Identification ---------------------------------------------------------

	private int		id;
	private String	nombre;
	private Date	fecha_inicio;
	private Date	fecha_fin;
	private String	descripcion;
	//private Estilo	estilo;


	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getId() {
		return this.id;
	}
	public void setId(final int id) {
		this.id = id;
	}
	@NotBlank
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	@NotBlank
	public Date getFecha_inicio() {
		return this.fecha_inicio;
	}
	public void setFecha_inicio(final Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	@NotBlank
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
		result.append(", nombre:");
		result.append(this.getNombre());
		result.append(", fecha_inicio:");
		result.append(this.getFecha_inicio());
		result.append(", fecha_fin:");
		result.append(this.getFecha_fin());
		result.append(", descripcion:");
		result.append(this.getDescripcion());
		/*
		 * result.append(", estilo:");
		 * result.append(this.getEstilo());
		 */
		result.append("}");

		return result.toString();
	}
}
