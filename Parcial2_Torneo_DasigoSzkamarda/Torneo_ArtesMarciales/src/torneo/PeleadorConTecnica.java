package torneo;

import javax.swing.JOptionPane;

public class PeleadorConTecnica extends Peleador{

	private TecnicaEspecial tecnica;

	//----------------------------Constructor----------------------------
	public PeleadorConTecnica(String nombre, double puntosVida, double puntosVidaMax, double danoXsegundo, boolean tieneTecnicaEspecial,
			boolean puedeTransformarse, TecnicaEspecial tecnica) {
		super(nombre, puntosVida, puntosVidaMax, danoXsegundo, tieneTecnicaEspecial, puedeTransformarse);
		this.tecnica = tecnica;
	}
	public PeleadorConTecnica(String nombre, double puntosVida, double puntosVidaMax, double danoXsegundo, boolean tieneTecnicaEspecial,
			boolean puedeTransformarse) {
		super(nombre, puntosVida, puntosVidaMax, danoXsegundo, tieneTecnicaEspecial, puedeTransformarse);
		this.tecnica = new TecnicaEspecial("Bola de Energía", 100);
	}
	
	//----------------------------Métodos----------------------------
	
	//Utiliza su técnica especial en el contricante
	public void usarTecnica(Peleador adversario) {
		//El adversario es dañado por la técnica
		adversario.setPuntosVida(adversario.getPuntosVida() - this.getTecnica().getDano());
	}
	
	//SOBRESCRIBE el método pelear pero con técnica especial
	public Peleador[] pelear(Peleador contrincante) {
		
		boolean tecnica1 = false;
		boolean tecnica2 = false;
		boolean transformacionContrincante = false;
		
		
		//Array para guardar al ganador(pos 0) y al perdedor(pos 1)
		Peleador[] ganador_perdedor = new Peleador[2];
		String historialPelea = this.getNombre() + " VS " + contrincante.getNombre() + "\n";
		
		//Pelean hasta que uno se quede sin vida
		while(this.getPuntosVida() > 0 && contrincante.getPuntosVida() > 0) {
			
			//Peleador 1 golpea al Peleador 2
			if(this.getPuntosVida() > 0) {				
				contrincante.setPuntosVida(contrincante.getPuntosVida() - this.getDanoXsegundo());
				if(contrincante.getPuntosVida() < 0) contrincante.setPuntosVida(0);
				historialPelea += this.getNombre() + " golpea"+ " (-" + this.getDanoXsegundo() + " HP) "+ " a " 
						+ contrincante.getNombre() + " (" + contrincante.getPuntosVida() + "HP)\n";
			}
			
			//Peleador 2 golpea al Peleador 1
			if(contrincante.getPuntosVida() > 0) {				
				this.setPuntosVida(this.getPuntosVida() - contrincante.getDanoXsegundo());
				if(this.getPuntosVida() < 0) this.setPuntosVida(0);
				historialPelea += contrincante.getNombre() + " golpea"+ " (-" + contrincante.getDanoXsegundo() + " HP) "+ " a " 
						+ this.getNombre() + " (" + this.getPuntosVida() + "HP)\n";
			}
			
			//Si el contrincante puede transformarse y tiene menos de 800HP, se TRANSFORMA  
			if(contrincante.getPuntosVida() <= 800 && contrincante.isPuedeTransformarse() && !transformacionContrincante) {
				contrincante.transformarse();
				transformacionContrincante = true;
				historialPelea += "⬆️⬆️⬆️⬆️" + contrincante.getNombre() + " se transforma en " 
				+ contrincante.getTransformacion().getNombre() + "⬆️⬆️⬆️⬆️\n";
			}
			
			//Si tienen menos del 500HP, ejecutan sus TÉCNICAS ESPECIALES
			if(this.getPuntosVida() <= 500 && this.getPuntosVida() > 0 && !tecnica1) {
				this.usarTecnica(contrincante);
				if(contrincante.getPuntosVida() < 0) contrincante.setPuntosVida(0);
				tecnica1 = true;
				historialPelea += "💣💣💣💣" + this.getNombre() + " utiliza \"" + this.getTecnica().getNombre() + "\" sobre " + contrincante.getNombre() 
				+ " (-" + this.getTecnica().getDano() + "HP)" + "💣💣💣💣\n";
			}
			if(contrincante.getPuntosVida() <= 500 && contrincante.getPuntosVida() > 0 && contrincante.isTieneTecnicaEspecial() && !tecnica2) {
				contrincante.usarTecnica(this);
				if(this.getPuntosVida() < 0) this.setPuntosVida(0);
				tecnica2 = true;
				historialPelea += "💣💣💣💣" + contrincante.getNombre() + " utiliza \"" + contrincante.getTecnica().getNombre() + "\" sobre " + this.getNombre() 
				+ " (-" + contrincante.getTecnica().getDano() + "HP)" + "💣💣💣💣\n";
			}
		}
		
		//Vuelven a su estado base
		if(contrincante.isPuedeTransformarse() && transformacionContrincante) {
			contrincante.volverEstadoBase();
		}
		
		if(this.getPuntosVida() <= 0) {
			//Gana el contrincante
			ganador_perdedor[0] = contrincante;
			ganador_perdedor[1] = this;
			historialPelea += "☠️☠️☠️" + this.getNombre() + " ya no es capaz de seguir peleando☠️☠️☠️"
					+ "\n\n 🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️  " + contrincante.getNombre() + " es el GANADOR  🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️";
		}else {
			//Gana el peleador actual
			ganador_perdedor[0] = this;
			ganador_perdedor[1] = contrincante;	
			historialPelea += "☠️☠️☠️" + contrincante.getNombre() + " ya no es capaz de seguir peleando☠️☠️☠️"
					+ "\n\n 🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️  " + this.getNombre() + " es el GANADOR  🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️";
		}
		
		JOptionPane.showMessageDialog(null, historialPelea);
		return ganador_perdedor;
		
	}
	
	//Vuelve a su estado base desde la transformación
	public void volverEstadoBase() {}
	
	public TecnicaEspecial getTecnica() {
		return tecnica;
	}
	
	public void setTecnica(TecnicaEspecial tecnica) {
		this.tecnica = tecnica;
	}
	
	
}