
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Alumno extends Usuario {

	public Alumno() {
		super();
	}


	private boolean	registrado;

	private int		id;
	private int		version;


	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getId() {
		return this.id;
	}

	@Override
	public void setId(final int id) {
		this.id = id;
	}

	public boolean isRegistrado() {
		return this.registrado;
	}

	public void setRegistrado(final boolean registrado) {
		this.registrado = registrado;
	}

}
