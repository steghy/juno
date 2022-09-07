package main.config;

import java.io.IOException;

/**
 * Classe per l'impostazione di stati con dati
 * @author steghy
 *
 */
public class Loader {
	
	/**
	 * imposta il configurabile specificato con il 
	 * pacchetto dati fornito
	 * @param data i dati
	 * @param obj il configurabile
	 * @throws IOException 
	 */
	public static void load(DataPackage data, Configurable obj) throws IOException {
		obj.configure(data);
	}
}
