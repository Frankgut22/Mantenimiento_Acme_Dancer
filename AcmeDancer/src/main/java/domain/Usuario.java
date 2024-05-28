
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario extends DomainEntity {
	// Constructors -----------------------------------------------------------

	public Usuario() {
		super();
	}


	// Identification ---------------------------------------------------------
	private String	nombre;
	private String	apellidos;
	private String	direccion;
	private String	codigoPostal;
	private String	telefono;
	private String	email;


	@GeneratedValue(strategy = GenerationType.TABLE)
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
	public String getCodigoPostal() {
		return this.codigoPostal;
	}
	public void setCodigoPostal(final String codigoPostal) {
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
}
