
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Tarjeta extends DomainEntity {

	// Constructors -----------------------------------------------------------
	public Tarjeta() {
		super();
	}


	// Identification ---------------------------------------------------------

	private String	nombreTitular;
	private int		numeroTarjeta;
	private String	tipoTarjeta;
	private int		mes;
	private int		anio;
	private int		cvv;


	@GeneratedValue(strategy = GenerationType.TABLE)
	@NotBlank
	public String getNombreTitular() {
		return this.nombreTitular;
	}
	public void setNombreTitular(final String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	@Min(1)
	public int getNumeroTarjeta() {
		return this.numeroTarjeta;
	}
	public void setNumeroTarjeta(final int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	@Min(1)
	public int getMes() {
		return this.mes;
	}
	public void setMes(final int mes) {
		this.mes = mes;
	}
	@NotBlank
	public String getTipoTarjeta() {
		return this.tipoTarjeta;
	}

	public void setTipoTarjeta(final String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	@Min(1)
	public int getAnio() {
		return this.anio;
	}
	public void setAnio(final int anio) {
		this.anio = anio;
	}
	@Min(1)
	public int getCvv() {
		return this.cvv;
	}
	public void setCvv(final int cvv) {
		this.cvv = cvv;
	}


	// Object interface -------------------------------------------------------

	private Alumno id_alumno;


	@NotNull
	@Valid
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	public Alumno getId_alumno() {
		return this.id_alumno;
	}
	public void setId_alumno(final Alumno id_alumno) {
		this.id_alumno = id_alumno;
	}

}
