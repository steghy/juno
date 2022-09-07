package main.util;

/**
 * Fornisce informazioni sul sistema operativo in cui
 * è in esecuzione il programma.
 * @author steghy
 */
public class Os {
	
	/**
	 * Ritorna il nome del sistema operativo della
	 * macchina il cui è in esecuzione il programma.
	 * @return Il nome del sistema operativo 
	 */
	public static String getName() {
		return System.getProperty("os.name");
	}
	
	/**
	 * Restituisce la versione del sistema operativo in
	 * uso nella macchina in cui è in esecuzione il
	 * programma.
	 * @return La versione del sistema operativo.
	 */
	public static String getVersion() {
		return System.getProperty("os.version");
	}
	
	/**
	 * Restituisce la architettura del sistema operativo
	 * in uso nella macchina in cui è in esecuzione il
	 * programma.
	 * @return L'architettura del sistema operativo.
	 */
	public static String getArch() {
		return System.getProperty("os.arch");
	}
	
	/**
	 * Ritorna true se il sistema operativo della
	 * macchina in cui è in esecuzione il programma
	 * è Windows, altrimenti restituisce il valore
	 * booleano false.
	 * @return Un booleano.
	 */
	public static boolean isWindows() {
		return getName().startsWith("Linux");
	}
	
	/**
	 * Ritorna true se il sistema operativo della macchina
	 * in cui è in esecuzione questo programma è Linux, altrimenti
	 * restituisce il valore booleano false.
	 * @return Un booleano
	 */
	public static boolean isLinux() {
		return getName().startsWith("Linux");
	}
	
	/**
	 * Ritorna true sse il sistema operativo della macchina
	 * in cui è in esecuzione questo programma è Mac OS X, altrimenti
	 * restituisce il valore booleano false.
	 * @return Un booleano
	 */
	public static boolean isMac() {
		return getName().startsWith("Mac OS X");
	}
	
	/**
	 * Restituisce il percorso della directory in cui è in
	 * esecuzione il programma
	 * @return Un percorso di file
	 */
	public static String getCurrentPath() {
		return System.getProperty("user.dir");
	}
}
