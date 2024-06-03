package main;

import java.util.*;

import javax.swing.JOptionPane;

import torneo.*;

public class Main {
	
	public static void main(String[] args) {
		
		/*-------------------- Generaciónes estáticas para el MENÚ  --------------------*/
		
		// Generamos TODAS las TenicasEspeciales
	    TecnicaEspecial kamehameha = new TecnicaEspecial("Kamehameha", 500);
	    TecnicaEspecial finalFlash = new TecnicaEspecial("Final Flash", 450);
	    TecnicaEspecial eraserCannon = new TecnicaEspecial("Eraser Cannon", 400);
	    TecnicaEspecial bigBangKamehameha = new TecnicaEspecial("Big Bang Kamehameha", 1500);
	    TecnicaEspecial masenko = new TecnicaEspecial("Masenko", 400);
	    TecnicaEspecial makankosappo = new TecnicaEspecial("Makankosappo", 500);
	    TecnicaEspecial kienzan = new TecnicaEspecial("Kienzan", 300);
	    TecnicaEspecial wolfFangFist = new TecnicaEspecial("Wolf Fang Fist", 180);
	    TecnicaEspecial kikoho = new TecnicaEspecial("Kikoho", 220);
	    TecnicaEspecial chocolateBeam = new TecnicaEspecial("Chocolate Beam", 300);
	    TecnicaEspecial kamehamehaRoshi = new TecnicaEspecial("Kamehameha", 350);
	    TecnicaEspecial barreiraDeEnergia = new TecnicaEspecial("Barreira de Energía", 350);
	    TecnicaEspecial powerImpact = new TecnicaEspecial("Power Impact", 250);
	    TecnicaEspecial hakai = new TecnicaEspecial("Hakai", 2500);
	    TecnicaEspecial supernova = new TecnicaEspecial("Supernova", 400);
	    TecnicaEspecial agujaDeVeneno = new TecnicaEspecial("Aguja de Veneno", 400);
	    TecnicaEspecial riotJavelin = new TecnicaEspecial("Riot Javelin", 400);
	    TecnicaEspecial finalKamehameha = new TecnicaEspecial("Final Kamehameha", 1400);
	    TecnicaEspecial espadaDeTapion = new TecnicaEspecial("Espada de Tapion", 300);
	    TecnicaEspecial hellsFlash = new TecnicaEspecial("Hell's Flash", 300);
	    TecnicaEspecial tiraPiedra = new TecnicaEspecial("TiraPiedra", 50);
	    TecnicaEspecial negativeKarmaBall = new TecnicaEspecial("Negative Karma Ball", 1000);
	    TecnicaEspecial dodonpa = new TecnicaEspecial("Dodonpa", 400);
	    TecnicaEspecial bodyChange = new TecnicaEspecial("Body Change", 0);

	    // Generamos TODAS las Transformaciones
	    Transformacion superSaiyajin = new Transformacion("Super Saiyajin", 2, 2);
	    Transformacion superSaiyajin2 = new Transformacion("Super Saiyajin 2", 5, 5);
	    Transformacion superSaiyajin4 = new Transformacion("Super Saiyajin 4", 10, 10);
	    Transformacion misticGohan = new Transformacion("Mistic Gohan", 6, 6);
	    Transformacion superSaiyajinLegendario = new Transformacion("Super Saiyajin Legendario", 4, 4);
	    Transformacion orangePiccolo = new Transformacion("Orange Piccolo", 2.5, 2.5);
	    Transformacion kidBoo = new Transformacion("Kid Boo", 4, 4);
	    Transformacion maxPower = new Transformacion("Max Power", 2.5, 2.5);
	    Transformacion goldenFreezer = new Transformacion("Golden Freezer", 4, 4);
	    Transformacion metaCooler = new Transformacion("Meta-Cooler", 2.5, 2.5);
	    Transformacion formaFinal = new Transformacion("Forma Final", 2.5, 2.5);
	    Transformacion formaPerfecta = new Transformacion("Forma Perfecta", 4, 4);

	    // Generamos TODOS los peleadores
	    Peleador goku = new PeleadorConTransformacion("Goku", 1100, 1100, 150, true, true, kamehameha, superSaiyajin4);
	    Peleador vegeta = new PeleadorConTransformacion("Vegeta", 1000, 1000, 145, true, true, finalFlash, superSaiyajin4);
	    Peleador broly = new PeleadorConTransformacion("Broly", 2000, 2000, 160, true, true, eraserCannon, superSaiyajinLegendario);
	    Peleador gogeta = new PeleadorConTransformacion("Gogeta", 2000, 2000, 155, true, true, bigBangKamehameha, superSaiyajin4);
	    Peleador gohan = new PeleadorConTransformacion("Gohan", 1800, 1800, 140, true, true, masenko, misticGohan);
	    Peleador piccolo = new PeleadorConTransformacion("Piccolo", 1250, 1250, 130, true, true, makankosappo, orangePiccolo);
	    Peleador krillin = new PeleadorConTecnica("Krillin", 1000, 1000, 100, true, false, kienzan);
	    Peleador yamcha = new PeleadorConTecnica("Yamcha", 1000, 1000, 95, true, false, wolfFangFist);
	    Peleador tenShinHan = new PeleadorConTecnica("Ten Shin Han", 1000, 1000, 110, true, false, kikoho);
	    Peleador majinBoo = new PeleadorConTransformacion("Majin Boo", 2000, 2000, 150, true, true, chocolateBeam, kidBoo);
	    Peleador roshi = new PeleadorConTransformacion("Roshi", 1000, 1000, 120, true, true, kamehamehaRoshi, maxPower);
	    Peleador androide17 = new PeleadorConTecnica("Androide 17", 1250, 1250, 130, true, false, barreiraDeEnergia);
	    Peleador androide18 = new PeleadorConTecnica("Androide 18", 1250, 1250, 125, true, false, barreiraDeEnergia);
	    Peleador goten = new PeleadorConTransformacion("Goten", 1200, 1200, 130, true, true, kamehameha, superSaiyajin2);
	    Peleador trunks = new PeleadorConTransformacion("Trunks", 1200, 1200, 135, true, true, new TecnicaEspecial("Burning Attack", 250), superSaiyajin2);
	    Peleador jiren = new PeleadorConTecnica("Jiren", 2500, 2500, 170, true, false, powerImpact);
	    Peleador toppo = new PeleadorConTecnica("Toppo", 2000, 2000, 165, true, false, hakai);
	    Peleador freezer = new PeleadorConTransformacion("Freezer", 1900, 1900, 160, true, true, supernova, goldenFreezer);
	    Peleador cooler = new PeleadorConTransformacion("Cooler", 1500, 1500, 155, true, true, supernova, metaCooler);
	    Peleador frost = new PeleadorConTransformacion("Frost", 1400, 1400, 150, true, true, agujaDeVeneno, formaFinal);
	    Peleador beerus = new PeleadorConTecnica("Beerus", 3500, 3500, 180, true, false, hakai);
	    Peleador bardock = new PeleadorConTransformacion("Bardock", 1200, 1200, 140, true, true, riotJavelin, superSaiyajin);
	    Peleador vegito = new PeleadorConTransformacion("Vegetto", 1000, 1000, 160, true, true, finalKamehameha, superSaiyajin4);
	    Peleador cell = new PeleadorConTransformacion("Cell", 1900, 1900, 150, true, true, kamehameha, formaPerfecta);
	    Peleador tapion = new PeleadorConTecnica("Tapion", 1000, 1000, 135, true, false, espadaDeTapion);
	    Peleador androide16 = new PeleadorConTecnica("Androide 16", 1300, 1300, 140, true, false, hellsFlash);
	    Peleador mrSatan = new PeleadorConTecnica("MrSatan", 500, 500, 90, true, false, tiraPiedra);
	    Peleador dragon1Estrella = new PeleadorConTecnica("Dragon de 1 estrella", 2500, 2500, 150, true, false, negativeKarmaBall);
	    Peleador taoPaiPai = new PeleadorConTecnica("Tao Pai Pai", 1400, 1400, 110, true, false, dodonpa);
	    Peleador capitanGinyu = new PeleadorConTecnica("Capitán Ginyu", 1200, 1200, 120, true, false, bodyChange);

	    //Lista con todos los peleadores disponibles
	    List<Peleador> peleadores = Arrays.asList(
	            goku, vegeta, broly, gogeta, gohan, piccolo, krillin, yamcha, tenShinHan, majinBoo, roshi, androide17, androide18,
	            goten, trunks, jiren, toppo, freezer, cooler, frost, beerus, bardock, vegito, cell, tapion, androide16, mrSatan,
	            dragon1Estrella, taoPaiPai, capitanGinyu);
	    
	    /*-------------------------------------------------------------------------------------------------------------------------*/
	    
	    
	    // Creamos el torneo  
	    Torneo torneo = new Torneo(peleadores);
	    
	    //Interfaz para seleccionar los peleadores participantes
	    torneo.iniciarTorneo(peleadores);
	    
	    
	    //----1era RONDA----
	    torneo.getRondas().get(0).iniciarRonda();
	    //Pasamos los GANADORES a la 2da ronda
	    torneo.pasarSiguienteRonda(torneo.getRondas().get(0).getGanadores(), 1);
	    
	    //----2da / 3era / 4ta ronda----
	    for(int i=1; i<=3; i++) {
	    	//Muestra los ganadores de la ronda anterior
	    	Torneo.mostrarGanadoresRonda(torneo.getRondas().get(i).getPeleadores(), i+1);
	    	//Iniciamos la siguiente ronda
	    	Torneo.sortearCombates(torneo.getRondas().get(i), i+1);
	    	torneo.getRondas().get(i).iniciarRonda();
    		//Pasamos los ganadores de la RONDA ACTUAL a la SIGUIENTE
	    	if(i < 3) torneo.pasarSiguienteRonda(torneo.getRondas().get(i).getGanadores(), i+1);
	    	//Guardamos el GANADOR
	    	if(i == 3) torneo.setGanador(torneo.getRondas().get(3).getGanadores().get(0));
	    }
	    
	    //Mostramos el GANADOR DEL TORNEO
	    torneo.mostrarGanadorTorneo();
	    
	}

	
}