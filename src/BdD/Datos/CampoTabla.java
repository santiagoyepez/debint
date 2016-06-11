package BdD.Datos;

public class CampoTabla {
	public final String h = "";
	private String nombreCampo;
	private Object valor;
	
	public CampoTabla(String nombreCampo) {
		this.nombreCampo = nombreCampo;
		valor = null;
	}
	
	public String getNombreCampo() {
		return nombreCampo;
	}

	public Object getValor() {
		return valor;
	}
	
	public String getValorInsercion() {
		String ret = "";
		if (valor instanceof String) {
			if (((String) valor).equals("<dbnull>")) ret = "null";
			else ret = "'" + valor.toString() + "'";
		} else {
			ret = valor.toString();
		}
		return ret;
	}
	
	public void setValor(Object valor) {
		this.valor = valor;
	}
	
}
