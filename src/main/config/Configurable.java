package main.config;

import java.io.IOException;

/**
 * Interfaccia per la configurazione di classi
 * con dati
 * @author steghy
 *
 */
public interface Configurable {
		
	//configura il configurabile con i dati
	public void configure(DataPackage data) throws IOException;
}
