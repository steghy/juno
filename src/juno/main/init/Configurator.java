package juno.main.init;

/**
 * Configurator component.
 * 
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Configurator {
	
	/* The instance */
	private static Configurator instance;
	
	/* Singleton pattern */
	private Configurator() {}

	
	/**
	 * Returns the instance
	 * @return The instance
	 */
	static Configurator getInstance() {
		if(instance == null) {
			instance = new Configurator();
		} return instance;
	}
	
	
	/**
	 * Configura alcuni membri delle classi del programma
	 * mediante la lettura dei dati provenienti dai files
	 * contenuti nella libreria del programma.
	 */
	void configure() {
		// Qui sotto sono riportate le classi che dovranno essere
		// configurate dinamicamente durante l'inizializzazione
		// del programma.
		
		// MFrame
		// File
		// User (soltanto se presente almeno un profilo)
		// Sound
		// Video
		// Image
		
		/*
		 * Le impostazioni dello schermo (altezza e larghezza) vengono
		 * determinate dai valori contenuti all'interno delle variabili
		 * DMFrameWidth e DMFrameHeight presenti all'interno del file
		 * di configurazione (file 'config' localizzato nella libreria
		 * del gioco all'interno del percorso data/gf/).
		 */
	}

}
