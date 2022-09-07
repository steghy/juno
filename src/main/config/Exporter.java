package main.config;

import java.io.IOException;

/**
 * Classe per la creazione di file di configurazione 
 * @author steghy
 */
public class Exporter {
	
	/**
	 * Preleva i dati dall'esportabile specificato e
	 * li salva in un file localizzato nella posizione
	 * specificata
	 * @param path il percorso
	 * @param obj l'esportabile
	 * @throws IOException 
	 */
	public static void write(String path, Exportable obj) throws IOException {
		DataPackage data = obj.provideData();
		MyJson.create(path, data);
	}
}
