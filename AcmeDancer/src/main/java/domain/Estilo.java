
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Estilo {

	// Constructors -----------------------------------------------------------
	public Estilo() {
		super();
	}


	// Identification ---------------------------------------------------------

	private int		id;
	private String	nombre;
	private String	descripcion;
	private String	imagen;
	private String	video;


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
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	@NotBlank
	public String getImagen() {
		return this.imagen;
	}
	public void setImagen(final String imagen) {
		this.imagen = imagen;
	}
	@NotBlank
	public String getVideo() {
		return this.video;
	}
	public void setVideo(final String video) {
		this.video = video;
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
		result.append(", nombre:");
		result.append(this.getNombre());
		result.append(", descripcion:");
		result.append(this.getDescripcion());
		result.append(", imagen:");
		result.append(this.getImagen());
		result.append(", video:");
		result.append(this.getVideo());
		result.append("}");

		return result.toString();
	}
}
