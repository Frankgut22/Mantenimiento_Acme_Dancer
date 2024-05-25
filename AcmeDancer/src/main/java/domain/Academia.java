
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
		result.append(", Nombre de la academia=");
		result.append(this.getNombreComercial());
		result.append("}");

		return result.toString();
	}

}
