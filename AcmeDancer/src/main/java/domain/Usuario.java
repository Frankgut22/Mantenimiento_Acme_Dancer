
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario {
	// Constructors -----------------------------------------------------------

	public Usuario() {
		super();
	}


	// Identification ---------------------------------------------------------
	private int		id;
	private String	nombre;
	private String	apellidos;
	private String	direccion;
	private int		codigoPostal;
	private String	telefono;
	private String	email;


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
	public String getApellidos() {
		return this.apellidos;
	}
	public void setApellidos(final String apellidos) {
		this.apellidos = apellidos;
	}
	@NotBlank
	public String getDireccion() {
		return this.direccion;
	}
	public void setDireccion(final String direccion) {
		this.direccion = direccion;
	}
	@NotBlank
	public int getCodigoPostal() {
		return this.codigoPostal;
	}
	public void setCodigoPostal(final int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	@NotBlank
	public String getTelefono() {
		return this.telefono;
	}
	public void setTelefono(final String telefono) {
		this.telefono = telefono;
	}
	@Email
	public String getEmail() {
		return this.email;
	}
	public void setEmail(final String email) {
		this.email = email;
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
		result.append(", apellidos:");
		result.append(this.getApellidos());
		result.append(", direccion:");
		result.append(this.getDireccion());
		result.append(", codigoPostal:");
		result.append(this.getCodigoPostal());
		result.append(", telefono:");
		result.append(this.getTelefono());
		result.append(", email:");
		result.append(this.getEmail());
		result.append("}");

		return result.toString();
	}

}
