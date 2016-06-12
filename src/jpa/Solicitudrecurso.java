package jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the solicitudrecurso database table.
 * 
 */
@Entity
@NamedQuery(name="Solicitudrecurso.findAll", query="SELECT s FROM Solicitudrecurso s")
public class Solicitudrecurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSolicitud;

	private String comentario;

	private int puntos;

	private String recursoSolicitado;

	//bi-directional many-to-one association to Recurso
	@OneToMany(mappedBy="solicitudrecurso")
	private List<Recurso> recursos;

	public Solicitudrecurso() {
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

	public List<Recurso> getRecursos() {
		return this.recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public Recurso addRecurso(Recurso recurso) {
		getRecursos().add(recurso);
		recurso.setSolicitudrecurso(this);

		return recurso;
	}

	public Recurso removeRecurso(Recurso recurso) {
		getRecursos().remove(recurso);
		recurso.setSolicitudrecurso(null);

		return recurso;
	}

}