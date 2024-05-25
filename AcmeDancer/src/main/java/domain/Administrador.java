
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Administrador extends Usuario {
	//He quitado el extens usuario en administrador, hay que ver como solucioanr eso

	// Constructors -----------------------------------------------------------
	public Administrador() {
		super();
	}
	// Identification ---------------------------------------------------------

	//@GeneratedValue(strategy = GenerationType.TABLE)

	// Object interface -------------------------------------------------------

}
