package torneo;

import java.util.*;

import javax.swing.*;

public class Torneo {

	private List<Ronda> rondas;
	private List<Peleador> concursantes;
	private Peleador ganador;
	
	//----------------------------Constructor----------------------------
	public Torneo() {
		super();
		this.rondas = new ArrayList<Ronda>();
		this.ganador = ganador;
		this.concursantes = new ArrayList<Peleador>();
	}
	public Torneo(List<Peleador> concursantes) {
		super();
		this.rondas = new ArrayList<Ronda>();
		this.ganador = ganador;
		this.concursantes = concursantes;
	}

	//----------------------------Métodos----------------------------
	
	// Menú con todos los personajes disponibles
    public void iniciarTorneo(List<Peleador> peleadores) {
    	
        // Creamos las rondas
    	this.rondas.add(new Ronda());
		this.rondas.add(new Ronda());
		this.rondas.add(new Ronda());
		this.rondas.add(new Ronda());

        // Cargamos los nombres de peleadores a una lista de strings
        List<String> peleadoresSeleccionables = new ArrayList<>();
        for (Peleador peleador : peleadores) {
            peleadoresSeleccionables.add(peleador.getNombre());
        }

        // --------------------Seleccionamos 16 peleadores-------------------------
        int cont = 0;
        String seleccionados = "Peleadores seleccionados:\n";
        while (cont < 16) {

            // Creamos un JComboBox para seleccionar los personajes
            JComboBox<String> comboBox = new JComboBox<>(peleadoresSeleccionables.toArray(new String[0]));

            // Creamos un JPanel para contener el el textpane y el combobox
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            JTextPane textPane = new JTextPane();
            textPane.setText(seleccionados);
            textPane.setEditable(false);
            panel.add(textPane);
            panel.add(comboBox);

            int selecActual = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Selecciona 1 peleador " + (cont + 1) + "/16",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE
            );

            // Obtenemos el peleador seleccionado
            if (selecActual == JOptionPane.OK_OPTION) {
            	
            	//Buscamos la instancia del Peleador que coincida con el nombre el combobox
                String nombrePeleador = (String) comboBox.getSelectedItem();
                Peleador peleadorSeleccionado = buscarPeleador(peleadores, nombrePeleador);
                // Añadimos el peleador a la 1era ronda
                this.rondas.get(0).getPeleadores().add(peleadorSeleccionado);
                cont++;
                //Lo sumamos a la lista de seleccionados
                int indexSeleccionado = peleadoresSeleccionables.indexOf(nombrePeleador);
                seleccionados += cont + "_" + peleadoresSeleccionables.get(indexSeleccionado) + "\n";
                // Lo borramos del combobox
                peleadoresSeleccionables.remove(indexSeleccionado);
                
            } else {
            	//Si el usuario no seleccionó los 16 peleadores necesarios
            	int cancelarTorneo = JOptionPane.showConfirmDialog(null, "Aún no has seleccionado a los 16 peleadores para el torneo."
            			+ "\n¿Estas seguro que deseas cancelar el torneo?", "Torneo de Artes Marciales", JOptionPane.YES_NO_OPTION);
            	if(cancelarTorneo == JOptionPane.YES_OPTION) {            		
            		System.exit(0);; // Salir del bucle
            	}
            	
            }   
        }
        //------------------------------------------------------------------------------------
        
        //Mostramos todos los participantes de la 1er ronda
        String participantes = "Participantes de la 1era Ronda:\n";
        for(int i=0; i<this.getRondas().get(0).getPeleadores().size(); i++) {
        	Peleador peleadorActual = this.getRondas().get(0).getPeleadores().get(i);
        	participantes += (i+1) + "_" + peleadorActual.getNombre() + "\n";
        }
        JOptionPane.showMessageDialog(null, participantes);
        
        //Los mezclamos para armar los combates aleatoriamente
        sortearCombates(this.getRondas().get(0), 1);
        
        
    }
    
    //Busca un PELEADOR por su NOMBRE
    private static Peleador buscarPeleador(List<Peleador> peleadores, String nombre) {
    	
    	//Busca el nombre del pelador en la lista de peleadores
    	for(int i=0; i<peleadores.size(); i++) {
    		Peleador peleadorActual = peleadores.get(i);
    		if(peleadorActual.getNombre().equals(nombre)) {
    			return peleadorActual;
    		}
    	}
    	
    	return null;
    }
    
    //Genera combates aleatorios mezclando los peleadores
    public static void sortearCombates(Ronda ronda, int numRonda) {
    	
    	//Mezcla los peleadores
    	Collections.shuffle(ronda.getPeleadores());
        String combates = "Combates de la "+numRonda+"° Ronda:\n\n";
        int contador = 1;
        for(int i=0; i<ronda.getPeleadores().size(); i+=2) {
        	Peleador peleadorActual = ronda.getPeleadores().get(i);
        	Peleador peleadorSiguiente = ronda.getPeleadores().get(i+1);
        	combates += "Combate " + contador + ": " + peleadorActual.getNombre() + " VS " + peleadorSiguiente.getNombre() + "\n";
        	contador ++;
        }
        JOptionPane.showMessageDialog(null, combates);
    	
    }
	
	//Pasa los GANADORES a la siguiente ronda y RECARGA SUS ENERGÍAS
	public void pasarSiguienteRonda(List<Peleador> ganadores, int ronda) {
		
		System.out.println();
		System.out.println("Ronda " + ronda + ":");
		for(Peleador ganador : ganadores) {
			//Pasa ronda
			this.getRondas().get(ronda).getPeleadores().add(ganador);
			//Recarga el HP (vida) del peleador
			ganador.comerSemillaDelHermitano();
		}
		
	}
	
	//Muestra los peleadores de una ronda
	public static void mostrarGanadoresRonda(List<Peleador> peleadores, int ronda) {
		
		String fichaPeleadores = "Ronda " + ronda + ":\n";
		for(int i=0; i<peleadores.size(); i++) {
			fichaPeleadores += (i+1) + "_" + peleadores.get(i).getNombre() + "\n";
		}
		
		JOptionPane.showMessageDialog(null, fichaPeleadores);
	}
	
	//Muestra el ganador
	public void mostrarGanadorTorneo() {
		
		if(this.getGanador() != null) {
			
			String ganador = "";
			ganador = "🏆".repeat(this.getGanador().getNombre().length()*3) + "\n";
			ganador += 	"🏆".repeat(this.getGanador().getNombre().length()) 
					+ "🏆  " + this.getGanador().getNombre().toUpperCase() + "  🏆" 
					+ "🏆".repeat(this.getGanador().getNombre().length()) + "\n";
			ganador += "🏆".repeat(this.getGanador().getNombre().length()*3) + "\n";
			JOptionPane.showMessageDialog(null, ganador);
			
		}else {
			JOptionPane.showMessageDialog(null, "Aún no tenemos un ganador para este torneo.\n¡¡Que empiecen los combates!!");
		}
		
	}
	
	public List<Ronda> getRondas() {
		return rondas;
	}

	public void setRondas(List<Ronda> rondas) {
		this.rondas = rondas;
	}

	public Peleador getGanador() {
		return ganador;
	}

	public void setGanador(Peleador ganador) {
		this.ganador = ganador;
	}

	public List<Peleador> getConcursantes() {
		return concursantes;
	}

	public void setConcursantes(List<Peleador> concursantes) {
		this.concursantes = concursantes;
	}
	
	
	
	
}