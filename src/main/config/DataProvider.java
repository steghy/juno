package main.config;

import java.io.File;
import java.io.IOException;

/**
 * Classe per la fornitura di file di configurazione
 * @author steghy
 */

public class DataProvider {
	
	/**
	 * legge il file specificato dal percorso e lo ritorna
	 * come pacchetto dati
	 * @param path il percorso
	 * @return un Data
	 * @throws IOException
	 */
	public static DataPackage load(String path) throws IOException{
		
		File file = new File(path);
		
		//controllo esistenza file
		if(file.exists()){
			
			//controllo identità
			if(file.isFile()) {
				
				//controllo estensione
				if(path.endsWith(MyJson.JSON_EXTENSION)) {
					return MyJson.loadData(path);
				}
				else {
					throw new IllegalArgumentException("the file needs"
							+ "to be a json file");
				}
			}
			else {
				throw new IllegalArgumentException(path + " needs"
						+ "to be a file");
			}
		}
		else {
			throw new IOException("the file " + path 
					+ "not exists.");
		}
	}
}
