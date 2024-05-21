
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class Tarjetas {

	private String	nombreAlumno;
	private String	nombreTitular;
	private int		numeroTarjeta;
	private int		mes;
	private int		anio;
	private int		cvv;


	public String getNombreAlumno() {
		return this.nombreAlumno;
	}

	public void setNombreAlumno(final String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getNombreTitular() {
		return this.nombreTitular;
	}

	public void setNombreTitular(final String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public int getNumeroTarjeta() {
		return this.numeroTarjeta;
	}

	public void setNumeroTarjeta(final int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public int getMes() {
		return this.mes;
	}

	public void setMes(final int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(final int anio) {
		this.anio = anio;
	}

	public int getCvv() {
		return this.cvv;
	}

	public void setCvv(final int cvv) {
		this.cvv = cvv;
	}

}
