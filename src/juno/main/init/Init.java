package juno.main.init;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import juno.model.util.PathGenerator;

/**
 * Initializer.
 * Descrition here.
 * @author steghy
 * @email steghy.github@proton.me
 */
public class Init {
	
	/* Paths file */
	static final String PATHS = "paths";

	/* No instances, only one static method */
	private Init() {}
	
	static void init() throws Exception {
		/*
		 * Per ogni percorso definito all'interno
		 * degli oggetti della classe enumerativa Paths
		 * controllo l'esistenza di tali percorsi nel
		 * disco. Se uno o più percorsi non esistono
		 * gli oggetti vengono inseriti all'interno
		 * di una lista. Questa lista viene successivamente
		 * ispezionata e, se vengono rilevati oggetti
		 * che sono annotati con l'annotazione REQUIRED,
		 * viene eseguito lo strumento di recovery atto
		 * alla risoluzione di tali files mancanti
		 * scaricandoli da internet direttamente da uno
		 * dei server remoti disponibili listati 
		 * all'interno della classe enumerativa SERVER.
		 */
		
		
	}
}