package modelo.datos;

public class DatosSolicitudRecurso extends DatosBdD {
	private int idSolicitud, puntos;
	private String recursoSolicitado, comentario;
	public int getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public String getRecursoSolicitado() {
		return recursoSolicitado;
	}
	public void setRecursoSolicitado(String recursoSolicitado) {
		this.recursoSolicitado = recursoSolicitado;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
