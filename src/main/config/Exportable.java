package main.config;

import java.io.IOException;

/**
 * Interfaccia per classi che devono fornire dati
 * @author steghy
 *
 */
public interface Exportable {
	
	/**
	 * Fornisce i dati da esportare
	 * @return i dati
	 * @throws IOException 
	 */
	public DataPackage provideData() throws IOException;
}
