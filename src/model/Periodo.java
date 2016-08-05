package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Periodo database table.
 * 
 */
@Entity
@NamedQuery(name="Periodo.findAll", query="SELECT p FROM Periodo p")
public class Periodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPeriodo;

	private int anio;

	private String parte;

	/*//bi-directional many-to-one association to Categoria
	@OneToMany(mappedBy="periodo")
	private List<Categoria> categorias;*/

	public Periodo() {
	}

	public int getIdPeriodo() {
		return this.idPeriodo;
	}

	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int año) {
		this.anio = año;
	}

	public String getParte() {
		return this.parte;
	}

	public void setParte(String parte) {
		this.parte = parte;
	}

	/*public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Categoria addCategoria(Categoria categoria) {
		getCategorias().add(categoria);
		categoria.setPeriodo(this);

		return categoria;
	}

	public Categoria removeCategoria(Categoria categoria) {
		getCategorias().remove(categoria);
		categoria.setPeriodo(null);

		return categoria;
	}*/

}