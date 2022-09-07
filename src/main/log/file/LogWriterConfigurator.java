package main.log.file;

import java.io.IOException;
import java.time.LocalDateTime;

import main.util.PathGenerator;

/**
 * Classe per la configurazione del percorso di salvataggio del file di 
 * registro del programma.
 * @author steghy
 *
 */
public class LogWriterConfigurator {
	
	/** nome di default per la cartella dei logs */
	public static final String LOGS_DIR_NAME = ".logs";
	
	/** percorso di default per la cartella dei logs */
	public static final String DEF_LOGS_PATH = PathGenerator.generate(LOGS_DIR_NAME);
	
	public static final String DEF_BASE_FILE_NAME = "juno-log";
	
	private String localDateTime;
	
	/**
	 * il percorso in cui scrivere
	 */
	private String path;
	
	/** l'unica istanza di questa classe */
	private static LogWriterConfigurator instance;
	
	/**
	 * Costruisce l'oggetto e inizializza il percorso per il file
	 */
	private LogWriterConfigurator() {
		init();
	}
	
	/**
	 * Ritorna l'unica istanza di questa classe
	 * @return L'istanza
	 */
	public static LogWriterConfigurator getInstance() {
		if(instance == null) {
			instance = new LogWriterConfigurator();
		}
		return instance;
	}
	
	/**
	 * Ritorna il percorso in cui vengono salvati 
	 * attualmente i file log.
	 * @return Il percorso di un file
	 * @throws IOException 
	 */
	public String getPath() throws IOException {
		this.localDateTime = LocalDateTime.now().toString();
		return PathGenerator.generate(path, DEF_BASE_FILE_NAME.concat(localDateTime).concat(".log"));
	}
	
	/**
	 * Imposta il percorso del file in cui scrivere i log
	 * @param path Il percorso di un file
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	private void init() {
		path = DEF_LOGS_PATH;
	}
}
