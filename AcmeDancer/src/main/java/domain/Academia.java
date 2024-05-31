
package domain;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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


	@NotBlank
	public String getNombreComercial() {
		return this.nombreComercial;
	}
	public void setNombreComercial(final String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}


	// Object interface -------------------------------------------------------

	private List<Tutorial> titulos;


	@NotNull
	@Valid
	@OneToMany(mappedBy = "nombreComercial", cascade = CascadeType.ALL)
	public List<Tutorial> getTitulos() {
		return this.titulos;
	}
	public void setTitulos(final List<Tutorial> titulos) {
		this.titulos = titulos;
	}


	private List<Curso> nombres;


	@NotNull
	@Valid
	@OneToMany(mappedBy = "nombreComercial", cascade = CascadeType.ALL)
	public List<Curso> getNombres() {
		return this.nombres;
	}
	public void setNombres(final List<Curso> nombres) {
		this.nombres = nombres;
	}
}
