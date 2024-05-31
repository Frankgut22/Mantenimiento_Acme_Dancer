
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Estilo extends DomainEntity {

	// Constructors -----------------------------------------------------------
	public Estilo() {
		super();
	}


	// Identification ---------------------------------------------------------

	private String	nombre;
	private String	descripcion;
	private String	imagen;
	private String	video;


	@GeneratedValue(strategy = GenerationType.TABLE)

	@NotBlank
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	@NotBlank
	public String getDescripcion() {
		return this.descripcion;
	}
	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}
	@NotBlank
	public String getImagen() {
		return this.imagen;
	}
	public void setImagen(final String imagen) {
		this.imagen = imagen;
	}
	@NotBlank
	public String getVideo() {
		return this.video;
	}
	public void setVideo(final String video) {
		this.video = video;
	}
	// Object interface -------------------------------------------------------


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
