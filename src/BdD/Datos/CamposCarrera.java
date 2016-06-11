package BdD.Datos;

public class CamposCarrera extends ConjuntoCampos{
	private CampoTabla idCarrera;
	private CampoTabla carrera;
	
	public CamposCarrera() {
		idCarrera = new CampoTabla("idCarrera");
		carrera =  new CampoTabla("Carrera");
	}

	@Override
	protected void insertarCampos() {
		listaCampos.add(idCarrera);
		listaCampos.add(carrera);
	}
	
	public CampoTabla getIdCarrera() {
		return idCarrera;
	}

	public void setIdCarrera(CampoTabla idCarrera) {
		this.idCarrera = idCarrera;
	}

	public CampoTabla getCarrera() {
		return carrera;
	}

	public void setCarrera(CampoTabla carrera) {
		this.carrera = carrera;
	}

	
	
	
}
