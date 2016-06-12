package ec.edu.epn.modelo;

import java.io.Serializable;
import javax.persistence.*;

import ec.edu.epn.modelo.Usuario;

@Entity
@Table(name="Request")
@NamedQuery(name="Request.findAll", query="SELECT re FROM Request re")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRequest;

	private String txtRequest;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id")
	private Usuario usuario;

	public Request() {
	}

	public int getIdRequest() {
		return this.idRequest;
	}

	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}

	public String getTxtRequest() {
		return this.txtRequest;
	}

	public void setTxtRequest(String txtRequest) {
		this.txtRequest = txtRequest;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}