package torneo;

import java.util.*;

public class Ronda {

	private List<Peleador> peleadores;
	private List<Peleador> ganadores;
	private List<Peleador> perdedores;
	
	//----------------------------Constructor----------------------------
	public Ronda() {
		super();
		this.peleadores = new ArrayList<Peleador>();
		this.ganadores = new ArrayList<Peleador>();
		this.perdedores = new ArrayList<Peleador>();
	}

	public Ronda(List<Peleador> peleadores, List<Peleador> ganadores, List<Peleador> perdedores) {
		super();
		this.peleadores = peleadores;
		this.ganadores = ganadores;
		this.perdedores = perdedores;
	}

	//----------------------------Métodos----------------------------
	
	//Inicia las peleas
	public void iniciarRonda() {
		for(int i=0; i<this.getPeleadores().size(); i+=2) {
			
	    	//peleadores
	    	Peleador peleador1 = this.getPeleadores().get(i);
	    	Peleador peleador2 = this.getPeleadores().get(i+1);
	    	
	    	//Ejecutamos pelea
	    	Peleador[] resultados = peleador1.pelear(peleador2);
	    	
	    	//Guardamos los ganadores y perdedores de la pelea
	    	this.getGanadores().add(resultados[0]);
	    	this.getPerdedores().add(resultados[1]);
	    }
	}
	
	public List<Peleador> getPeleadores() {
		return peleadores;
	}


	public void setPeleadores(List<Peleador> peleadores) {
		this.peleadores = peleadores;
	}


	public List<Peleador> getGanadores() {
		return ganadores;
	}


	public void setGanadores(List<Peleador> ganadores) {
		this.ganadores = ganadores;
	}


	public List<Peleador> getPerdedores() {
		return perdedores;
	}


	public void setPerdedores(List<Peleador> perdedores) {
		this.perdedores = perdedores;
	}
	
	
	
}
