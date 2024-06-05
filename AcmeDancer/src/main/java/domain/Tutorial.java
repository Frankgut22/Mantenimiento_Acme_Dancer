
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tutorial extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Tutorial() {
		super();
	}


	// Identification ---------------------------------------------------------

	private String	titulo;
	private String	descripcion;
	private String	video;


	@NotBlank
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}
	@NotBlank
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	@NotBlank
	public String getVideo() {
		return this.video;
	}
	public void setVideo(final String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "Tutorial [titulo=" + this.titulo + ", fecha_Inicio=" + this.descripcion + ", video=" + this.video + ", nombreComercial=" + this.nombreComercial + "]";
	}
	// Object interface -------------------------------------------------------


	private Academia nombreComercial;


	@NotNull
	@Valid
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	public Academia getNombreComercial() {
		return this.nombreComercial;
	}
	public void setNombreComercial(final Academia nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
}
