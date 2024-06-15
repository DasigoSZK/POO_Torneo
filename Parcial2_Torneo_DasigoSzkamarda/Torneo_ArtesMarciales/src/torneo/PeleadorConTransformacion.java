package torneo;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PeleadorConTransformacion extends PeleadorConTecnica{
	
	
	private Transformacion transformacion;
	private boolean transformado;
	
	//----------------------------Constructor----------------------------
	//Constructor completo
	public PeleadorConTransformacion(String nombre, double puntosVida, double puntosVidaMax, double danoXsegundo,
			boolean tieneTecnicaEspecial, boolean puedeTransformarse, TecnicaEspecial tecnica, Transformacion transformacion) {
		super(nombre, puntosVida,puntosVidaMax , danoXsegundo, tieneTecnicaEspecial, puedeTransformarse, tecnica);
		this.transformacion = transformacion;
		this.transformado = false;
	}
	//Constructor sin transformacion
	public PeleadorConTransformacion(String nombre, double puntosVida, double puntosVidaMax, double danoXsegundo,
			boolean tieneTecnicaEspecial, boolean puedeTransformarse, TecnicaEspecial tecnica) {
		super(nombre, puntosVida, puntosVidaMax, danoXsegundo, tieneTecnicaEspecial, puedeTransformarse, tecnica);
		this.transformacion = new Transformacion("Poder Máximo", 1.2, 1.5);
		this.transformado = false;
	}
	//Constructor sin transformacion/tecnica
	public PeleadorConTransformacion(String nombre, double puntosVida, double puntosVidaMax, double danoXsegundo,
			boolean tieneTecnicaEspecial, boolean puedeTransformarse) {
		super(nombre, puntosVida, puntosVidaMax, danoXsegundo, tieneTecnicaEspecial, puedeTransformarse, new TecnicaEspecial("Bola de Energía", 100));
		this.transformacion = new Transformacion("Poder Máximo", 1.2, 1.5);
		this.transformado = false;
	}
	
	
	//----------------------------Métodos----------------------------
	
	//Se transforma multiplicando VIDA y DAÑO
	public void transformarse() {
		
		//Recupera toda su vitalidad
		this.setPuntosVida(this.getPuntosVidaMax());
		
		//Multiplica la vida del peleador
		this.setPuntosVida(this.getPuntosVida() * this.getTransformacion().getVidaExtra());
		//Multiplica el daño por segundo del peleador
		this.setDanoXsegundo(this.getDanoXsegundo() * this.getTransformacion().getDanoExtra());
		
		this.transformado = true;
	}
	
	//Vuelve a su estado base desde la transformación
	public void volverEstadoBase() {
		
		//Reduce su vida máxima
		this.setPuntosVida(this.getPuntosVida() / this.getTransformacion().getVidaExtra());
		
		//Reduce su daño por segundo
		this.setDanoXsegundo(this.getDanoXsegundo() / this.getTransformacion().getDanoExtra());
		
		this.transformado = false;
	}
	
	//SOBRESCRIBE el método pelear pero con TÉCNICA y TRANSFORMACION
	public Peleador[] pelear(Peleador contrincante) {
		
		boolean tecnica1 = false;
		boolean tecnica2 = false;
		boolean transformacionContrincante = false;
		boolean golpeCritico;
		
		//Array para guardar al ganador(pos 0) y al perdedor(pos 1)
		Peleador[] ganador_perdedor = new Peleador[2];
		String historialPelea = this.getNombre() + " VS " + contrincante.getNombre() + "\n";
		
		//Pelean hasta que uno se quede sin vida
		while(this.getPuntosVida() > 0 && contrincante.getPuntosVida() > 0) {
			
			//Peleador 1 golpea al Peleador 2
			if(this.getPuntosVida() > 0) {
				
				//Posibilidad de 20% de golpe crítico
				golpeCritico = (int)(Math.random() * 10) < 2;
				
				//Si es golpe CRÍTICO
				if(golpeCritico) {
					
					//Golpea un 50% mas fuerte
					contrincante.setPuntosVida(contrincante.getPuntosVida() - (this.getDanoXsegundo() * 1.50));
					if(contrincante.getPuntosVida() < 0) contrincante.setPuntosVida(0);
					historialPelea += this.getNombre() + " lanza un golpe 💥💥CRÍTICO💥💥"+ " (-" + (this.getDanoXsegundo() * 1.50) + " HP) "+ " a " 
							+ contrincante.getNombre() + " (" + contrincante.getPuntosVida() + "HP)\n";
					
				//Si es golpe NORMAL
				}else{		
					
					contrincante.setPuntosVida(contrincante.getPuntosVida() - this.getDanoXsegundo());
					if(contrincante.getPuntosVida() < 0) contrincante.setPuntosVida(0);
					historialPelea += this.getNombre() + " golpea"+ " (-" + this.getDanoXsegundo() + " HP) "+ " a " 
							+ contrincante.getNombre() + " (" + contrincante.getPuntosVida() + "HP)\n";
					
				}
				
			}
			
			//Peleador 2 golpea al Peleador 1
			if(contrincante.getPuntosVida() > 0) {	
				
				//Posibilidad de 20% de golpe crítico
				golpeCritico = (int)(Math.random() * 10) < 2;
				
				//Si es golpe CRÍTICO
				if(golpeCritico) {
					
					//Golpea un 50% mas fuerte
					this.setPuntosVida(this.getPuntosVida() - (contrincante.getDanoXsegundo()*1.50));
					if(this.getPuntosVida() < 0) this.setPuntosVida(0);
					historialPelea += contrincante.getNombre() + " lanza un golpe 💥💥CRÍTICO💥💥"+ " (-" + (contrincante.getDanoXsegundo()*1.50) + " HP) "+ " a " 
							+ this.getNombre() + " (" + this.getPuntosVida() + "HP)\n";
					
				//Si es golpe NORMAL
				}else {
					this.setPuntosVida(this.getPuntosVida() - contrincante.getDanoXsegundo());
					if(this.getPuntosVida() < 0) this.setPuntosVida(0);
					historialPelea += contrincante.getNombre() + " golpea"+ " (-" + contrincante.getDanoXsegundo() + " HP) "+ " a " 
							+ this.getNombre() + " (" + this.getPuntosVida() + "HP)\n";
				}
				
			}
			
			//Si tienen menos de 800HP, se TRANSFORMAN
			if(this.getPuntosVida() <= 800 && this.getPuntosVida() > 0 && !this.isTransformado()) {
				this.transformarse();
				historialPelea += "⬆️⬆️⬆️⬆️" + this.getNombre() + " se transforma en " + this.getTransformacion().getNombre()+ "⬆️⬆️⬆️⬆️\n";
			}
			if(contrincante.getPuntosVida() <= 800 && contrincante.getPuntosVida() > 0  
					&& contrincante.isPuedeTransformarse() && !transformacionContrincante) {
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
			if(contrincante.getPuntosVida() <= 500 && contrincante.getPuntosVida() > 0 
					&& contrincante.isTieneTecnicaEspecial() && !tecnica2) {
				contrincante.usarTecnica(this);
				if(this.getPuntosVida() < 0) this.setPuntosVida(0);
				tecnica2 = true;
				historialPelea += "💣💣💣💣" + contrincante.getNombre() + " utiliza \"" + contrincante.getTecnica().getNombre() + "\" sobre " + this.getNombre() 
				+ " (-" + contrincante.getTecnica().getDano() + "HP)" + "💣💣💣💣\n";
			}
		}
		
		//Vuelven a su estado base
		if(this.transformado) {
			this.volverEstadoBase();
		}
		if(contrincante.isPuedeTransformarse() && transformacionContrincante) {
			contrincante.volverEstadoBase();
		}
		
		if(this.getPuntosVida() <= 0) {
			//Gana el contrincante
			ganador_perdedor[0] = contrincante;
			ganador_perdedor[1] = this;
			historialPelea += "☠️☠️☠️" + this.getNombre() + " ya no es capaz de seguir peleando☠️☠️☠️ "
					+ "\n\n 🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️  " + contrincante.getNombre() + " es el GANADOR  🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️";
		}else {
			//Gana el peleador actual
			ganador_perdedor[0] = this;
			ganador_perdedor[1] = contrincante;	
			historialPelea += "☠️☠️☠️" + contrincante.getNombre() + " ya no es capaz de seguir peleando☠️☠️☠️ "
					+ "\n\n 🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️  " + this.getNombre() + " es el GANADOR  🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️🎖️";
		}
		
		JOptionPane.showMessageDialog(null, historialPelea, "Combate: " + this.getNombre() + " VS " + contrincante.getNombre(), JOptionPane.DEFAULT_OPTION,
				new ImageIcon(Torneo.class.getResource("/imagenes/anunciante.jpg")));
		return ganador_perdedor;
		
	}
	
	
	public Transformacion getTransformacion() {
		return transformacion;
	}
	public void setTransformacion(Transformacion transformacion) {
		this.transformacion = transformacion;
	}
	public boolean isTransformado() {
		return transformado;
	}
	public void setTransformado(boolean transformado) {
		this.transformado = transformado;
	}
	
	
	
	
}
