package torneo;

public class Transformacion {
	private String nombre;
	private double danoExtra;
	private double vidaExtra;
	
	//----------------------------Constructor----------------------------
	public Transformacion(String nombre, double danoExtra, double vidaExtra) {
		super();
		this.nombre = nombre;
		this.danoExtra = danoExtra;
		this.vidaExtra = vidaExtra;
	}
	
	//----------------------------Métodos----------------------------
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getDanoExtra() {
		return danoExtra;
	}
	public void setDanoExtra(double danoExtra) {
		this.danoExtra = danoExtra;
	}
	public double getVidaExtra() {
		return vidaExtra;
	}
	public void setVidaExtra(double vidaExtra) {
		this.vidaExtra = vidaExtra;
	}
	
	
}
