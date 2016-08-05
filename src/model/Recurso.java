package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Recurso database table.
 * 
 */
@Entity
@NamedQuery(name="Recurso.findAll", query="SELECT r FROM Recurso r")
public class Recurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRecurso;

	private String descripcion;

	private String titulo;

	private byte visible;

	/*//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="recurso")
	private List<Comentario> comentarios;*/

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="IdCategoria")
	private Categoria categoria;

	//bi-directional many-to-one association to SolicitudRecurso
	@ManyToOne
	@JoinColumn(name="IdSolicitud")
	private SolicitudRecurso solicitudRecurso;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="IdUsuario")
	private Usuario usuario;

	public Recurso() {
	}

	public int getIdRecurso() {
		return this.idRecurso;
	}

	public void setIdRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public byte getVisible() {
		return this.visible;
	}

	public void setVisible(byte visible) {
		this.visible = visible;
	}

	/*public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setRecurso(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setRecurso(null);

		return comentario;
	}*/

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public SolicitudRecurso getSolicitudRecurso() {
		return this.solicitudRecurso;
	}

	public void setSolicitudRecurso(SolicitudRecurso solicitudRecurso) {
		this.solicitudRecurso = solicitudRecurso;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}