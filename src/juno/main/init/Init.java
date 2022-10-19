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

	/* Scanner component */
	private static Scanner scanner = Scanner.getInstance();
	
	/* Resolver component */
	private static Resolver resolver = Resolver.getInstance();
	
	/* Checker component */
	private static Checker checker = Checker.getInstance();
	
	/* No instances, only one static method */
	private Init() {}
	
	/**
	 * Metodo per l'inizializzazione del programma.
	 * In ordine, affinchè il programma possa funzionare,
	 * è necessario configurare, mediante la lettura di determinati
	 * file, alcune classi del programma. Si rende dunque necessario
	 * eseguire alcune operazioni preliminari che vengono eseguite 
	 * proprio da questo metodo. Le operazioni prima citate sono:
	 * - Controllo della presenza del file paths all'interno del disco.
	 * - Risoluzione dei problemi derivanti dall'eventuale assenza di
	 *   tale file all'interno del disco. In questo passaggio si effettua
	 *   prima una ricerca su punti specifici del disco, determinati dal tipo
	 *   di sistema operativo in cui è in esecuzione l'applicazione,
	 *   alla ricerca dei files necessari al programma e, successivamente,
	 *   nel caso in cui la ricerca non portasse alcun risultato positivo,
	 *   i files verrebbero scaricati da uno dei disponibili server
	 *   remoti (Github per esempio) i file necessari per la configurazione 
	 *   delle classi.
	 *   Ovviamente scaricati i file si rende necessaria la creazione del 
	 *   file 'paths' (ossia il file contenente in maniera esplicita la località
	 *   dei files utilizzati dal programma) per evitare di dover reiterare 
	 *   i passaggi precedenti al successivo riavvio del programma).
	 * - Configurazione delle classi in caso di esito positivo nella 
	 * 	 risoluzione dei precedenti passaggi.
	 * @throws Exception In caso in cui il metodo per la risoluzione
	 * 		   degli errori ritorna il valore booleano false.
	 */
	static void init() throws Exception {

	}
}