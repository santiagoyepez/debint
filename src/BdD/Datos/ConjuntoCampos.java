package BdD.Datos;

import java.util.ArrayList;

public abstract class ConjuntoCampos {
	protected ArrayList<CampoTabla> listaCampos;
	
	protected ConjuntoCampos() {
		listaCampos = new ArrayList<>();
	}
	
	protected abstract void insertarCampos();
	
	public ArrayList<CampoTabla> getListaCampos() {
		return listaCampos;
	}
}
