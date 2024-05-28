
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Alumno extends Usuario {
	// Constructors -----------------------------------------------------------

	public Alumno() {
		super();
	}

	// Identification ---------------------------------------------------------

	//@GeneratedValue(strategy = GenerationType.TABLE)

	// Object interface -------------------------------------------------------

}
