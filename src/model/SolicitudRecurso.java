package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SolicitudRecurso database table.
 * 
 */
@Entity
@NamedQuery(name="SolicitudRecurso.findAll", query="SELECT s FROM SolicitudRecurso s")
public class SolicitudRecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idSolicitud;

	private String comentario;

	private int puntos;

	private String recursoSolicitado;

	/*//bi-directional many-to-one association to Recurso
	@OneToMany(mappedBy="solicitudRecurso")
	private List<Recurso> recursos;*/

	public SolicitudRecurso() {
	}

	public int getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getPuntos() {
		return this.puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String getRecursoSolicitado() {
		return this.recursoSolicitado;
	}

	public void setRecursoSolicitado(String recursoSolicitado) {
		this.recursoSolicitado = recursoSolicitado;
	}

	/*public List<Recurso> getRecursos() {
		return this.recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public Recurso addRecurso(Recurso recurso) {
		getRecursos().add(recurso);
		recurso.setSolicitudRecurso(this);

		return recurso;
	}

	public Recurso removeRecurso(Recurso recurso) {
		getRecursos().remove(recurso);
		recurso.setSolicitudRecurso(null);

		return recurso;
	}*/

}