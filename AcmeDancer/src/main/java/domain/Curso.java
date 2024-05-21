
package domain;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Access(AccessType.PROPERTY)
public class Curso {

	private String	titulo;
	private Estilo	estilo;
	private TNivel	nivel;
	private Date	fecha_Inicio;
	private Date	fecha_fin;
	private String	diaSemana;
	private Time	horaEjecucion;
	private int		capacidad;

	private int		id;
	private int		version;


	public Curso() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	public Estilo getEstilo() {
		return this.estilo;
	}

	public void setEstilo(final Estilo estilo) {
		this.estilo = estilo;
	}

	public TNivel getNivel() {
		return this.nivel;
	}

	public void setNivel(final TNivel nivel) {
		this.nivel = nivel;
	}

	public Date getFecha_Inicio() {
		return this.fecha_Inicio;
	}

	public void setFecha_Inicio(final Date fecha_Inicio) {
		this.fecha_Inicio = fecha_Inicio;
	}

	public Date getFecha_fin() {
		return this.fecha_fin;
	}

	public void setFecha_fin(final Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public String getDiaSemana() {
		return this.diaSemana;
	}

	public void setDiaSemana(final String diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Time getHoraEjecucion() {
		return this.horaEjecucion;
	}

	public void setHoraEjecucion(final Time horaEjecucion) {
		this.horaEjecucion = horaEjecucion;
	}

	public int getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(final int capacidad) {
		this.capacidad = capacidad;
	}

}
