package torneo;

public class TecnicaEspecial {

	private String nombre;
	private double dano;
	
	//----------------------------Constructor----------------------------	
	public TecnicaEspecial(String nombre, double dano) {
		super();
		this.nombre = nombre;
		this.dano = dano;
	}

	
	//----------------------------Métodos----------------------------
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public double getDano() {
		return dano;
	}


	public void setDano(double dano) {
		this.dano = dano;
	}
	
	
	
}