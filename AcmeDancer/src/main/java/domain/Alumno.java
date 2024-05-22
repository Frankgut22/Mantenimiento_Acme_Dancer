
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Alumno {
	//He quitado el extens usuario en administrador, hay que ver como solucioanr eso
	// Constructors -----------------------------------------------------------

	public Alumno() {
		super();
	}


	// Identification ---------------------------------------------------------
	private int		id;
	private int		version;
	private boolean	registrado;


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
	public boolean isRegistrado() {
		return this.registrado;
	}
	public void setRegistrado(final boolean registrado) {
		this.registrado = registrado;
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
		result.append(", version:");
		result.append(this.getVersion());
		result.append(", registrado:");
		result.append(this.isRegistrado());
		result.append("}");

		return result.toString();
	}

}