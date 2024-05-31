
package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Alumno extends Usuario {
	// Constructors -----------------------------------------------------------

	public Alumno() {
		super();
	}


	// Identification ---------------------------------------------------------
	private String id_alumno;


	@NotBlank
	public String getId_alumno() {
		return this.id_alumno;
	}
	public void setId_alumno(final String id_alumno) {
		this.id_alumno = id_alumno;
	}

	//@GeneratedValue(strategy = GenerationType.TABLE)


	// Object interface -------------------------------------------------------
	private List<Tarjeta> nombreTitular;


	@NotNull
	@Valid
	@OneToMany(mappedBy = "id_alumno", cascade = CascadeType.ALL)
	public List<Tarjeta> getNombreTitular() {
		return this.nombreTitular;
	}
	public void setNombreTitular(final List<Tarjeta> nombreTitular) {
		this.nombreTitular = nombreTitular;
	}


	private Curso titulo;


	@NotNull
	@Valid
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	public Curso getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final Curso titulo) {
		this.titulo = titulo;
	}

}
