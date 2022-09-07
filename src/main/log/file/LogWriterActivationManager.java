package main.log.file;
/**
 * Classe per la gestione dell'abilitazione del
 * writer per i log.
 * @author steghy
 *
 */
public class LogWriterActivationManager {
	
	public static final boolean DEF_MAIN_STAT = false;
	
	/**
	 * Lo status di attivazione del writer
	 */
	private boolean status;
		
	/** l'unica istanza di questa classe */
	private static LogWriterActivationManager instance;
	
	/**
	 * Crea l'oggetto ed inizializza lo status
	 */
	private LogWriterActivationManager() {
		init();
	}
	
	/**
	 * Ritorna l'unica istanza di questa classe
	 * @return The activation manager
	 */
	public static LogWriterActivationManager getInstance() {
		if(instance == null) {
			instance = new LogWriterActivationManager();
		}
		return instance;
	}
	
	/**
	 * Ritorna lo stato di attivazione del writer
	 * @return Un booleano
	 */
	public boolean getStatus() {
		return this.status;
	}
	
	/**
	 * Imposta lo stato di attivazione del writer
	 * @param value Un booleano
	 */
	public void setStatus(boolean value) {
		this.status = value;
	}

	/**
	 * Inizializza i campi dell'oggetto con valori di default
	 */
	private void init() {
		this.status = DEF_MAIN_STAT;
	}
}
