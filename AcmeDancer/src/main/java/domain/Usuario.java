
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import security.UserAccount;

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
	@Pattern(regexp = "^([+-]\\d+\\s+)?(\\([0-9]+\\)\\s+)?([\\d\\w\\s-]+)$")
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


	// Relationships ----------------------------------------------------------
	private UserAccount userAccount;


	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(final UserAccount userAccount) {
		this.userAccount = userAccount;
	}
}
