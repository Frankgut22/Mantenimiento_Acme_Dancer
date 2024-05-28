
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Academia extends Usuario {

	// Constructors -----------------------------------------------------------

	public Academia() {
		super();
	}


	// Identification ---------------------------------------------------------

	private String nombreComercial;


	@GeneratedValue(strategy = GenerationType.TABLE)

	@NotBlank
	public String getNombreComercial() {
		return this.nombreComercial;
	}
	public void setNombreComercial(final String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	// Object interface -------------------------------------------------------

}
