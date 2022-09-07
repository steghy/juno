package main.model;

import java.io.File;
import java.io.IOException;

import main.config.DataProvider;
import main.config.Exporter;
import main.config.Loader;
import main.util.PathGenerator;

public class UserConfigurator {
	
	public static final String USER_DIR_NAME = ".users"; 
	public static final String DEF_USER_PATH = PathGenerator.generate(USER_DIR_NAME);
	
	/** 
	 * il percorso in cui salvare i 
	 * file di configurazione dell'utente
	 */
	private static String userPath = DEF_USER_PATH;
	
	private UserConfigurator() {
		
	}
	
	/**
	 * Configura lo user passato in input con il file specificato in input
	 * @param user Uno user
	 * @param fileName Il nome del file
	 * @throws IOException
	 */
	public static void configure(User user, String fileName) throws IOException {
		String filePath = PathGenerator.generate(userPath, fileName);
		Loader.load(DataProvider.load(filePath), user);
	}
	
	public static void export(User user, String fileName) throws IOException {
		String filePath = PathGenerator.generate(userPath, fileName);
		Exporter.write(filePath, user);
	}
	
	/**
	 * Imposta la cartella in cui salvare/prelevare i dati di configurazione dello user
	 * @param path Percorso di file
	 */
	public static void setUserPath(String path) {
		File file = new File(path);
		if(file.isDirectory()) {
			userPath = path;
		}
		else {
			throw new IllegalArgumentException("The specified path"
					+ "needs to be a directory");
		}
	}

}
