package main.config;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import main.util.Os;

/**
 * Classe per la creazione di dati
 * @author steghy
 *
 */
public class DataPackage {
	
	/** i nomi da usare come key per le mappe*/
	public static final String LOCAL_DATE_TIME = "local-date-time";
	public static final String OS = "os-name";
	public static final String ARCH = "arch";
	public static final String VERSION = "version";
	
	/** i metadati del pacchetto*/
	private String name;
	private String localDateTime;
	private String os;
	private String arch;
	private String version;
	
	
	/** i dati del pacchetto*/
	private Map<String, Object> data;

	
	/**
	 * Genera un pacchetto di dati composto soltanto dai
	 * metadati
	 * @param name Il nome
	 */
	public DataPackage(String name) {
		this.name = name;
	}

	
	/**
	 * Genera un pacchetto di dati contenente i metadati ed
	 * i dati
	 * @param name Il nome
	 * @param data I dati 
	 */
	public DataPackage(String name, Map<String, Object> data) {
		this.name = name;
		this.data = data;
	}
	
	
	/**
	 * Restituisce il nome del pacchetto
	 * @return Il nome
	 */
	public String getName() {
		return this.name;
	}

	
	/**
	 * Restituisce la data, l'ora e il tempo di creazione
	 * di questo pacchetto dati
	 * @return Data, temo, ora
	 */
	public String getLocalDateTime() {
		return this.localDateTime;
	}

	
	/**
	 * Restituisce l'os impostato su questo pacchetto
	 * @return
	 */
	public String getOs() {
		return this.os;
	}

	
	/**
	 * Ritorna l'architettura del sistema operativo
	 * impostato su questo oggetto
	 * @return L'architettura
	 */
	public String getArch() {
		return this.arch;
	}

	
	/**
	 * Ritorna la versione del sistema operativo 
	 * impostato su questo oggetto
	 * @return La versione
	 */
	public String getVersion() {
		return this.version;
	}

	
	/**
	 * Restituisce i dati di questo oggetto.
	 * @return I dati
	 */
	public Map<String, Object> getData() {
		return this.data;
	}

	
	/**
	 * Restituisce i metadati di questo oggetto
	 * @return I metadati
	 */
	public Map<String, Object> getMetadata(){
		
		//metadati map
		Map<String, Object> metadata = new HashMap<>();
		
		//inserimento
		metadata.put(LOCAL_DATE_TIME, this.localDateTime);
		metadata.put(OS, this.os);
		metadata.put(ARCH, this.arch);
		metadata.put(VERSION, this.version);
		
		return metadata;
	}

	
	/**
	 * Imposta l'ora, data e il tempo di questo oggetto
	 * @param localdateTime Data, ora e tempo
	 */
	public void setLocalDateTime(String localDateTime) {
		this.localDateTime = localDateTime;
	}

	
	/**
	 * imposta l'os
	 * @param os l'os
	 */
	public void setOs(String os) {
		this.os = os;
	}

	
	/**
	 * imposta l'architettura
	 * @param arch l'architettura
	 */
	public void setArch(String arch) {
		this.arch = arch;
	}

	
	/**
	 * imposta la versione
	 * @param version la versione
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	
	/**
	 * Imposta i dati di questo pacchetto 
	 * @param data I Dati
	 */
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	
	/**
	 * Imposta il nome di questo pacchetto dati
	 * @param name Una stringa
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	public void setMetadata() {
		localDateTime = LocalDateTime.now().toString();
		this.os = Os.getName();
		this.arch = Os.getArch();
		this.version = Os.getVersion();
	}
}
