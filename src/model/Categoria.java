package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCategoria;

	//bi-directional many-to-one association to Materia
	@ManyToOne
	@JoinColumn(name="IdMateria")
	private Materia materia;

	//bi-directional many-to-one association to Periodo
	@ManyToOne
	@JoinColumn(name="IdPeriodo")
	private Periodo periodo;

	/*//bi-directional many-to-one association to Recurso
	@OneToMany(mappedBy="categoria")
	private List<Recurso> recursos;*/

	public Categoria() {
	}

	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Materia getMateria() {
		return this.materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Periodo getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	/*public List<Recurso> getRecursos() {
		return this.recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public Recurso addRecurso(Recurso recurso) {
		getRecursos().add(recurso);
		recurso.setCategoria(this);

		return recurso;
	}

	public Recurso removeRecurso(Recurso recurso) {
		getRecursos().remove(recurso);
		recurso.setCategoria(null);

		return recurso;
	}*/

}