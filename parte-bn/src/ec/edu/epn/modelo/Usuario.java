package ec.edu.epn.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String password;

	private String username;

	//bi-directional many-to-one association to Response
	@OneToMany(mappedBy="usuario")
	private List<Response> responses;
	
	
		
	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="usuario")
	private List<Request> requests;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Response> getResponses() {
		return this.responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

	public Response addRespons(Response respons) {
		getResponses().add(respons);
		respons.setUsuario(this);

		return respons;
	}

	public Response removeRespons(Response respons) {
		getResponses().remove(respons);
		respons.setUsuario(null);

		return respons;
	}

	public List<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Request addRequest(Request request) {
		getRequests().add(request);
		request.setUsuario(this);

		return request;
	}

	public Request removeRequest(Request request) {
		getRequests().remove(request);
		request.setUsuario(null);

		return request;
	}

}