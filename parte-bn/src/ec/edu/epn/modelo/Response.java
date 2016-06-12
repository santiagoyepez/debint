package ec.edu.epn.modelo;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.modelo.Usuario;


/**
 * The persistent class for the Response database table.
 * 
 */
@Entity
@Table(name="Response")
@NamedQuery(name="Response.findAll", query="SELECT r FROM Response r")
public class Response implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idResponse;

	private String txtResponse;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id")
	private Usuario usuario;

	public Response() {
	}

	public int getIdResponse() {
		return this.idResponse;
	}

	public void setIdResponse(int idResponse) {
		this.idResponse = idResponse;
	}

	public String getTxtResponse() {
		return this.txtResponse;
	}

	public void setTxtResponse(String txtResponse) {
		this.txtResponse = txtResponse;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}