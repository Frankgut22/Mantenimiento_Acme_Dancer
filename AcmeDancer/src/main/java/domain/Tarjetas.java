
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Tarjetas {

	// Constructors -----------------------------------------------------------
	public Tarjetas() {
		super();
	}


	// Identification ---------------------------------------------------------

	private int		id;
	private String	nombreAlumno;
	private String	nombreTitular;
	private int		numeroTarjeta;
	private int		mes;
	private int		anio;
	private int		cvv;


	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}
	@NotBlank
	public String getNombreAlumno() {
		return this.nombreAlumno;
	}
	public void setNombreAlumno(final String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}
	@NotBlank
	public String getNombreTitular() {
		return this.nombreTitular;
	}
	public void setNombreTitular(final String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}
	@NotBlank
	public int getNumeroTarjeta() {
		return this.numeroTarjeta;
	}
	public void setNumeroTarjeta(final int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	@NotBlank
	public int getMes() {
		return this.mes;
	}
	public void setMes(final int mes) {
		this.mes = mes;
	}
	@NotBlank
	public int getAnio() {
		return this.anio;
	}
	public void setAnio(final int anio) {
		this.anio = anio;
	}
	@NotBlank
	public int getCvv() {
		return this.cvv;
	}
	public void setCvv(final int cvv) {
		this.cvv = cvv;
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
		result.append(", nombreAlumno:");
		result.append(this.getNombreAlumno());
		result.append(", nombreTitular:");
		result.append(this.getNombreTitular());
		result.append(", numeroTarjeta:");
		result.append(this.getNumeroTarjeta());
		result.append(", Anio:");
		result.append(this.getAnio());
		result.append(", mes:");
		result.append(this.getMes());
		result.append(", cvv");
		result.append(this.getCvv());
		result.append("}");

		return result.toString();
	}
}
